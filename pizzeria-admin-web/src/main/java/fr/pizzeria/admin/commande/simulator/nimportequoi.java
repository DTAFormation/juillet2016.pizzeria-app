package fr.pizzeria.admin.commande.simulator;

import java.text.DateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.enterprise.concurrent.ContextService;

@Singleton
@Startup
public class nimportequoi {

//	@Resource
//	TimerService timerService;
	
	@Resource 
	SessionContext ctx;

	private DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);

	@PostConstruct
	public void creerTimer() {
		Logger.getLogger(nimportequoi.class.getName()).log(Level.INFO, "Creation du Timer");
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String s = bundle.getString("timer.second");
		String m = bundle.getString("timer.minute");
		String h = bundle.getString("timer.hour");

		ScheduleExpression expression = new ScheduleExpression();
		expression.second(s).minute(m).hour(h);
		Timer timer = ctx.getTimerService().createCalendarTimer(expression);

	}

	@Timeout
	public void execute(Timer timer) {
		Logger.getLogger(nimportequoi.class.getName()).log(Level.INFO,
				"Execution du traitement toutes les 10 secondes " + mediumDateFormat.format(new Date()));
	}
}
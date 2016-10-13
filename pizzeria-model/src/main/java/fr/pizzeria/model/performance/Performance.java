package fr.pizzeria.model.performance;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="performance")
public class Performance {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String service;
    private Date date;
    @Column(name="temps_execution")
    private Long tempsExecution;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Long getTempsExecution() {
        return tempsExecution;
    }

    public void setTempsExecution(Long tempsExecution) {
        this.tempsExecution = tempsExecution;
    }

    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
    public String toString() {
        return "Performance{" +
                "id=" + id +" date = " + date + 
                ", service='" + service + '\'' +
                ", tempsExecution=" + tempsExecution +
                '}';
    }
}

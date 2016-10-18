package fr.pizzeria.admin.metier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fr.pizzeria.model.Client;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

	@Mock
	private EntityManager em;

	@Mock
	private TypedQuery<Client> query;

	private ClientService service;

	@Before
	public void setUp() {
		service = new ClientService();
		service.setEm(em);
	}

	@Test
	public void testFindAll() throws GeneralSecurityException {
		Client c1 = new Client("test", "test", "test@test.fr", "", "10 av aa", "00000000");
		Client c2 = new Client("test2", "test2", "test@test.fr", "", "10 av aa", "00000000");
		List<Client> listeClientsAttendus = Arrays.asList(c1,c2);
		when(em.createQuery("select c from Client c", Client.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(listeClientsAttendus);
		
		
		List<Client> listeClientsObtenue = service.findAll();
		
		
		assertEquals(listeClientsObtenue.size(), listeClientsAttendus.size());
	}

	@Test
	public void testFindOneClient() throws GeneralSecurityException {

		Client c1 = new Client("test", "test", "test@test.fr", "rien", "10 av aa", "00000000");
		when(em.createQuery("select c from Client c where c.email=:email", Client.class))
				.thenReturn(query);
		when(query.setParameter("email", "test@test.fr")).thenReturn(query);
		when(query.getSingleResult()).thenReturn(c1);

		Client c2 = service.findOneClient("test@test.fr");
		assertTrue(c1.equals(c2));
	}

	@Test
	public void testUpdateClient() throws GeneralSecurityException {

		Client c1 = new Client("test", "test", "test@test.fr", "", "10 av aa", "00000000");
		
		when(em.createQuery("select c from Client c where c.email=:email", Client.class))
				.thenReturn(query);
		when(query.setParameter("email", "test@test.fr")).thenReturn(query);
		when(query.getSingleResult()).thenReturn(c1);
		
		
		service.updateClient("test@test.fr", c1);

		verify(em).merge(c1);
		
	}

	@Test
	public void testSaveClient() throws GeneralSecurityException {
		Client client = new Client("test", "test", "test@test.fr", "", "10 av aa", "00000000");

		service.saveClient(client);

		verify(em).persist(client);
	}

	@Test
	public void testDeleteClient() throws GeneralSecurityException {
		Client client = new Client(1, "test", "test", "test@test.fr", "", "10 av aa", "00000000");
		when(em.createQuery("select c from Client c where c.email=:email", Client.class))
				.thenReturn(query);
		when(query.setParameter("email", "test@test.fr")).thenReturn(query);
		when(query.getSingleResult()).thenReturn(client);
		
		service.deleteClient("test@test.fr");

		
	}

	@Test
	public void hardDeleteClients() throws GeneralSecurityException {
		List<Client> clients = new ArrayList<>();
		Client client = new Client(1, "test", "test", "test@test.fr", "", "10 av aa", "00000000");
		client.setActif(false);
		clients.add(client);
		when(em.createQuery("select c from Client c where  actif = false", Client.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(clients);
		service.hardDeleteClients();

		verify(em).remove(client);
		assertFalse(client.isActif());
	}

}

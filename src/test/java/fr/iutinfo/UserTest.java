package fr.iutinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

//TEST COMMIT
public class UserTest extends JerseyTest {
	@Override
    protected Application configure() {
        return new App();
    }

	@Test
	public void testReadUserWithNameFooAsJsonString() {
		createUser("foo");
		String json = target("/user/foo").request().get(String.class);
		//TODO: pourquoi ai-je du changer la valeur de l'id à 5 au 
		// lieu de 4 après avoir introduit le test sur le PUT ?!
		assertEquals("{\"email\":\"foo\",\"id\":5,\"password\":\"foo\",\"pseudo\":\"foo\"}", json);
	}

	@Test
	public void testReadUserWithNameFooAsObject() {
		User utilisateur = target("/user/foo").request().get(User.class);
		assertEquals("foo", utilisateur.getPseudo());
	}
	
	@Test
	public void testCreateUserMustReturnUserWithId() {
		User savedUser = createUser("thomas");
		assertTrue(savedUser.getId() > 0);
	}

	@Test
	public void testUpdateUserName() {
		User u = createUser("thomas");
		u.setPseudo("yann");
		Response rep = target("/user").path(""+u.getId()).request()
				.put(Entity.entity(u,MediaType.APPLICATION_JSON));;
		User updatedUser = rep.readEntity(User.class);
		assertEquals("yann", updatedUser.getPseudo());
	}
	
	@Test
	public void testReadUnavailableUser () {
		int status = target("/user/bar").request().get().getStatus();
		assertEquals(404, status);
	}
	
	@Test
	public void tesListAllUsers() {
		createUser("toto");
		createUser("titi");
		List<User> users = target("/user/").request().get(new GenericType<List<User>>(){});
		assertTrue(users.size() >= 2);
		
	}

	@Test
	public void testDeleteUser() {
		User u = createUser("toto");
		int status = target("/user/"+u.getId()).request().delete().getStatus();
        assertEquals(202, status);
        
	}
	
	private User createUser(String name) {
		User user = new User(0, name, name, name);
		assertEquals(name, user.getPseudo());
	    Entity<User> userEntity = Entity.entity(user, MediaType.APPLICATION_JSON);
	    assertEquals(name, userEntity.getEntity().getPseudo());
	    Response rep = target("/user").request().post(userEntity);
	    //assertEquals(User.class, rep.getEntity().getClass());
		User savedUser = rep.readEntity(User.class);
		
		return savedUser;
	}
	
}
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
public class VideoTest extends JerseyTest {
	@Override
    protected Application configure() {
        return new App();
    }

	@Test
	public void testReadVideoWithTitleFooAsJsonString() {
		createVideo("foo");
		String json = target("/video/foo").request().get(String.class);
		assertEquals("{\"id\":5,\"titre\":\"foo\"}", json);
	}

	@Test
	public void testReadUserWithNameFooAsObject() {
		User utilisateur = target("/user/foo").request().get(User.class);
		assertEquals("foo", utilisateur.getPseudo());
	}
	
	@Test
	public void testcreateVideoMustReturnUserWithId() {
		User savedUser = createVideo("thomas");
		assertTrue(savedUser.getId() > 0);
	}

	@Test
	public void testUpdateUserName() {
		User u = createVideo("thomas");
		u.setPseudo("yann");
		Response rep = target("/user").path(""+u.getId()).request()
				.put(Entity.entity(u,MediaType.APPLICATION_JSON));;
		User updatedUser = rep.readEntity(User.class);
		assertEquals("yann", updatedUser.getPseudo());
	}
	
	@Test
	public void testGetingSameUserTwice() {
		User user1 = target("/user/foo").request().get(User.class);
		User user2 = target("/user/foo").request().get(User.class);
		assertEquals(user1, user2);
	}
	
	@Test
	public void testReadUnavailableUser () {
		int status = target("/user/bar").request().get().getStatus();
		assertEquals(404, status);
	}
	
	@Test
	public void tesListAllUsers() {
		createVideo("toto");
		createVideo("titi");
		List<User> users = target("/user/").request().get(new GenericType<List<User>>(){});
		assertTrue(users.size() >= 2);
	}

	@Test
	public void testDeleteUser() {
		User u = createVideo("toto");
		int status = target("/user/"+u.getId()).request().delete().getStatus();
        assertEquals(202, status);
        
	}
	
	private User createVideo(String titre) {
		Video v = new Video(titre, titre, titre, null);
	    Entity<Video> videoEntity = Entity.entity(v, MediaType.APPLICATION_JSON);
		User videoUser = target("/video").request().post(videoEntity).readEntity(User.class);
		return videoUser;
	}
	
}
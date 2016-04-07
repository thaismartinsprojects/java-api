package co.thaismartins.user;

import org.junit.Test;

public class DAOTest {
	
	@Test
	public void testSave() {
		
		User user = getUser();
		UserDAO userDAO = new UserDAO();
		User user2 = userDAO.save(user);
		System.out.println(user2.getId());
	}

	private static User getUser() {
		
		User user = new User();
		user.setName("Administrador");
		user.setLogin("admin");
		user.setEmail("admin@admin.com.br");
		user.setPass("admin123");
		
		return user;
	}

}

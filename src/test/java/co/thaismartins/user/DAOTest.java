package co.thaismartins.user;

public class DAOTest {

	public static void main(String[] args) {
		
		User user = getUser();
		UserDAO userDAO = new UserDAO();
		userDAO.create(user);
		
	}

	private static User getUser() {
		
		User user = new User();
		user.setName("Administrador");
		user.setUser("admin");
		user.setEmail("admin@admin.com.br");
		user.setPass("admin123");
		
		return user;
	}

}

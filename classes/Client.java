package classes;

import java.util.*;

public class Client extends User {
	public Client(int type, String login, String password, String name, String phone, String email, String address) {
		super(type, login, password, name, phone, email, address);
	}

	protected String getPassword() {
		return this.password;
	}

	public boolean registerUser(HashMap<String, User> data, int type, User user) {
		if (user != null)
			switch (type) {
			case 1:
				Client newClient = (Client) user;
				// systemio.insertUser(newClient)
				return true;
			default:
				return false;
			}
		return false;
	}

	public boolean authenticate(String password) {
		if (this.getPassword().equals(password))
			return true;
		return false;
	}

}
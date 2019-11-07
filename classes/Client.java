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
		// to implement
		return false;
	}

	public boolean authenticate(String password) {
		if (this.getPassword().equals(password))
			return true;
		return false;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
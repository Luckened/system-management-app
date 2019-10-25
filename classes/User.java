package classes;

import java.util.*;

/**
 * Usuario
 */
public abstract class User {
    protected int type;
    protected String login;
    protected String password;
    protected String name;
    protected String phone;
    protected String email;
    protected String address;

    public User(int type, String login, String password, String name, String phone, String email, String address) {
        this.type = type;
        this.login = login;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    protected abstract String getPassword();

    public abstract boolean authenticate(String password);

    public abstract boolean registerUser(HashMap<String, User> data, int type, User user);

}
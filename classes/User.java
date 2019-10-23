package classes;

/**
 * Usuario
 */
public abstract class User {
    String login;
    String password;
    String name;
    int id;
    String phone;
    String email;
    String address;
    int tipo;

    public User(String login, String password, String name, int id, String phone, String email, String address) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public abstract boolean registerUser(int type, User user);
}
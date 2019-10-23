package classes;

public class Client extends User {
    public Client(String login, String password, String name, int id, String phone, String email, String address) {
        super(login, password, name, id, phone, email, address);
    }

    public boolean registerUser(int type, User user) {
        if (user != null)
            switch (tipo) {
            case 1:
                Client newClient = (Client) user;
                // systemio.insertUser(newClient)
                return true;
            default:
                return false;
            }
        return false;
    }
}
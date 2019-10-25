package classes;

import java.util.*;

public class Manager extends User {
    public Manager(int id, String login, String password, String name, String phone, String email, String address) {
        super(id, login, password, name, phone, email, address);
    }

    protected String getPassword() {
        return this.password;
    }

    public boolean registerUser(HashMap<String, User> data, int type, User user) {
        if (user != null)
            switch (type) {
            case 1:
                Client newClient = (Client) user;
                // data.put(newClient.getLogin(), newClient);
                return true;
            case 2:
                Worker newWorker = (Worker) user;
                // data.put(newWorker.getLogin(), )
                return true;
            case 3:
                Manager newManager = (Manager) user;
                // systemio.insertUser(newWorker)
                return true;
            default:
                return false;
            }
        return false;
    }

    public boolean removeUser(int type) {
        return true;
    }

    public boolean authenticate(String password) {
        if (this.getPassword().equals(password))
            return true;
        return false;
    }

}
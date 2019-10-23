package classes;

public class Manager extends User {
    public Manager(String login, String password, String name, int id, String phone, String email, String address) {
        super(login, password, name, id, phone, email, address);
    }

    public boolean registerUser(int type, User user) {
        if (user != null)
            switch (tipo) {
            case 1:
                Client newClient = (Client) user;
                // systemio.insertUser(newClient)
                return true;
            case 2:
                Worker newWorker = (Worker) user;
                // systemio.insertUser(newWorker)
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
}
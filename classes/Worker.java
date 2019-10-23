package classes;

public class Worker extends User {
    public Worker(String login, String password, String name, int id, String phone, String email, String address) {
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
            default:
                return false;
            }
        return false;
    }
}
public class Manager extends User {
    public Manager(String login, String password, String name, int id, String phone, String email, String address) {
        super(login, password, name, id, phone, email, address);
    }

    public boolean registerUser(int type, User user) {
        if (user != null)
            switch (tipo) {
            case 1:
                Client newUser = (Client) user;
                break;
            case 2:
                Worker newUser = (Worker) user;
                break;
            case 3:
                Manager newUser = (Manager) user;
            default:
                return false;
            }

    }
}
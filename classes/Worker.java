package classes;

import java.util.*;

public class Worker extends User {
    private ArrayList<Evaluation> evaluations;

    public Worker(int type, String login, String password, String name, String phone, String email, String address,
            ArrayList<Evaluation> evaluations) {
        super(type, login, password, name, phone, email, address);
        this.evaluations = evaluations;
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

    public String getName() {
        return name;
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

    public ArrayList<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(ArrayList<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public Evaluation getEvaluationByService(Service service) {
        for (Evaluation evaluation : evaluations) {
            if (service.equals(evaluation.getService())) {
                return evaluation;
            }
        }

        return null;
    }

}
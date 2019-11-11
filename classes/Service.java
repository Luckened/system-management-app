package classes;

import java.util.ArrayList;

public class Service {
    private String type;
    private String description;
    private double value;
    private boolean valid;
    private boolean done;
    private ArrayList<Worker> workers;

    public Service(String type, String description, double value, boolean valid, boolean done,
            ArrayList<Worker> workers) {
        this.type = type;
        this.description = description;
        this.value = value;
        this.valid = valid;
        this.done = done;
        this.workers = workers;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }

    public double getValue() {
        return this.value;
    }

    public boolean isValid() {
        return this.valid;
    }

    public void setWorkers(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
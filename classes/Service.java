package classes;

public class Service {
    private String type;
    private String description;
    private double value;
    private boolean valid;

    public Service(String type, String description, double value, boolean valid) {

        this.type = type;
        this.description = description;
        this.value = value;
        this.valid = valid;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setValidated(boolean validated) {
        this.valid = validated;
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

    public boolean getValidated() {
        return this.valid;
    }
}
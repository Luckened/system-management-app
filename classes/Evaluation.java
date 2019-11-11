package classes;

public class Evaluation {
  Service service;
  double value;

  public Evaluation(Service service, double value) {
    this.service = service;
    this.value = value;
  }

  public void setService(Service service) {
    this.service = service;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public Service getService() {
    return service;
  }

  public double getValue() {
    return value;
  }

}
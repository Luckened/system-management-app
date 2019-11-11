package classes;

import java.util.*;

public class Request {
  Client client;
  Service service;
  double value;

  public Request(Client client, Service service, double value) {
    this.client = client;
    this.service = service;
    this.value = value;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Client getClient() {
    return client;
  }

  public void setService(Service service) {
    this.service = service;
  }

  public Service getService() {
    return service;
  }

  public void setValue(double totalValue) {
    this.value = totalValue;
  }

  public double getValue() {
    return value;
  }
}
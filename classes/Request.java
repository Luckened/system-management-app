package classes;

import java.util.*;

public class Request {
  Client client;
  ArrayList<Service> services;
  double totalValue;

  public Request(Client client, ArrayList<Service> services, double totalValue) {
    this.client = client;
    this.services = services;
    this.totalValue = totalValue;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Client getClient() {
    return client;
  }

  public void setServices(ArrayList<Service> services) {
    this.services = services;
  }

  public ArrayList<Service> getServices() {
    return services;
  }

  public void setTotalValue(double totalValue) {
    this.totalValue = totalValue;
  }

  public double getTotalValue() {
    return totalValue;
  }
}
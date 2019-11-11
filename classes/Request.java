package classes;

import java.util.*;

public class Request {
  Client client;
  Evaluation evaluation;
  Worker worker;
  boolean done;

  public Request(Client client, Evaluation evaluation, Worker worker, boolean done) {
    this.client = client;
    this.evaluation = evaluation;
    this.worker = worker;
    this.done = done;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Client getClient() {
    return client;
  }

  public boolean getDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }
}
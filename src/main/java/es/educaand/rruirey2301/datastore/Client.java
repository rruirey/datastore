package es.educaand.rruirey2301.datastore;

public interface Client {

  void start();

  void stop();

  <T> T getConnection();

}

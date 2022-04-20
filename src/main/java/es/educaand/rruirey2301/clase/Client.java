package es.educaand.rruirey2301.clase;

public interface Client {

  void start();

  void stop();

  <T> T getConnection();

}

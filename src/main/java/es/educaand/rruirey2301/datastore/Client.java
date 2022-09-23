package es.educaand.rruirey2301.datastore;

/**
 * Represents a database client that has
 * a connection, and it is start-able and
 * stop-able.
 */
public interface Client {

  /**
   * Starts the client.
   */
  void start();

  /**
   * Stops the client.
   */
  void stop();

  /**
   * Retrieves the connection that this
   * client is handling with.
   *
   * @return the connection object
   * @param <T> represents a generic connection.
   */
  <T> T getConnection();

}

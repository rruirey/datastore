package es.educaand.rruirey2301.datastore.dist.sql.client;

import es.educaand.rruirey2301.datastore.Client;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractSQLClient implements Client {

  protected Connection connection;

  @Override
  public <T> T getConnection() {
    return (T) connection;
  }

  @Override
  public void stop() {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public abstract void configure(Connection connection) throws SQLException;

}

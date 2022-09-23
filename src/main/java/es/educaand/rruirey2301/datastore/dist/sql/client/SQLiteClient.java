package es.educaand.rruirey2301.datastore.dist.sql.client;

import org.sqlite.SQLiteConfig;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class SQLiteClient extends AbstractSQLClient {

  @Override
  public void start() {
    Properties properties = new Properties();
    try {
      properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties"));
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }

    SQLiteConfig config = new SQLiteConfig();
    try {
      connection = DriverManager.getConnection(
          properties.getProperty("driver") + properties.getProperty("database_url"),
          config.toProperties()
      );

      configure(connection);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

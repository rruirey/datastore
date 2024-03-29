package test;

import es.educaand.rruirey2301.datastore.Client;
import es.educaand.rruirey2301.datastore.Datastore;
import es.educaand.rruirey2301.datastore.dist.sql.SQLDatastore;
import es.educaand.rruirey2301.datastore.dist.sql.client.SQLiteClient;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class TestConnection {

  public static void main(String[] args) throws Exception {
    Client client = new SQLiteClient() {
      @Override
      public void configure(Connection connection) throws SQLException {
        connection.prepareStatement(
            "CREATE TABLE IF NOT EXISTS test (" +
                "'id' VARCHAR(16) PRIMARY KEY, " +
                "'user' VARCHAR(16), " +
                "'password' VARCHAR(16), " +
                "'createdAt' NUMBER(19))"
        ).executeUpdate();
      }
    };

    // start client
    client.start();

    Connection connection = client.getConnection();
    if(connection == null) {
      System.err.println("No se ha podido conectar con la base de datos.");
      return;
    }

    // create datastore to handle with sql operations
    Datastore<TestModel> datastore = new SQLDatastore<>(
        connection,
        "test",
        new TestModelSerializer()
    );

    // create models
    datastore.update(
        new TestModel(
            "321",
            "pepe",
            "2lasduais"
        )
    );

    datastore.update(
        new TestModel(
            "123",
            "raul",
            "1203alsd"
        )
    );

    // find model to check if it was created.
    TestModel model = datastore.find("123");
    if (model == null) {
      System.err.println("No model created");
    } else {
      System.out.println("Model found: " + model.getUser());
    }

    // list models
    Collection<TestModel> models = datastore.findAll();
    System.out.println("Listing (" + models.size() + ") models:");
    for (TestModel testModel : models) {
      System.out.println("found: " + testModel.getUser());
    }

    // delete model
    datastore.delete("123");

    client.stop();
  }
}

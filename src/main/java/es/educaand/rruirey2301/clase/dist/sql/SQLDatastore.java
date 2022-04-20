package es.educaand.rruirey2301.clase.dist.sql;

import es.educaand.rruirey2301.clase.model.Model;
import es.educaand.rruirey2301.clase.Datastore;
import es.educaand.rruirey2301.clase.model.ModelSerializer;
import es.educaand.rruirey2301.clase.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLDatastore<T extends Model> implements Datastore<T> {

  private static final String FIND_ALL_QUERY = "SELECT * FROM %s";
  private static final String FIND_QUERY = FIND_ALL_QUERY + " WHERE " + Datastore.ID_FIELD + " = ?";
  private static final String DELETE_QUERY = "DELETE FROM %s WHERE " + Datastore.ID_FIELD + " = ?";
  private static final String UPDATE_QUERY = "REPLACE INTO %s (%s) VALUES (%s)";

  private final Connection connection;
  private final String tableName;
  private final ModelSerializer<T> modelSerializer;

  public SQLDatastore(
      Connection connection,
      String tableName,
      ModelSerializer<T> modelSerializer
  ) {
    this.connection = connection;
    this.tableName = tableName;
    this.modelSerializer = modelSerializer;
  }

  @Override
  public T find(String id) throws SQLException {
    String query = String.format(
        FIND_QUERY,
        tableName
    );

    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, id);

    List<T> models = find(statement);
    if (models.isEmpty()) {
      return null;
    }

    return models.get(0);
  }

  @Override
  public boolean update(T model) throws SQLException {
    Map<String, Object> serialized = modelSerializer.serialize(model);

    String query = String.format(
        UPDATE_QUERY,
        tableName,
        StringUtils.join(
            serialized.keySet(),
            ", "
        ),
        StringUtils.repeat(
            "?",
            ", ",
            serialized.values().size()
        )
    );

    PreparedStatement statement = connection.prepareStatement(query);
    int index = 1;
    for (Object value : serialized.values()) {
      statement.setObject(index++, value);
    }

    int result = statement.executeUpdate();

    statement.close();
    return result != 0;
  }

  @Override
  public boolean delete(String id) throws SQLException {
    String query = String.format(
        DELETE_QUERY,
        tableName
    );

    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, id);

    int result = statement.executeUpdate();
    statement.close();
    return result != 0;
  }

  @Override
  public List<T> findAll() throws SQLException {
    String query = String.format(
        FIND_ALL_QUERY,
        tableName
    );

    PreparedStatement statement = connection.prepareStatement(query);
    return find(statement);
  }

  private List<T> find(PreparedStatement statement) throws SQLException {
    List<T> models = new ArrayList<>();

    ResultSet result = statement.executeQuery();
    ResultSetMetaData metaData = result.getMetaData();

    while (result.next()) {
      // collect all data from result
      Map<String, Object> serialized = new HashMap<>();
      int columns = metaData.getColumnCount();
      for (int i = 1; i <= columns; i++) {
        serialized.put(metaData.getColumnName(i), result.getObject(i));
      }

      // build model
      models.add(
          modelSerializer.build(serialized)
      );
    }

    // close statement and resulset
    result.close();
    statement.close();

    return models;
  }
}

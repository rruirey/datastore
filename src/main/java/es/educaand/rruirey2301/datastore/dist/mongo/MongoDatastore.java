package es.educaand.rruirey2301.datastore.dist.mongo;

import es.educaand.rruirey2301.datastore.model.Model;
import es.educaand.rruirey2301.datastore.Datastore;

import java.util.List;

public class MongoDatastore<T extends Model> implements Datastore<T> {

  @Override
  public T find(String id) throws Exception {
    return null;
  }

  @Override
  public boolean update(T model) throws Exception {
    return false;
  }

  @Override
  public boolean delete(String id) throws Exception {
    return false;
  }

  @Override
  public List<T> findAll() throws Exception {
    return null;
  }
}

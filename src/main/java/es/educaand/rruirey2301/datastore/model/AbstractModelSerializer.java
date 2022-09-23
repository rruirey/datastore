package es.educaand.rruirey2301.datastore.model;

import es.educaand.rruirey2301.datastore.Datastore;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractModelSerializer<T extends Model> implements ModelSerializer<T> {

  @Override
  public Map<String, Object> serialize(T model) {
    Map<String, Object> serialized = new LinkedHashMap<>();
    serialized.put(Datastore.ID_FIELD, model.getId());
    return serialized;
  }
}

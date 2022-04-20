package es.educaand.rruirey2301.clase.model;

import java.util.Map;

public interface ModelSerializer<T extends Model> {

  Map<String, Object> serialize(T model);

  T build(Map<String, Object> serialized);

}

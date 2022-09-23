package es.educaand.rruirey2301.datastore.model;

import java.util.Map;

/**
 * Base interface that serializes/deserializes given
 * model or given serialized values.
 *
 * @param <T> - The model class
 */
public interface ModelSerializer<T extends Model> {

  /**
   * Serializes given {@link T} model.
   *
   * @param model - The model to serialize.
   * @return a map containing key-value serialization of model.
   */
  Map<String, Object> serialize(T model);

  /**
   * Deserialize given serialization values to
   * its respective model.
   *
   * @param serialized - The serialized values.
   * @return a {@link T} instance.
   */
  T build(Map<String, Object> serialized);

}

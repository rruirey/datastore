package es.educaand.rruirey2301.datastore;

import es.educaand.rruirey2301.datastore.model.Model;

import java.util.Collection;
import java.util.List;

public interface Datastore<T extends Model> {

  String ID_FIELD = "id";

  /**
   * Executes a find query that retrieves a
   * {@link Model} by given {@code id}
   *
   * @param id - The model id
   * @return - The model object by given id.
   * @throws Exception - When the query was unsuccessful.
   */
  T find(String id) throws Exception;

  /**
   * Executes an update query that updates
   * model values to database.
   *
   * @param model - the model to update
   * @return {@code true} if it was updated, otherwise {@code false} if not.
   * @throws Exception - When the query was unsuccessful.
   */
  boolean update(T model) throws Exception;

  /**
   * Executes a delete query that removes
   * provided model id from database.
   *
   * @param id - The model id to delete.
   * @return {@code true} if it was deleted, otherwise {@code false} if not.
   * @throws Exception - When the query was unsuccessful.
   */
  boolean delete(String id) throws Exception;

  /**
   * Retrieves a list collection containing
   * all existing models in our database.
   *
   * @return a collection containing all existing models.
   * @throws Exception - When the query was unsuccessful.
   */
  Collection<T> findAll() throws Exception;

}

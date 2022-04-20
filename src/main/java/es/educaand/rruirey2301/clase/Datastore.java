package es.educaand.rruirey2301.clase;

import es.educaand.rruirey2301.clase.model.Model;

import java.util.List;

public interface Datastore<T extends Model> {

  String ID_FIELD = "id";

  T find(String id) throws Exception;

  boolean update(T model) throws Exception;

  boolean delete(String id) throws Exception;

  List<T> findAll() throws Exception;

}

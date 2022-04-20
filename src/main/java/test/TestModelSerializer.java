package test;

import es.educaand.rruirey2301.clase.Datastore;
import es.educaand.rruirey2301.clase.model.AbstractModelSerializer;

import java.util.Map;

public class TestModelSerializer extends AbstractModelSerializer<TestModel> {

  @Override
  public Map<String, Object> serialize(TestModel model) {
    Map<String, Object> serialized = super.serialize(model);
    serialized.put("user", model.getUser());
    serialized.put("password", model.getPassword());
    serialized.put("createdAt", model.getCreatedAt());
    return serialized;
  }

  @Override
  public TestModel build(Map<String, Object> serialized) {
    return new TestModel(
        (String) serialized.get(Datastore.ID_FIELD),
        (String) serialized.get("user"),
        (String) serialized.get("password"),
        (Long) serialized.get("createdAt")
    );
  }
}

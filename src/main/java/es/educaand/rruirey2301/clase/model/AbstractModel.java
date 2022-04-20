package es.educaand.rruirey2301.clase.model;

public abstract class AbstractModel implements Model {

  private final String id;

  protected AbstractModel(String id) {
    this.id = id;
  }

  @Override
  public String getId() {
    return id;
  }
}

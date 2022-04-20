package test;

import es.educaand.rruirey2301.clase.model.AbstractModel;

public class TestModel extends AbstractModel {

  private final String user;
  private final String password;
  private final long createdAt;

  protected TestModel(String id, String user, String password, long createdAt) {
    super(id);
    this.user = user;
    this.password = password;
    this.createdAt = createdAt;
  }

  protected TestModel(String id, String user, String password) {
    this(id, user, password, System.currentTimeMillis());
  }

  public String getUser() {
    return user;
  }

  public String getPassword() {
    return password;
  }

  public long getCreatedAt() {
    return createdAt;
  }
}

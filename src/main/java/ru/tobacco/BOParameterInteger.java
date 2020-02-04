package ru.tobacco;

import org.springframework.beans.factory.annotation.Autowired;

public class BOParameterInteger implements BOParameterSource<Integer> {

  @Autowired
  private BOParametersStorage storage;

  private String key;

  public BOParameterInteger(String key) {
    this.key = key;
  }

  @Override
  public Integer getValue() {
    return (Integer) storage.getValue(key);
  }
}

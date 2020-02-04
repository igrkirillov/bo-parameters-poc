package ru.tobacco;

import java.util.Map;

public class BOParametersStorage {

  private Map<String, Object> map;

  public BOParametersStorage(Map<String, Object> map) {
    this.map = map;
  }

  public Object getValue(String key) {
    return map.get(key);
  }
}

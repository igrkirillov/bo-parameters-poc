package ru.tobacco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BOParameterInteger implements BOParameterSource<Integer> {

  private Logger logger = LoggerFactory.getLogger(BOParameterInteger.class);

  @Autowired
  private BOParametersStorage storage;

  private String key;

  private List<Consumer<Integer>> listeners = new ArrayList<>();

  public BOParameterInteger(String key) {
    this.key = key;
  }

  @Override
  public Integer getValue() {
    return (Integer) storage.getValue(key);
  }

  @Override
  public String getKey() {
    return key;
  }

  public void onEventChange(Integer newValue) {
    logger.info("onEventChange " + key + " newValue " + newValue);
    listeners.forEach(l -> l.accept(newValue));
  }

  @Override
  public void addListener(Consumer<Integer> listener) {
    listeners.add(listener);
  }
}

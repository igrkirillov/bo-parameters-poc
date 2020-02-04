package ru.tobacco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BOParameterString implements BOParameterSource<String> {

  private Logger logger = LoggerFactory.getLogger(BOParameterString.class);

  @Autowired
  private BOParametersStorage storage;

  private String key;

  private List<Consumer<String>> listeners = new ArrayList<>();

  public BOParameterString(String key) {
    this.key = key;
  }

  @Override
  public String getValue() {
    return (String) storage.getValue(key);
  }

  @Override
  public String getKey() {
    return key;
  }

  public void onEventChange(String newValue) {
    logger.info("onEventChange " + key + " newValue " + newValue);
    listeners.forEach(l -> l.accept(newValue));
  }

  @Override
  public void addListener(Consumer<String> listener) {
    listeners.add(listener);
  }
}

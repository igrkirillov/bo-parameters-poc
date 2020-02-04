package ru.tobacco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BOParameterInteger implements BOParameterSource<Integer> {

  private Logger logger = LoggerFactory.getLogger(BOParameterInteger.class);

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

  @Override
  public String getKey() {
    return key;
  }

  public void onEventChange() {
    logger.info("onEventChange " + key + " newValue " + getValue());
  }
}

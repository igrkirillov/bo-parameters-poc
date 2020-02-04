package ru.tobacco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BOParameterString implements BOParameterSource<String> {

  private Logger logger = LoggerFactory.getLogger(BOParameterString.class);

  @Autowired
  private BOParametersStorage storage;

  private String key;

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

  @Override
  public void onEventChange() {
    logger.info("onEventChange " + key + " newValue " + getValue());
  }
}

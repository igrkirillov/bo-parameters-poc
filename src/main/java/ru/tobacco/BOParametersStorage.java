package ru.tobacco;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

public class BOParametersStorage implements ApplicationContextAware {

  private Map<String, Object> map;
  private ApplicationContext applicationContext;

  public BOParametersStorage(Map<String, Object> map) {
    this.map = map;
  }

  public Object getValue(String key) {
    return map.get(key);
  }

  public void updateParameters(Map<String, Object> newValues) {
    map.putAll(newValues);
    Map<String, BOParameterSource> beans = applicationContext.getBeansOfType(BOParameterSource.class);
    beans.values().stream().forEach(bean -> {
      if (newValues.containsKey(bean.getKey())) {
        bean.onEventChange(newValues.get(bean.getKey()));
      }
    });
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }
}

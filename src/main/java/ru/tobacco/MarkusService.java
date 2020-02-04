package ru.tobacco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class MarkusService implements InitializingBean {

  private Logger logger = LoggerFactory.getLogger(MarkusService.class);

  @BOParameter("markus.timeout")
  private BOParameterInteger timeout;

  @Override
  public void afterPropertiesSet() throws Exception {
    logger.info("Markus-параметер timeout " + timeout.getValue());
  }
}

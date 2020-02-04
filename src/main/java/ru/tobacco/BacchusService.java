package ru.tobacco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tobacco.parameters.MarkusTimeout;
import ru.tobacco.parameters.MarkusURL;

@Service
public class BacchusService implements InitializingBean {

  private Logger logger = LoggerFactory.getLogger(BacchusService.class);

  @Autowired @MarkusTimeout
  private BOParameterInteger timeout;

  @Autowired @MarkusURL
  private BOParameterString url;

  @Override
  public void afterPropertiesSet() throws Exception {
    logger.info("Markus-параметер timeout " + timeout.getValue());
    logger.info("Markus-параметер url " + url.getValue());
    timeout.addListener(newTimeout -> logger.info("Пришло событие о новом timeout " + newTimeout));
  }
}

package ru.tobacco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import ru.tobacco.parameters.MarkusTimeoutParameter;
import ru.tobacco.parameters.MarkusURLParameter;

@Service
public class MarkusService implements InitializingBean {

  private Logger logger = LoggerFactory.getLogger(MarkusService.class);

  @MarkusTimeoutParameter
  private BOParameterInteger timeout;

  @MarkusURLParameter
  private BOParameterString url;

  @Override
  public void afterPropertiesSet() throws Exception {
    logger.info("Markus-параметер timeout " + timeout.getValue());
    logger.info("Markus-параметер url " + url.getValue());
    timeout.addListener(newTimeout -> logger.info("Пришло событие о новом timeout " + newTimeout));
  }
}

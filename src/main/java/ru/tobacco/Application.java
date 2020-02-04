package ru.tobacco;

import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.tobacco.parameters.MarkusURL;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(SpringConfiguration.class, args);
    try {
      new Thread(() -> sendUpdateEvent(context)).start();
      Thread.sleep(5*1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  private static void sendUpdateEvent(ApplicationContext context) {
    Map<String, Object> newValues = new HashMap<>();
    newValues.put("markus.timeout", 600);
    context.getBean(BOParametersStorage.class).updateParameters(newValues);
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tobacco;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import ru.tobacco.parameters.MarkusTimeoutParameter;
import ru.tobacco.parameters.MarkusURLParameter;

import java.util.HashMap;
import java.util.Map;

@SpringBootConfiguration
public class SpringConfiguration {

  @Bean @MarkusTimeoutParameter
  public BOParameterInteger markusTimeout() {
    return new BOParameterInteger(MarkusTimeoutParameter.KEY);
  }

  @Bean @MarkusURLParameter
  public BOParameterString markusUrl() {
    return new BOParameterString(MarkusURLParameter.KEY);
  }

  @Bean
  public BOParametersStorage boParametersStorage() {
    Map<String, Object> map = new HashMap<>();
    map.put(MarkusTimeoutParameter.KEY, 500);
    map.put(MarkusURLParameter.KEY, "http://markus");
    return new BOParametersStorage(map);
  }

  @Bean
  public MarkusService markusService() {
    return new MarkusService();
  }
}

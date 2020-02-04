/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tobacco;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ru.tobacco.parameters.MarkusTimeout;
import ru.tobacco.parameters.MarkusURL;

import java.util.HashMap;
import java.util.Map;

@SpringBootConfiguration
@ComponentScan
public class SpringConfiguration {

  @Bean @MarkusTimeout
  public BOParameterInteger markusTimeout() {
    return new BOParameterInteger(MarkusTimeout.KEY);
  }

  @Bean @MarkusURL
  public BOParameterString markusUrl() {
    return new BOParameterString(MarkusURL.KEY);
  }

  @Bean
  public BOParametersStorage boParametersStorage() {
    Map<String, Object> map = new HashMap<>();
    map.put(MarkusTimeout.KEY, 500);
    map.put(MarkusURL.KEY, "http://markus");
    return new BOParametersStorage(map);
  }
}

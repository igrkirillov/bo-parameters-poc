/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tobacco;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;

@SpringBootConfiguration
public class SpringConfiguration {

  @Bean @BOParameter("markus.timeout")
  public BOParameterInteger markusTimeout() {
    return new BOParameterInteger("markus.timeout");
  }

  @Bean
  public BOParametersStorage boParametersStorage() {
    Map<String, Object> map = new HashMap<>();
    map.put("markus.timeout", 500);
    map.put("markus.url", "http://markus");
    return new BOParametersStorage(map);
  }

  @Bean
  public MarkusService markusService() {
    return new MarkusService();
  }
}

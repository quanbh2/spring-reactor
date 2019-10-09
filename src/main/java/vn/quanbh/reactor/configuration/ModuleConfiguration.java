package vn.quanbh.reactor.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.Environment;
import reactor.bus.EventBus;

@Configuration
public class ModuleConfiguration {

  @Bean
  Environment env() {
    return reactor.Environment.initializeIfEmpty().assignErrorJournal();
  }

  @Bean
  EventBus createEventBus(reactor.Environment env) {
    return EventBus.create(env, reactor.Environment.THREAD_POOL);
  }
}

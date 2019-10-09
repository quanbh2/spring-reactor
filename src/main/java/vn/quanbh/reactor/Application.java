package vn.quanbh.reactor;

import static reactor.bus.selector.Selectors.$;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.bus.EventBus;
import vn.quanbh.reactor.constant.BusType;
import vn.quanbh.reactor.consumer.SmsConsumer;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

  private final EventBus eventBus;

  private final SmsConsumer smsConsumer;

  @Autowired
  public Application(EventBus eventBus, SmsConsumer smsConsumer) {
    this.eventBus = eventBus;
    this.smsConsumer = smsConsumer;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("run ...\n.......................\n.......................\n.......................");

    eventBus.on($(BusType.SMS), smsConsumer);
  }
}

package vn.quanbh.reactor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.bus.Event;
import reactor.bus.EventBus;
import vn.quanbh.reactor.constant.BusType;
import vn.quanbh.reactor.model.Contact;

@Slf4j
@RestController
public class NotificationController {

  private final EventBus eventBus;

  @Autowired
  public NotificationController(EventBus eventBus) {
    this.eventBus = eventBus;
  }

  @GetMapping("/noti")
  public void sendNotification(
      @RequestHeader(value = "User-Agent", required = false) String userAgent,
      @RequestHeader(value = "X-Forwarded-For", required = false) String xForwardedFor,
      @RequestHeader(value = "X-Real-IP", required = false) String xRealIP) {
    log.info(
        "(sendNotification) userAgent: {}, X-Forwarded-For: {}, X-Real-IP: {}",
        userAgent,
        xForwardedFor,
        xRealIP);

    for (int i = 0; i < 10; i++) {
      Contact contact = new Contact(i, null, "0123xxx" + i);
      eventBus.notify(BusType.SMS, Event.wrap(contact));
    }
  }
}

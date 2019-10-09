package vn.quanbh.reactor.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.quanbh.reactor.model.Contact;
import vn.quanbh.reactor.service.INotificationService;

@Slf4j
@Service("SMS")
public class SmsNotificationService implements INotificationService {

  @Override
  public void sendNotification(Contact contact) {
    log.info("Notification service started for Notification ID: {}", contact.getContactId());

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    log.info("--> send SMS success to: {} - id: {}",contact.getCustomerPhone(), contact.getContactId());
  }
}
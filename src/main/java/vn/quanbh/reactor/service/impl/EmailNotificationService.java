package vn.quanbh.reactor.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.quanbh.reactor.model.Contact;
import vn.quanbh.reactor.service.INotificationService;

@Slf4j
@Service("EMAIL")
public class EmailNotificationService implements INotificationService {

  @Override
  public void sendNotification(Contact contact) {
    log.info("--> send Email to: {} - id: {}",contact.getCustomerEmail(), contact.getContactId());
  }
}

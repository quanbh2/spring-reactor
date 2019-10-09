package vn.quanbh.reactor.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.bus.Event;
import reactor.fn.Consumer;
import vn.quanbh.reactor.model.Contact;
import vn.quanbh.reactor.service.INotificationService;

@Slf4j
@Component
public class SmsConsumer implements Consumer<Event<Contact>> {

  private final INotificationService iNotificationService;

  @Autowired
  public SmsConsumer(@Qualifier("SMS") INotificationService iNotificationService) {
    this.iNotificationService = iNotificationService;
  }

  @Override
  public void accept(Event<Contact> event) {
    Contact contact = event.getData();
    iNotificationService.sendNotification(contact);
  }
}

package vn.quanbh.reactor.service;

import vn.quanbh.reactor.model.Contact;

public interface INotificationService {

  void sendNotification(Contact contact);
}

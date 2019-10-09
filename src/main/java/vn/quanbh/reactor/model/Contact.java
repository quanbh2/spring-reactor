package vn.quanbh.reactor.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Contact {

  private long contactId;

  private String customerEmail;

  private String customerPhone;
}

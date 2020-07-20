package com.rdcorbera.designpatterns.behavioral.command;

import com.rdcorbera.designpatterns.behavioral.command.dtos.EmergencyContact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDetailsReceiver {
  private String name;
  private String lastname;
  private Date birthdate;
  private EmergencyContact emergencyContact;
}

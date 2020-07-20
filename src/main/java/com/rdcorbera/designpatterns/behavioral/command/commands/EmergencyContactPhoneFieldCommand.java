package com.rdcorbera.designpatterns.behavioral.command.commands;

import com.rdcorbera.designpatterns.behavioral.command.PassengerDetailsReceiver;
import com.rdcorbera.designpatterns.behavioral.command.dtos.EmergencyContact;
import com.rdcorbera.designpatterns.behavioral.command.dtos.Field;

public class EmergencyContactPhoneFieldCommand extends BaseFieldCommand implements FieldCommand {

  private PassengerDetailsReceiver passengerDetailsReceiver;

  public EmergencyContactPhoneFieldCommand(PassengerDetailsReceiver passengerDetailsReceiver, Field field) {
    super(field);
    this.passengerDetailsReceiver = passengerDetailsReceiver;
  }

  @Override
  public void execute() {
    this.validate();

    System.out.println(String.format("Execute %s", field.getKey()));

    if (passengerDetailsReceiver.getEmergencyContact() == null) {
      passengerDetailsReceiver.setEmergencyContact(new EmergencyContact());
    }

    passengerDetailsReceiver.getEmergencyContact().setPhone(field.getValue());
  }

}

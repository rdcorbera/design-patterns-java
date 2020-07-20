package com.rdcorbera.designpatterns.behavioral.command.commands;

import com.rdcorbera.designpatterns.behavioral.command.PassengerDetailsReceiver;
import com.rdcorbera.designpatterns.behavioral.command.dtos.Field;
import com.rdcorbera.designpatterns.behavioral.command.validators.AlphabetValidator;

public class LastnameFieldCommand extends BaseFieldCommand implements FieldCommand {

  private PassengerDetailsReceiver passengerDetailsReceiver;

  public LastnameFieldCommand(PassengerDetailsReceiver passengerDetailsReceiver, Field field) {
    super(field);
    this.passengerDetailsReceiver = passengerDetailsReceiver;
  }

  @Override
  public void execute() {
    this.validate();

    System.out.println(String.format("Execute %s", field.getKey()));

    passengerDetailsReceiver.setLastname(field.getValue());
  }

  @Override
  protected void validate() {
    super.validate();

    if (!AlphabetValidator.validate(field)) throw new IllegalArgumentException(String.format("Illegal value for %s", field.getKey()));
  }
}

package com.rdcorbera.designpatterns.behavioral.command.commands;

import com.rdcorbera.designpatterns.behavioral.command.PassengerDetailsReceiver;
import com.rdcorbera.designpatterns.behavioral.command.dtos.Field;
import com.rdcorbera.designpatterns.behavioral.command.validators.DateValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthdateFieldCommand extends BaseFieldCommand implements FieldCommand {

  private PassengerDetailsReceiver passengerDetailsReceiver;

  public BirthdateFieldCommand(PassengerDetailsReceiver passengerDetailsReceiver, Field field) {
    super(field);
    this.passengerDetailsReceiver = passengerDetailsReceiver;
  }

  @Override
  public void execute() {
    this.validate();

    System.out.println(String.format("Execute %s", field.getKey()));

    try {
      Date date = new SimpleDateFormat("yyyy-MM-dd").parse(field.getValue());
      passengerDetailsReceiver.setBirthdate(date);
    } catch (ParseException ex) {
      throw new IllegalArgumentException("Problem to convert string to a date");
    }
  }

  @Override
  protected void validate() {
    super.validate();

    if (!DateValidator.validate(field)) throw new IllegalArgumentException(String.format("Illegal date for %s", field.getKey()));
  }
}

package com.rdcorbera.designpatterns.behavioral.command;

import com.rdcorbera.designpatterns.behavioral.command.commands.*;
import com.rdcorbera.designpatterns.behavioral.command.dtos.FieldSaveRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PassengerUpdateInvoker {

  public PassengerUpdateInvoker() {
    commands = new ArrayList<>();
  }

  private List<FieldCommand> commands;

  public List<FieldCommand> getCommands() { return commands; }

  public PassengerDetailsReceiver process(FieldSaveRequest request) {

    if (request.getFields().size() <= 0) throw new NullPointerException("No fields");

    PassengerDetailsReceiver passenger = retrievePassengerDetails();

    initilizeCommands(request, passenger);

    executeCommands();

    return passenger;
  }

  private PassengerDetailsReceiver retrievePassengerDetails(){
    return new PassengerDetailsReceiver("John", "Doe", new Date(), null);
  }

  private void initilizeCommands(FieldSaveRequest request, PassengerDetailsReceiver passenger) {
    request.getFields().forEach(f -> {
      switch (f.getKey()) {
        case "FIRSTNAME":
          commands.add(new FirstnameFieldCommand(passenger, f)); break;
        case "LASTNAME":
          commands.add(new LastnameFieldCommand(passenger, f)); break;
        case "BIRTHDATE":
          commands.add(new BirthdateFieldCommand(passenger, f)); break;
        case "EMERGENCY_NAME":
          commands.add(new EmergencyContactNameFieldCommand(passenger, f)); break;
        case "EMERGENCY_PHONE":
          commands.add(new EmergencyContactPhoneFieldCommand(passenger, f)); break;
      }
    });
  }

  private void executeCommands() {
    this.commands.forEach(FieldCommand::execute);
  }
}

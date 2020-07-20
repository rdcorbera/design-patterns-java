package com.rdcorbera.designpatterns.behavioral.command;

import com.rdcorbera.designpatterns.behavioral.command.commands.*;
import com.rdcorbera.designpatterns.behavioral.command.dtos.Field;
import com.rdcorbera.designpatterns.behavioral.command.dtos.FieldSaveRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
public class PassengerUpdateInvokerTest {

  @Autowired
  private PassengerUpdateInvoker passengerUpdateInvoker;

  private static FieldSaveRequest request;

  @BeforeAll
  public static void setup() {
    request = new FieldSaveRequest(List.of(
      new Field("FIRSTNAME", "Ricardo"),
      new Field("LASTNAME", "Corbera"),
      new Field("BIRTHDATE", "1900-01-31"),
      new Field("EMERGENCY_NAME", "Daniel Corbera"),
      new Field("EMERGENCY_PHONE", "+51999999999")
    ));
  }

  @Test
  public void shouldInitializeAListOfCommandsWhenStartProcess() {

    passengerUpdateInvoker.process(request);

    List<FieldCommand> commands = passengerUpdateInvoker.getCommands();

    assertEquals(5, commands.size());
  }

  @Test
  public void verifyTypeOfEachCommand() {

    passengerUpdateInvoker.process(request);

    List<FieldCommand> commands = passengerUpdateInvoker.getCommands();

    assertTrue(commands.get(0) instanceof FirstnameFieldCommand);
    assertTrue(commands.get(1) instanceof LastnameFieldCommand);
    assertTrue(commands.get(2) instanceof BirthdateFieldCommand);
    assertTrue(commands.get(3) instanceof EmergencyContactNameFieldCommand);
    assertTrue(commands.get(4) instanceof EmergencyContactPhoneFieldCommand);
  }

  @Test
  public void verifyAllFieldsUpdated() {

    PassengerDetailsReceiver receiver = passengerUpdateInvoker.process(request);

    assertEquals("Ricardo", receiver.getName());
    assertEquals("Corbera", receiver.getLastname());
    assertNotNull(receiver.getEmergencyContact());
    assertEquals("Daniel Corbera", receiver.getEmergencyContact().getName());
    assertEquals("+51999999999", receiver.getEmergencyContact().getPhone());
  }
}

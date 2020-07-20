package com.rdcorbera.designpatterns.behavioral.command;

import com.rdcorbera.designpatterns.behavioral.command.dtos.Field;
import com.rdcorbera.designpatterns.behavioral.command.validators.AlphabetValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class ValidatorsTest {

  @Test
  public void shouldBeValid() {
    String key = "FIRSTNAME";
    String value = "Ricardo";

    boolean isValid = AlphabetValidator.validate(new Field(key, value));

    Assertions.assertTrue(isValid);
  }
}

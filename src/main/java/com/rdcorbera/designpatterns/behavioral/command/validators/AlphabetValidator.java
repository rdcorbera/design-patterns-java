package com.rdcorbera.designpatterns.behavioral.command.validators;

import com.rdcorbera.designpatterns.behavioral.command.dtos.Field;
import org.springframework.stereotype.Service;

@Service
public class AlphabetValidator {

  public static boolean validate(Field field) {
    String pattern = "[A-Za-z ]+";
    return field.getValue().matches(pattern);
  }
}

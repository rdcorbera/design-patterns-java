package com.rdcorbera.designpatterns.behavioral.command.validators;

import com.rdcorbera.designpatterns.behavioral.command.dtos.Field;
import org.springframework.stereotype.Service;

@Service
public class DateValidator {

  public static boolean validate(Field field) {
    String pattern = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
    return field.getValue().matches(pattern);
  }
}

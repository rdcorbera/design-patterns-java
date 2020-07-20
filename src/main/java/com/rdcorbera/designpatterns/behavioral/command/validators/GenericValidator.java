package com.rdcorbera.designpatterns.behavioral.command.validators;

import com.rdcorbera.designpatterns.behavioral.command.dtos.Field;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class GenericValidator {

  public static void validate(Field field) {
    if (StringUtils.isEmpty(field.getKey())) throw new IllegalArgumentException("Key is missing");

    if (StringUtils.isEmpty(field.getValue())) throw new IllegalArgumentException("Value is missing");
  }
}

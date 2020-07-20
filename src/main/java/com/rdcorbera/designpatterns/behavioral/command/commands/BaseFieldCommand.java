package com.rdcorbera.designpatterns.behavioral.command.commands;

import com.rdcorbera.designpatterns.behavioral.command.dtos.Field;
import com.rdcorbera.designpatterns.behavioral.command.validators.GenericValidator;

public abstract class BaseFieldCommand {

  protected Field field;

  protected BaseFieldCommand(Field field) {
    this.field = field;
  }

  protected void validate() {
    GenericValidator.validate(field);
  }
}

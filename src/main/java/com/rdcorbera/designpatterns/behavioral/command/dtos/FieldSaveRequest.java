package com.rdcorbera.designpatterns.behavioral.command.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldSaveRequest {

  private List<Field> fields;
}

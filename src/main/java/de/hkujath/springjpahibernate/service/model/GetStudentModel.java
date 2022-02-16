package de.hkujath.springjpahibernate.service.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetStudentModel {

   @NotBlank
   Long id;
   
   @NotBlank
   String firstName;

   @NotBlank
   String lastName;

   @Email
   String email;

}

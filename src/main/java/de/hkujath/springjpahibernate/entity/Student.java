package de.hkujath.springjpahibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
public class Student {

   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotBlank
   @Column(name = "first_name")
   private String firstName;

   @NotBlank
   @Column(name = "last_name")
   private String lastName;

   @Email
   @Column(name = "email")
   private String email;

   /**
    * Constructor
    *
    * @param firstName
    * @param lastName
    * @param email
    */
   public Student(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   @Override
   public String toString() {
      return "Student{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName + '\'' + ", email='" + this.email
          + '\'' + '}';
   }
}

package de.hkujath.springjpahibernate.service;

import de.hkujath.springjpahibernate.service.model.AddNewStudentModel;
import de.hkujath.springjpahibernate.service.model.GetStudentModel;
import java.util.List;
import java.util.Optional;

public interface StudentService {

   GetStudentModel addStudent(AddNewStudentModel student);

   boolean deleteStudent(Long studentID);

   List<GetStudentModel> getAllStudents();

   Optional<GetStudentModel> getStudentById(Long studentID);
}

package de.hkujath.springjpahibernate.service;

import de.hkujath.springjpahibernate.entity.Student;
import de.hkujath.springjpahibernate.repository.StudentRepository;
import de.hkujath.springjpahibernate.service.model.AddNewStudentModel;
import de.hkujath.springjpahibernate.service.model.GetStudentModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("studentService")
public class StudentServiceImpl implements StudentService {

   private final StudentRepository repository;

   @Autowired
   public StudentServiceImpl(StudentRepository repo) {
      this.repository = repo;
   }

   @Override
   public GetStudentModel addStudent(AddNewStudentModel student) {
      var tmpStudent = convertToStudentEntity(student);
      var entity = this.repository.save(tmpStudent);
      return this.convertToGetStudentModel(entity);
   }

   @Override
   public boolean deleteStudent(Long studentID) {
      this.repository.deleteById(studentID);
      return true;
   }

   @Override
   public List<GetStudentModel> getAllStudents() {
      List<GetStudentModel> resultList = new ArrayList();
      var tmpStudentsInRepo = this.repository.findAll();
      tmpStudentsInRepo.forEach(x -> resultList.add(this.convertToGetStudentModel(x)));
      return resultList;
   }

   @Override
   public Optional<GetStudentModel> getStudentById(Long studentID) {
      var foundStudent = this.repository.findById(studentID);
      return foundStudent.map(this::convertToGetStudentModel);

   }

   private AddNewStudentModel convertToAddNewStudentModel(Student inStudent) {
      var model = new AddNewStudentModel(inStudent.getFirstName(), inStudent.getLastName(), inStudent.getEmail());
      return model;
   }

   private GetStudentModel convertToGetStudentModel(Student inStudent) {
      var model = new GetStudentModel(inStudent.getId(), inStudent.getFirstName(), inStudent.getLastName(), inStudent.getEmail());
      return model;
   }

   private Student convertToStudentEntity(AddNewStudentModel student) {
      var tmpStudent = new Student(student.getFirstName(), student.getLastName(), student.getEmail());
      return tmpStudent;
   }
}

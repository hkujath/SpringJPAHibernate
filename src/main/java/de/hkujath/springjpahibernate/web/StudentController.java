package de.hkujath.springjpahibernate.web;

import de.hkujath.springjpahibernate.service.StudentService;
import de.hkujath.springjpahibernate.service.model.AddNewStudentModel;
import de.hkujath.springjpahibernate.service.model.GetStudentModel;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/students")
public class StudentController {

   private final StudentService studentService;

   @Autowired
   public StudentController(StudentService service) {
      this.studentService = service;
   }

   @DeleteMapping("/student/{id}")
   public boolean deleteStudent(@PathVariable Long id) {
      LOG.info("Trying to delete student with id: {} ({})", id, id.getClass());
      return this.studentService.deleteStudent(id);
   }

   @GetMapping
   public List<GetStudentModel> getAllStudents() {
      LOG.info("Try to return all students...");
      return this.studentService.getAllStudents();
   }

   @GetMapping("/student/{id}")
   public GetStudentModel getStudent(@PathVariable Long id) {
      var tmpStudent = this.studentService.getStudentById(id);
      if (tmpStudent.isPresent()) {
         return tmpStudent.get();
      }
      return null;
   }

   @PostMapping("/student")
   public GetStudentModel addStudent(final @RequestBody AddNewStudentModel model) {
      LOG.info("Try to create new student");
      return this.studentService.addStudent(model);
   }
}

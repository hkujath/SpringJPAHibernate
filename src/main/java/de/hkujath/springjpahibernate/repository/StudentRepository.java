package de.hkujath.springjpahibernate.repository;

import de.hkujath.springjpahibernate.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}

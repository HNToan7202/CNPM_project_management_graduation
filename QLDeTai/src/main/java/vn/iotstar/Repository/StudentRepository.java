package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstar.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

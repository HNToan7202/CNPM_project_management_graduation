package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}

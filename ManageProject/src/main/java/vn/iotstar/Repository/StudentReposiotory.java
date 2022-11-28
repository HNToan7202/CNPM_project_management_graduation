package vn.iotstar.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Student;

@Repository
public interface StudentReposiotory extends JpaRepository<Student, Long>{
	List<Student> findByNameContaining (String name);
	Page<Student> findByNameContaining (String name, Pageable pageable);
} 

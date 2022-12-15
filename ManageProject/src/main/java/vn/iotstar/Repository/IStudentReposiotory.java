package vn.iotstar.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Student;

@Repository
public interface IStudentReposiotory extends JpaRepository<Student, Integer>{
	List<Student> findByNameContaining(String name);

	List<Student> findByIdproject(Integer idproject); // lấy đúng từng ký tự
	//List<Student> findByIdprojectContaining(int project); // lấy idproject có các ký tự giống idproject

	Page<Student> findByNameContaining(String name, Pageable pageable);

	Student findByEmailContaining(String email);


}

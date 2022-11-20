package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iotstar.Entity.Student;
import vn.iotstar.Repository.StudentRepository;

public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepo;
	@Override
	public Page<Student> findAll(Pageable pageable){
		return studentRepo.findAll(pageable);
	}
	
	@Override
	public Optional<Student> findById(Integer id){
		return studentRepo.findById(id);
	}
	@Override
	public List<Student> findAll(){
		return studentRepo.findAll();
	}
	
	@Override
	public void delete(Student entity) {
		 studentRepo.delete(entity);
	}
}

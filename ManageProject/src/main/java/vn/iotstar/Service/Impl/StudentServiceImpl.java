package vn.iotstar.Service.Impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vn.iotstar.Entity.Student;
import vn.iotstar.Repository.IStudentReposiotory;
import vn.iotstar.Service.IStudentService;

@Service
@RequiredArgsConstructor
@Transactional

public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentReposiotory studentRepo;

	
	

	public List<Student> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return studentRepo.findByNameContaining(name);
	}

	@Override
	public Page<Student> findByNameContaining(String name, Pageable pageable) {
		return studentRepo.findByNameContaining(name, pageable);
	}

	
	public List<Student> findByIdproject(Integer idproject) {
		return studentRepo.findByIdproject(idproject);
	}

	public Student findByEmailContaining(String email) {
		// TODO Auto-generated method stub
		return studentRepo.findByEmailContaining(email);
	}

	@Override
	public <S extends Student> S save(S entity) {
		return studentRepo.save(entity);
	}

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public List<Student> findAllById(Iterable<Integer> ids) {
		return studentRepo.findAllById(ids);
	}

	@Override
	public long count() {
		return studentRepo.count();
	}

	@Override
	public void deleteById(Integer id) {
		studentRepo.deleteById(id);
	}

	@Override
	public void delete(Student entity) {
		studentRepo.delete(entity);
	}

	@Override
	public Student getById(Integer id) {
		return studentRepo.getById(id);
	}

	@Override
	public Optional<Student> findById(Integer id) {
		return studentRepo.findById(id);
	}

}

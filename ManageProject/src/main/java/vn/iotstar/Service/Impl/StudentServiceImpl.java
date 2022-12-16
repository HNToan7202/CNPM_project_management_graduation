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
import vn.iotstar.Entity.Student;
import vn.iotstar.Repository.IStudentReposiotory;
import vn.iotstar.Service.IStudentService;

@Service
@RequiredArgsConstructor
@Transactional

public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentReposiotory studentRepo;

	@Override
	public <S extends Student> S save(S entity) {
		return studentRepo.save(entity);
	}

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public Page<Student> findAll(Pageable pageable) {
		return studentRepo.findAll(pageable);
	}

	@Override
	public void flush() {
		studentRepo.flush();
	}

	@Override
	public <S extends Student> S saveAndFlush(S entity) {
		return studentRepo.saveAndFlush(entity);
	}

	@Override
	public <S extends Student> Page<S> findAll(Example<S> example, Pageable pageable) {
		return studentRepo.findAll(example, pageable);
	}

	@Override
	public Optional<Student> findById(Integer id) {
		return studentRepo.findById(id);
	}

	@Override
	public Long count() {
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

	@SuppressWarnings("deprecation")
	@Override
	public Student getById(Integer id) {
		return studentRepo.getById(id);
	}

	@Override
	public void deleteAll() {
		studentRepo.deleteAll();
	}

	@Override
	public List<Student> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return studentRepo.findByNameContaining(name);
	}

	@Override
	public Page<Student> findByNameContaining(String name, Pageable pageable) {
		return studentRepo.findByNameContaining(name, pageable);
	}

	public List<Student> findByIdproject(Long idproject) {
		return studentRepo.findByIdproject(idproject);
	}

	public Student findByEmailContaining(String email) {
		// TODO Auto-generated method stub
		return studentRepo.findByEmailContaining(email);
	}

	@Override
	public List<Student> findByWaitproject(Long idproject) {
		return studentRepo.findByWaitproject(idproject);
	}

	@Override
	public List<Student> findByXoaproject(Long xoaproject) {
		return studentRepo.findByXoaproject(xoaproject);
	}

}

package vn.iotstar.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Lecture;
import vn.iotstar.Repository.LectureRepository;
import vn.iotstar.Service.ILectureService;
@Service
public class LectureServiceImpl implements ILectureService{

	@Autowired
	LectureRepository lectureRepo;

	public <S extends Lecture> S save(S entity) {
		return lectureRepo.save(entity);
	}

	public List<Lecture> findAll() {
		return lectureRepo.findAll();
	}

	public Page<Lecture> findAll(Pageable pageable) {
		return lectureRepo.findAll(pageable);
	}

	public List<Lecture> findAll(Sort sort) {
		return lectureRepo.findAll(sort);
	}

	public <S extends Lecture> S saveAndFlush(S entity) {
		return lectureRepo.saveAndFlush(entity);
	}

	public <S extends Lecture> Page<S> findAll(Example<S> example, Pageable pageable) {
		return lectureRepo.findAll(example, pageable);
	}

	public Optional<Lecture> findById(Integer id) {
		return lectureRepo.findById(id);
	}

	public long count() {
		return lectureRepo.count();
	}

	public void deleteById(Integer id) {
		lectureRepo.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Lecture getOne(Integer id) {
		return lectureRepo.getOne(id);
	}

	public void delete(Lecture entity) {
		lectureRepo.delete(entity);
	}

	@SuppressWarnings("deprecation")
	public Lecture getById(Integer id) {
		return lectureRepo.getById(id);
	}

	public void deleteAll() {
		lectureRepo.deleteAll();
	}
	
}

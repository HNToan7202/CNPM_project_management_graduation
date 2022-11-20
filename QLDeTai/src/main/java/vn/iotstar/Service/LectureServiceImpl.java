package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import vn.iotstar.Entity.Lecture;
import vn.iotstar.Repository.LectureRepository;
import vn.iotstar.Repository.StudentRepository;

public class LectureServiceImpl implements LectureService {
	
	@Autowired
	private LectureRepository lectureRepo;
	@Override
	public Page<Lecture> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return lectureRepo.findAll(pageable);
	}

	@Override
	public <S extends Lecture> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Lecture> findById(Integer id) {
		// TODO Auto-generated method stub
		return lectureRepo.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void delete(Lecture entity) {
		// TODO Auto-generated method stub
		lectureRepo.delete(entity);
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Lecture> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Lecture> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Lecture> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Lecture> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Lecture> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Lecture, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lecture> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lecture> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lecture> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return lectureRepo.findAllById(ids);
	}

	@Override
	public <S extends Lecture> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Lecture> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Lecture> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Lecture> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Lecture getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lecture getById(Integer id) {
		// TODO Auto-generated method stub
		return lectureRepo.getById(id);
	}

	@Override
	public Lecture getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Lecture> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Lecture> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

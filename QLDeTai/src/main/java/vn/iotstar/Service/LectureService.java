package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import vn.iotstar.Entity.Lecture;
import vn.iotstar.Repository.LectureRepository;

public interface LectureService {

	<S extends Lecture> List<S> findAll(Example<S> example, Sort sort);

	<S extends Lecture> List<S> findAll(Example<S> example);

	Lecture getReferenceById(Integer id);

	Lecture getById(Integer id);

	Lecture getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteAllInBatch(Iterable<Lecture> entities);

	<S extends Lecture> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Lecture> S saveAndFlush(S entity);

	void flush();

	<S extends Lecture> List<S> saveAll(Iterable<S> entities);

	List<Lecture> findAllById(Iterable<Integer> ids);

	List<Lecture> findAll(Sort sort);

	List<Lecture> findAll();

	<S extends Lecture, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	<S extends Lecture> boolean exists(Example<S> example);

	<S extends Lecture> long count(Example<S> example);

	<S extends Lecture> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Lecture> Optional<S> findOne(Example<S> example);

	void deleteAll();

	void deleteAll(Iterable<? extends Lecture> entities);

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Lecture entity);

	void deleteById(Integer id);

	long count();

	boolean existsById(Integer id);

	Optional<Lecture> findById(Integer id);

	<S extends Lecture> S save(S entity);

	Page<Lecture> findAll(Pageable pageable);

	
}

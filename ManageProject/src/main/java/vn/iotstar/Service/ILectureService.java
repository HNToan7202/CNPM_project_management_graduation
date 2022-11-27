package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iotstar.Entity.Lecture;

public interface ILectureService {

	void deleteAll();

	Lecture getById(Long id);

	void delete(Lecture entity);

	void deleteById(Long id);

	long count();

	Optional<Lecture> findById(Long id);

	<S extends Lecture> Page<S> findAll(Example<S> example, Pageable pageable);

	List<Lecture> findAllById(Iterable<Long> ids);

	Page<Lecture> findAll(Pageable pageable);

	List<Lecture> findAll();

	<S extends Lecture> Optional<S> findOne(Example<S> example);

	<S extends Lecture> S save(S entity);

	Page<Lecture> findByNameContaining(String name, Pageable pageable);

	Lecture findOneByName(String name);

	List<Lecture> findByNameContaining(String name);
	

}

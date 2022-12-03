package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import vn.iotstar.Entity.Notification;
import vn.iotstar.Entity.Timeresgiter;

public interface ITimeResgiterSerivce {

	void deleteAll();

	void deleteAll(Iterable<? extends Timeresgiter> entities);

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(Timeresgiter entity);

	void deleteById(Long id);

	long count();

	<S extends Timeresgiter, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	Optional<Timeresgiter> findById(Long id);

	<S extends Timeresgiter> Page<S> findAll(Example<S> example, Pageable pageable);

	List<Timeresgiter> findAll(Sort sort);

	Page<Timeresgiter> findAll(Pageable pageable);

	List<Timeresgiter> findAll();

	<S extends Timeresgiter> S save(S entity);

	

}

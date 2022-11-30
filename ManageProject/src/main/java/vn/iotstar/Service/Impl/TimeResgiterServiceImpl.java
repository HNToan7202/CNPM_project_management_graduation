package vn.iotstar.Service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Timeresgiter;
import vn.iotstar.Repository.ITimeResgiterRepository;
import vn.iotstar.Service.ITimeResgiterSerivce;

@Service
public class TimeResgiterServiceImpl implements ITimeResgiterSerivce {

	@Autowired
	private ITimeResgiterRepository timeResgiterRepo;

	@Override
	public <S extends Timeresgiter> S save(S entity) {
		return timeResgiterRepo.save(entity);
	}

	@Override
	public List<Timeresgiter> findAll() {
		return timeResgiterRepo.findAll();
	}

	@Override
	public Page<Timeresgiter> findAll(Pageable pageable) {
		return timeResgiterRepo.findAll(pageable);
	}

	@Override
	public List<Timeresgiter> findAll(Sort sort) {
		return timeResgiterRepo.findAll(sort);
	}

	@Override
	public <S extends Timeresgiter> Page<S> findAll(Example<S> example, Pageable pageable) {
		return timeResgiterRepo.findAll(example, pageable);
	}

	@Override
	public Optional<Timeresgiter> findById(Long id) {
		return timeResgiterRepo.findById(id);
	}

	@Override
	public <S extends Timeresgiter, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		return timeResgiterRepo.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return timeResgiterRepo.count();
	}

	@Override
	public void deleteById(Long id) {
		timeResgiterRepo.deleteById(id);
	}

	@Override
	public void delete(Timeresgiter entity) {
		timeResgiterRepo.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		timeResgiterRepo.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Timeresgiter> entities) {
		timeResgiterRepo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		timeResgiterRepo.deleteAll();
	}
	
}

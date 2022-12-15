package vn.iotstar.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Council;
import vn.iotstar.Entity.Project;
import vn.iotstar.Repository.CouncilRepository;
import vn.iotstar.Service.ICouncilService;

@Service
public class CouncilServiecImpl implements ICouncilService{
	@Autowired
	CouncilRepository councilRepository;

	@Override
	public Page<Council> findByIdContaining(Integer id, Pageable pageable) {
		return councilRepository.findByIdContaining(id, pageable);
	}

	@Override
	public <S extends Council> S save(S entity) {
		return councilRepository.save(entity);
	}

	@Override
	public <S extends Council> Optional<S> findOne(Example<S> example) {
		return councilRepository.findOne(example);
	}

	@Override
	public List<Council> findAll() {
		return councilRepository.findAll();
	}

	@Override
	public List<Council> findAllById(Iterable<Integer> ids) {
		return councilRepository.findAllById(ids);
	}

	@Override
	public Optional<Council> findById(Integer id) {
		return councilRepository.findById(id);
	}

	@Override
	public long count() {
		return councilRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		councilRepository.deleteById(id);
	}

	@Override
	public Council getOne(Integer id) {
		return councilRepository.getOne(id);
	}

	@Override
	public void delete(Council entity) {
		councilRepository.delete(entity);
	}

	@Override
	public Council getById(Integer id) {
		return councilRepository.getById(id);
	}

	@Override
	public void deleteAll() {
		councilRepository.deleteAll();
	}


	

}

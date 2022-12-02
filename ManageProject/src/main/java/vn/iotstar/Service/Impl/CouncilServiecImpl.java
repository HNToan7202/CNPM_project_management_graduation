package vn.iotstar.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public <S extends Council> S save(S entity) {
		return councilRepository.save(entity);
	}

	@Override
	public List<Council> findAll() {
		return councilRepository.findAll();
	}

	@Override
	public Page<Council> findAll(Pageable pageable) {
		return councilRepository.findAll(pageable);
	}

	@Override
	public List<Council> findAll(Sort sort) {
		return councilRepository.findAll(sort);
	}

	@Override
	public Optional<Council> findById(Long id) {
		return councilRepository.findById(id);
	}

	@Override
	public long count() {
		return councilRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		councilRepository.deleteById(id);
	}

	@Override
	public void delete(Council entity) {
		councilRepository.delete(entity);
	}

	@Override
	public Council getById(Long id) {
		return councilRepository.getById(id);
	}

	@Override
	public void deleteAll() {
		councilRepository.deleteAll();
	}

	@Override
	public Page<Council> findByIdContaining(Long id, Pageable pageable) {
		// TODO Auto-generated method stub
		return councilRepository.findByIdContaining(id, pageable);
	}


	@Override
	public List<Project> findByIdContaining(Long id) {
		// TODO Auto-generated method stub
		return councilRepository.findByIdContaining(id);
	}
	
	

}

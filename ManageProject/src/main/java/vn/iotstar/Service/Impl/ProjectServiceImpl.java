package vn.iotstar.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Project;
import vn.iotstar.Repository.ProjectRepository;
import vn.iotstar.Service.IProjectService;


@Service
public class ProjectServiceImpl implements IProjectService{
	
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public List<Project> findByIdContaining(Long id) {
		return projectRepository.findByIdContaining(id);
	}

	@Override
	public Page<Project> findByIdContaining(Long id, Pageable pageable) {
		return projectRepository.findByIdContaining(id, pageable);
	}

	@Override
	public Optional<Project> findById(Long id) {
		return projectRepository.findById(id);
	}

	@Override
	public <S extends Project> S save(S entity) {
		return projectRepository.save(entity);
	}

	@Override
	public <S extends Project> Optional<S> findOne(Example<S> example) {
		return projectRepository.findOne(example);
	}

	@Override
	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	public Page<Project> findAll(Pageable pageable) {
		return projectRepository.findAll(pageable);
	}

	@Override
	public List<Project> findAll(Sort sort) {
		return projectRepository.findAll(sort);
	}

	@Override
	public List<Project> findAllById(Iterable<Long> ids) {
		return projectRepository.findAllById(ids);
	}

	@Override
	public <S extends Project> Page<S> findAll(Example<S> example, Pageable pageable) {
		return projectRepository.findAll(example, pageable);
	}

	@Override
	public long count() {
		return projectRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		projectRepository.deleteById(id);
	}

	@Override
	public void delete(Project entity) {
		projectRepository.delete(entity);
	}

	@Override
	@SuppressWarnings("deprecation")
	public Project getById(Long id) {
		return projectRepository.getById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Project> entities) {
		projectRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		projectRepository.deleteAll();
	}
	
}

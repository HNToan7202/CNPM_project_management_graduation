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
	public Optional<Project> findById(String id) {
		return projectRepository.findById(id);
	}

	@Override
	public <S extends Project> S save(S entity) {
		return projectRepository.save(entity);
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
	public List<Project> findAllById(Iterable<String> ids) {
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
	public void deleteById(String id) {
		projectRepository.deleteById(id);
	}

	@Override
	public void delete(Project entity) {
		projectRepository.delete(entity);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Project getById(String id) {
		return projectRepository.getById(id);
	}

	@Override
	public void deleteAll() {
		projectRepository.deleteAll();
	}

	
}

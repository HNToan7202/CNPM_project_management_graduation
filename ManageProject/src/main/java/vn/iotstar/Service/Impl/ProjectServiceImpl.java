package vn.iotstar.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import vn.iotstar.Entity.Project;
import vn.iotstar.Repository.ProjectRepository;
import vn.iotstar.Service.ProjectService;


@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	ProjectRepository projectRepository;

	public ProjectServiceImpl(ProjectRepository projectRepository) {
		super();
		this.projectRepository = projectRepository;
	}

	@Override
	public List<Project> findByIdContaining(String id) {
		return projectRepository.findByIdContaining(id);
	}

	@Override
	public Page<Project> findByIdContaining(String id, Pageable pageable) {
		return projectRepository.findByIdContaining(id, pageable);
	}

	@Override
	public Optional<Project> findById(String id) {
		return projectRepository.findById(id);
	}

	@Override
	public <S extends Project> S save(S entity) {
		if (entity.getId() == null) {

			return projectRepository.save(entity);

		} else {

			Optional<Project> opt = findById(entity.getId());

			if (opt.isPresent()) {

				if (StringUtils.isEmpty(entity.getId())) {

					entity.setId(opt.get().getId());

				} else {

					//lấy lại images cũ

					entity.setId(entity.getId());

				}

			}

			return projectRepository.save(entity);

		}
	}

	@Override
	public long count() {
		return projectRepository.count();
	}

	@Override
	public void delete(Project entity) {
		projectRepository.delete(entity);
		
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
	public void deleteById(String id) {
		projectRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		projectRepository.deleteAll();
	}
	
	
	
	
	
}

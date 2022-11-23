package vn.iotstar.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Faculty;
import vn.iotstar.Repository.FacultyRepository;
import vn.iotstar.Service.IFacultyService;

@Service
public class FacultyServiceImpl implements IFacultyService {

	@Autowired
	FacultyRepository facultyRepo;

	@Override
	public <S extends Faculty> S save(S entity) {
		return facultyRepo.save(entity);
	}

	@Override
	public List<Faculty> findAll() {
		return facultyRepo.findAll();
	}

	@Override
	public Page<Faculty> findAll(Pageable pageable) {
		return facultyRepo.findAll(pageable);
	}

	@Override
	public Optional<Faculty> findById(Long id) {
		return facultyRepo.findById(id);
	}

	@Override
	public long count() {
		return facultyRepo.count();
	}

	@Override
	public void deleteById(Long id) {
		facultyRepo.deleteById(id);
	}

	@Override
	public void delete(Faculty entity) {
		facultyRepo.delete(entity);
	}

	@Override
	public void deleteAll() {
		facultyRepo.deleteAll();
	}
	
}

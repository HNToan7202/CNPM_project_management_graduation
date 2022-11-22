package vn.iotstar.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import vn.iotstar.Entity.Admin;
import vn.iotstar.Repository.AdminRepository;
import vn.iotstar.Service.IAdminService;

public class AdminServiceImpl implements IAdminService{

	@Autowired
	private AdminRepository adminRepo;

	@Override
	public <S extends Admin> S save(S entity) {
		return adminRepo.save(entity);
	}

	@Override
	public List<Admin> findAll() {
		return adminRepo.findAll();
	}

	@Override
	public Page<Admin> findAll(Pageable pageable) {
		return adminRepo.findAll(pageable);
	}

	@Override
	public List<Admin> findAllById(Iterable<Integer> ids) {
		return adminRepo.findAllById(ids);
	}

	@Override
	public <S extends Admin> S saveAndFlush(S entity) {
		return adminRepo.saveAndFlush(entity);
	}

	@Override
	public <S extends Admin> Page<S> findAll(Example<S> example, Pageable pageable) {
		return adminRepo.findAll(example, pageable);
	}

	@Override
	public Optional<Admin> findById(Integer id) {
		return adminRepo.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return adminRepo.existsById(id);
	}

	@Override
	public <S extends Admin> boolean exists(Example<S> example) {
		return adminRepo.exists(example);
	}

	@Override
	public long count() {
		return adminRepo.count();
	}

	@Override
	public void deleteById(Integer id) {
		adminRepo.deleteById(id);
	}

	@Override
	public Admin getOne(Integer id) {
		return adminRepo.getOne(id);
	}

	@Override
	public void delete(Admin entity) {
		adminRepo.delete(entity);
	}

	@Override
	public Admin getById(Integer id) {
		return adminRepo.getById(id);
	}

	@Override
	public void deleteAll() {
		adminRepo.deleteAll();
	}

	@Override
	public <S extends Admin> List<S> findAll(Example<S> example, Sort sort) {
		return adminRepo.findAll(example, sort);
	}
	
	
}

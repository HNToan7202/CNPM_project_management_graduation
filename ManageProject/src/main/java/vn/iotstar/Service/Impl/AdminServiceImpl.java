package vn.iotstar.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Admin;
import vn.iotstar.Repository.IAdminRepository;
import vn.iotstar.Service.IAdminService;
@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	IAdminRepository adminRepo;

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
	public List<Admin> findAll(Sort sort) {
		return adminRepo.findAll(sort);
	}

	@Override
	public Optional<Admin> findById(Long id) {
		return adminRepo.findById(id);
	}

	@Override
	public long count() {
		return adminRepo.count();
	}

	@Override
	public void deleteById(Long id) {
		adminRepo.deleteById(id);
	}

	@Override
	public void delete(Admin entity) {
		adminRepo.delete(entity);
	}

	@Override
	public Admin getById(Long id) {
		return adminRepo.getById(id);
	}

	@Override
	public void deleteAll() {
		adminRepo.deleteAll();
	}

	@Override
	public Admin findByEmailContaining(String email) {
		return adminRepo.findByEmailContaining(email);
	}

	
	
}

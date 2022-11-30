package vn.iotstar.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Role;
import vn.iotstar.Repository.IRoleRepository;
import vn.iotstar.Service.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private IRoleRepository roleRepo;

	@Override
	public <S extends Role> S save(S entity) {
		return roleRepo.save(entity);
	}

	@Override
	public List<Role> findAll() {
		return roleRepo.findAll();
	}

	@Override
	public long count() {
		return roleRepo.count();
	}

	@Override
	public void deleteAll() {
		roleRepo.deleteAll();
	}
	
}

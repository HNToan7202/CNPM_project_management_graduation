package vn.iotstar.Service;

import java.util.List;

import vn.iotstar.Entity.Role;

public interface IRoleService {

	void deleteAll();

	long count();

	List<Role> findAll();

	<S extends Role> S save(S entity);

}

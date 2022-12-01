package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {
	Admin findByEmailContaining(String email);
}

package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, String> {

	Account findOneByemail(String email);

	Account findByEmailContaining(String email);

	@Query("SELECT c FROM Account c WHERE c.email = ?1")
	public Account findByEmail(String email);

	public Account findByResetpasswordtoken(String token);

}
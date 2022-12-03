package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Account;


@Repository
public interface IAccountRepository extends JpaRepository<Account, String> {

	Account findOneByemail(String email);

	Account findByEmailContaining(String email);

}
package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
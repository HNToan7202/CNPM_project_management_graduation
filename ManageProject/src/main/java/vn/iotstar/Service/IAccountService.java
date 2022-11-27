package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import vn.iotstar.Entity.Account;

public interface IAccountService {

	<S extends Account> List<S> findAll(Example<S> example, Sort sort);

	<S extends Account> List<S> findAll(Example<S> example);

	void deleteAll();

	void delete(Account entity);

	void deleteById(String id);

	long count();

	Optional<Account> findById(String id);

	<S extends Account> Page<S> findAll(Example<S> example, Pageable pageable);

	List<Account> findAll(Sort sort);

	List<Account> findAll();

	<S extends Account> S save(S entity);

	Page<Account> findAll(Pageable pageable);

	Account login(String email, String password);

	
}

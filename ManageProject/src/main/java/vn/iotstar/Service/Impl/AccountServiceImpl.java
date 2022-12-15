package vn.iotstar.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Account;
import vn.iotstar.Repository.IAccountRepository;
import vn.iotstar.Service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	IAccountRepository accountRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Page<Account> findAll(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}

	@Override
	public <S extends Account> S save(S entity) {
		// entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));

		return accountRepository.save(entity);
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public List<Account> findAll(Sort sort) {
		return accountRepository.findAll(sort);
	}

	@Override
	public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
		return accountRepository.findAll(example, pageable);
	}

	@Override
	public Optional<Account> findById(String id) {
		return accountRepository.findById(id);
	}

	@Override
	public long count() {
		return accountRepository.count();
	}

	@Override
	public void deleteById(String id) {
		accountRepository.deleteById(id);
	}

	@Override
	public void delete(Account entity) {
		accountRepository.delete(entity);
	}

	@Override
	public void deleteAll() {
		accountRepository.deleteAll();
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> example) {
		return accountRepository.findAll(example);
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
		return accountRepository.findAll(example, sort);
	}

	@Override
	public Account login(String email, String password) {
		Optional<Account> optExist = findById(email);

		if (optExist.isPresent() /* && bCryptPasswordEncoder.matches(password, optExist.get().getPassword()) */) {

			return optExist.get();
		}
		return null;
	}

	@Override
	public Account findOneByemail(String email) {
		// TODO Auto-generated method stub
		return accountRepository.findOneByemail(email);
	}

	@Override
	public void updateResetPasswordToken(String token, String email) throws UserNotFoundException {
		Account customer = accountRepository.findByEmail(email);
		if (customer != null) {
			customer.setResetpasswordtoken(token);
			accountRepository.save(customer);
		} else {
			throw new UserNotFoundException("Could not find any customer with the email " + email);
		}
	}

	@Override
	public Account getByResetPasswordToken(String token) {
		return accountRepository.findByResetpasswordtoken(token);
	}

	@Override
	public void updatePassword(Account customer, String newPassword) {
		// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// String encodedPassword = passwordEncoder.encode(newPassword);
		customer.setPassword(newPassword);

		customer.setResetpasswordtoken(null);
		accountRepository.save(customer);
	}

}

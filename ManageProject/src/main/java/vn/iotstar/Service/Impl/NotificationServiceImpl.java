package vn.iotstar.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Notification;
import vn.iotstar.Repository.NotificationRepository;
import vn.iotstar.Service.INotificationService;
@Service
public class NotificationServiceImpl implements INotificationService {

	@Autowired
	NotificationRepository notificationRepo;

	@Override
	public <S extends Notification> S save(S entity) {
		return notificationRepo.save(entity);
	}

	@Override
	public List<Notification> findAll() {
		return notificationRepo.findAll();
	}

	@Override
	public Page<Notification> findAll(Pageable pageable) {
		return notificationRepo.findAll(pageable);
	}

	@Override
	public List<Notification> findAll(Sort sort) {
		return notificationRepo.findAll(sort);
	}

	@Override
	public <S extends Notification> Page<S> findAll(Example<S> example, Pageable pageable) {
		return notificationRepo.findAll(example, pageable);
	}

	@Override
	public Optional<Notification> findById(Long id) {
		return notificationRepo.findById(id);
	}

	@Override
	public long count() {
		return notificationRepo.count();
	}

	@Override
	public void deleteById(Long id) {
		notificationRepo.deleteById(id);
	}

	@Override
	public Notification getOne(Long id) {
		return notificationRepo.getOne(id);
	}

	@Override
	public void delete(Notification entity) {
		notificationRepo.delete(entity);
	}

	@Override
	public Notification getById(Long id) {
		return notificationRepo.getById(id);
	}

	@Override
	public void deleteAll() {
		notificationRepo.deleteAll();
	}
	
}

package com.lotus.lotusSPM.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lotus.lotusSPM.dao.NotificationsDao;
import com.lotus.lotusSPM.model.Notifications;
import com.lotus.lotusSPM.service.base.NotificationsService;


@Service
@Transactional(rollbackFor = Exception.class)
public class NotificationsServiceImpl implements NotificationsService {

	private NotificationsDao notificationsDao;

	@Autowired
	public void setNotificationsDao(NotificationsDao notificationsDao) {
		this.notificationsDao = notificationsDao;
	}

	@Override
	public void deleteNotifications(Long id) {
		notificationsDao.deleteById(id);
	}


	@Override
	public List<Notifications> getNotifications() {
		return notificationsDao.findAll();
	}

	@Override
	public Notifications createNotifications(Notifications notifications) {
		return notificationsDao.save(notifications);
	}

	
	

}



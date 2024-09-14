package com.lotus.lotusSPM.service.base;

import java.util.List;
import com.lotus.lotusSPM.model.Notifications;

public interface NotificationsService {

	void deleteNotifications(Long id);
	List<Notifications> getNotifications();
	Notifications createNotifications(Notifications notifications);

}

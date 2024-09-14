package com.lotus.lotusSPM.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lotus.lotusSPM.model.Notifications;

@Repository
public interface NotificationsDao extends JpaRepository<Notifications, Long>, CrudRepository<Notifications, Long> {

}

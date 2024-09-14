package com.lotus.lotusSPM.service.base;

import java.util.List;

import com.lotus.lotusSPM.model.Messages;

public interface MessagesService {
	
	void deleteMessage(Long id);
	Messages createMessage(Messages messages);
	List<Messages> getMessages();
	List<Messages> findByTo(String to);
	List<Messages> findByFrom(String from);
	Messages findById(Long id);

}

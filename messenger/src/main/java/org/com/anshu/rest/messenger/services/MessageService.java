package org.com.anshu.rest.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Map;

import org.com.anshu.rest.messenger.database.Database;
import org.com.anshu.rest.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = Database.getMessages();
	
	

	public MessageService() {
		messages.put(1l, new Message(1l,"Hello World",new Date(),"Anshu Kumar"));
		messages.put(2l, new Message(2l,"Hello Anshu",new Date(),"Anshu Kumar"));
		
	}

	public List<Message> getMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(Long id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {

		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0)
			return null;
		else
			messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(Long id) {
		if (id <= 0)
			return null;
		else
			return messages.remove(id);
	}

}

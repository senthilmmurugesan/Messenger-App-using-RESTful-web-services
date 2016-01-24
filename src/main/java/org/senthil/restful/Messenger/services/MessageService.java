package org.senthil.restful.Messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.senthil.restful.Messenger.database.DatabaseClass;
import org.senthil.restful.Messenger.model.Message;

public class MessageService {

	public MessageService() {
		messages.put(1L, new Message(1L, "Hello World!", "Senthil"));
		messages.put(2L, new Message(2L, "Hello Jersey!", "Kumar"));
	}

	private Map<Long, Message> messages = DatabaseClass.getMessages(); 
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message> (messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message msg) {
		msg.setId(messages.size() + 1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg) {
		if(msg.getId() <= 0)
			return null;
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
}

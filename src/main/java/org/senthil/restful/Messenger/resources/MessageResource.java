package org.senthil.restful.Messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.senthil.restful.Messenger.model.Message;
import org.senthil.restful.Messenger.services.MessageService;

@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}
	
	@POST
	public Message addMessage(Message msg) {
		return messageService.addMessage(msg);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message msg) {
		msg.setId(id);
		return messageService.updateMessage(msg);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Message removeMessage(@PathParam("messageId") long id) {
		return messageService.removeMessage(id);
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id) {
		return messageService.getMessage(id);
	}

	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}

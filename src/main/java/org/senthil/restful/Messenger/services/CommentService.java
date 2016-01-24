package org.senthil.restful.Messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.senthil.restful.Messenger.database.DatabaseClass;
import org.senthil.restful.Messenger.model.Comment;
import org.senthil.restful.Messenger.model.Message;

public class CommentService {

	private Map<Long, Message> messages = DatabaseClass.getMessages(); 
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		messages.get(messageId).setComments(comments);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comment.getId() <= 0)
			return null;
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}

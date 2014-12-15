package redditFinal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Comment {
	
	private int id;
	private String comment;
	private String user;
	private int count;
	private String date;
	boolean showcomments;
	private LinkedList<Comment> commentlist;
	private int depth;
	
	public Comment(String comment, String user) {
		this.comment = comment;
		this.user = user;
		this.count = 0;
		this.depth = 0;
		this.commentlist = new LinkedList<Comment>();

		setDate(new GregorianCalendar());
	}
	
	private void setDate(GregorianCalendar calendar) {
		DateFormat format = new SimpleDateFormat( "yyyy-MM-dd' 'HH:mm:ss" );
		this.date = format.format(calendar.getTime());
	}

	public String getComment() {
		return comment;
	}
	
	public String getUser(){
		return user;
	}
	
	public int getCount() {
		return count;
	}
	
	public String getDate() {
		return date;
	}
	
	public LinkedList<Comment> getCommentlist() {
		return commentlist;
	}
	
	public void addComment(String comment, String username) {
		commentlist.addFirst(new Comment(comment, username));
	}
	
	public boolean getShowcomments() {
		return showcomments;
	}
	
	public void changeShowcomments() {
		if(showcomments==false) showcomments=true;
		else showcomments = false;
	}
	
	public int getCommentcount() {
		return commentlist.size();
	}

	public void increment() {
		count++;
	}

	public void decrement() {
		count--;
	}
	
	public void incrementDepth() {
		depth++;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public boolean depthIsOk() {
		return (depth < 6);
	}
	
	public int getId() {
		return id;
	}
	
	
}

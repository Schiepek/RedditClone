package redditFinal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Link {
	private String title;
	private String url;	
	private String user;
	private String date;
	private int count;
	boolean showcomments;
	private LinkedList<Comment> commentlist = new LinkedList<Comment>();
	
	public Link(String title, String url, String user) {
		this.title = title;
		this.url = url;
		this.user = user;
		this.count = 0;
		setDate(new GregorianCalendar());
	}
	
	private void setDate(GregorianCalendar calendar) {
		DateFormat format = new SimpleDateFormat( "yyyy-MM-dd' 'HH:mm:ss" );
		date = format.format(calendar.getTime());
	}
	
	public void addComment(String comment, String username) {
		commentlist.addFirst(new Comment(comment, username));
	}

	public String getTitle() {
		return title;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getDate() {
		return date;
	}
	
	public int getCount() {
		return count;
	}
	
	public LinkedList<Comment> getCommentlist() {
		return commentlist;
	}
	
	public void increment() {
		count++;
	}
	
	public void decrement() {
		count--;
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
}

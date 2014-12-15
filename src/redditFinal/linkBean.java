package redditFinal;

import java.awt.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Map;

public class linkBean {
	private String title;
	private String url;	
	boolean showcomments = false;	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean getShowcomments() {
		return showcomments;
	}
	
	public void changeShowcomments() {
		if(showcomments)showcomments=false;
		else showcomments=true;
	}

}

package redditFinal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedList;


public class commentBean {
	private String comment;

	public String getComment(){
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void reset() {
		this.comment = "";
	}

}

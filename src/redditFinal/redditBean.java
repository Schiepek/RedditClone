package redditFinal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.faces.context.FacesContext;

public class redditBean {
	
	private LinkedList<Link> linklist = new LinkedList<Link>();
	private ArrayList<User> users = new ArrayList<User>();
	boolean submitlink = false;
	private boolean showRegister = false;
	boolean English = true;
	
	//Strings zur Internationalisierung
	private final String[] strGerman = {"English", "Login", "Registrieren", "Benutzername", "Passwort", "Titel", "Eingereicht am", "von"};
	private final String[] strEnglish = {"Deutsch", "Login", "Register", "Username", "Password", "Title", "Submitted on", "by"};
	
	private String[] currentLanguage = strEnglish;

	public redditBean() {
		init();
	}
	
	public void init() {
		users.add(new User("andreoli", "123"));
		users.add(new User("schiepek" , "123"));
		users.add(new User("zahner" , "123"));
		
		Link one = new Link("google is the best" , "www.google.ch" , "andreoli");
		Link two = new Link("I am on Facebook" , "www.facebook.com" , "zahner");
		Link three = new Link("HSR" , "www.hsr.ch" , "schiepek");
		Link four = new Link("Zwitscher" , "www.twitter.com" , "mr.x");
		Link five = new Link("blablabla" , "www.blabla.ch" , "irgendwer");
		
		Comment cb1 = new Comment("der erste Kommentar" , "schiepek");
		Comment cb2 = new Comment("der zweite Kommentar" , "andreoli");		
		one.getCommentlist().add(cb1);
		one.getCommentlist().add(cb2);	
		
		Comment ucb1 = new Comment("Unterkommentar 1" , "siebesiech");
		Comment ucb2 = new Comment("Unterkommentar 2" , "siebesiech 3000");		
		one.getCommentlist().get(1).getCommentlist().add(ucb1);
		one.getCommentlist().get(1).getCommentlist().add(ucb2);	

		linklist.add(one);
		linklist.add(two);
		linklist.add(three);
		linklist.add(four);
		linklist.add(five);
	}
	
	public boolean isEnglish() {
		return English;
	}

	public void setEnglish() {
		if(this.English)
			currentLanguage = strGerman;
		else
			currentLanguage = strEnglish;
		this.English = !this.English;
	}
	
	public boolean getSubmitlink() {
		return submitlink;
	}
	
	public void changeSubmitLink() {
		if(submitlink)submitlink=false;
		else submitlink=true;
	}
	
	public void disableSubmitLink() {
		submitlink = false;
	}
	
	public void addLink(String title, String url, String user) {
		linklist.addFirst(new Link(title,url,user));
	}
	
	public LinkedList<Link> getLinklist() {
		return linklist;
	}
	
	public void setShowRegister(boolean showRegister) {
		this.showRegister = showRegister;
	}
	
	public void hideRegister() {
		showRegister = false;
	}
	
	public boolean isShowRegister() {
		return showRegister;
	}
	
	public void doShowRegister() {
		showRegister = true;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public String getString(int index){
		return currentLanguage[index];
	}
}

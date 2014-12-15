package redditFinal;


import javax.faces.context.FacesContext;


public class loginBean {
	
	private String username;
	private String password;
	
	private boolean loggedIn = false;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	public void doLogin() {

		redditBean redditBean = (redditBean)FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("redditBean");
		for (User user : redditBean.getUsers()) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				setLoggedIn(true);
				//System.out.println("logged in");
				return;
			}
		}
		setUsername("");
		setLoggedIn(false);
	}
	
	public void doLogout() {
		setUsername("");
		setPassword("");
        setLoggedIn(false);
        //System.out.println("logged out");
    }
	
	public void doRegister() {
		redditBean redditBean = (redditBean)FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("redditBean");
		User newUser = new User("","");
		newUser.setUsername(getUsername());
		newUser.setPassword(getPassword());
		redditBean.getUsers().add(newUser);
		setLoggedIn(true);
		redditBean.setShowRegister(false);
		
	}
	
	public void hideRegister() {
		redditBean redditBean = (redditBean)FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("redditBean");
		redditBean.setShowRegister(false);
	}
	
	
	
}
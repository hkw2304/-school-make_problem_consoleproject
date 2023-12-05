package router;

import controller.LoginController;

public class LoginRouter {
	LoginController login = new LoginController();
	
	public String loginPage() {
		// TODO Auto-generated method stub
		String loginId = login.loginPage();
		return loginId;
	}

}

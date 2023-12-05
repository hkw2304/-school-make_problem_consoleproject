package router;

import java.util.Scanner;

import controller.AccountController;
import vo.AccountVo;

public class AccountRouter {
	AccountController account = new AccountController();
	public boolean createAccount() {
		
		return account.createAccount();
	}
}

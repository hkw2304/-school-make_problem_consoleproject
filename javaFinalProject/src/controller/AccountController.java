package controller;

import java.util.regex.Pattern;

import dao.Dao;
import utils.Configs;
import vo.AccountVo;

public class AccountController extends Configs{
	AccountVo accountVo = new AccountVo();
	public AccountController() {
		// TODO Auto-generated constructor stub
		dao = new Dao();
	}
	public boolean createAccount() {
		
		System.out.print("아이디 >> ");
		accountVo.setId(sc.nextLine());
		boolean idCk = Pattern.matches("^[a-zA-Z]*$", accountVo.getId());
		System.out.print("비밀번호 >> ");
		accountVo.setPw(sc.nextLine());
		System.out.print("비밀번호 확인 >> ");
		accountVo.setPwCK(sc.nextLine());
		System.out.print("이메일 >> ");
		accountVo.setEmail(sc.nextLine());
		boolean emailCk = Pattern.matches("^[a-zA-Z0-9]*@[a-z]*.[com]*$", accountVo.getEmail());
		System.out.print("주소 >> ");
		accountVo.setAddr(sc.nextLine());
		if(!idCk) {
			System.out.println("아이디는 영문자로만 입력!!!!!!!!!!");
			return false;
		}
		
		if(!(accountVo.getPw().equals(accountVo.getPwCK()))) {
			System.out.println("비밀번호가 다릅니다.!!!!!!!!!!");
			return false;
		}
		if(!emailCk) {
			System.out.println("이메일 형식으로 만드세요!!!!!!!!!!");
			return false;
		}
		
		return dao.createAccount(accountVo);
	}
}

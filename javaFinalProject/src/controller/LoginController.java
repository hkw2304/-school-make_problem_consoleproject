package controller;

import java.util.Scanner;

import dao.Dao;
import utils.Configs;

public class LoginController extends Configs{
	public LoginController() {
		// TODO Auto-generated constructor stub
		dao = new Dao();
	}
	public String loginPage() {
		// TODO Auto-generated method stub
		System.out.print("아이디 >> ");
		String id = sc.nextLine();
		System.out.print("비밀번호 >> ");
		String pw = sc.nextLine();
		String loginId = dao.selectByIdAndPw(id, pw);
		return loginId;
	}
}

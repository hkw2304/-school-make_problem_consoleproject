package main;

import java.sql.Connection;

import router.RootRouter;

public class MainRun {
	public static void main(String[] args) {
//		RootRouter : 로그인 페이지로 이동
		RootRouter root = new RootRouter();
		root.loginPage();
	}
}

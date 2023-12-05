package router;

import java.util.Scanner;

public class RootRouter {
	Scanner sc = new Scanner(System.in);

//	로그인 페이지의 기능
/*
 * 	회원가입, 로그인, 프로그램 종료
 * */
	public void loginPage() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println(" -------------------------------");
			System.out.println("|            1.회원가입       	|");
			System.out.println("|            2.로그인        	|");
			System.out.println("|            0.프로그램 종료     	|");
			System.out.println(" -------------------------------");
			System.out.print("원하는 메뉴 >>> ");
			int select = sc.nextInt();
//			정수를 입력받아 해당 기능을 실행하기위해 switch문으로 작성
			switch (select) {
			case 1: {
				System.out.println("회원가입 페이지로 이동합니다!!!!");
				AccountRouter account = new AccountRouter();
				boolean ck = account.createAccount();
				if(!ck) {
					System.out.println("회원가입 실패!!!!!");
				}
				else {
					System.out.println("회원가입 성공!!!!!");
				}
				break;
			}
			case 2: {
				System.out.println("로그인 페이지로 이동합니다!!!!");
				LoginRouter login = new LoginRouter();
				String loginId = login.loginPage();
				if(loginId == null) {
					System.out.println("로그인 실패!!!!");
				}
				else {
					System.out.println("로그인 성공!!!!!");
					System.out.println(">>>> 메인페이지로 이동합니다 <<<<");
					AlgorithmRouter algorithm = new AlgorithmRouter();
					algorithm.showcontents(loginId);
				}
				break;
			}
			case 0: {
				System.out.println("프로그램 종료!!!");
				System.exit(0);
				break;
			}
			default:
				System.out.println("없는 메뉴입니다!!!!");
				
			}
		}
	}
}

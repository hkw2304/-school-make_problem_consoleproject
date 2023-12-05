package router;

import controller.AlgorithmController;
import utils.Configs;

public class AlgorithmRouter extends Configs{
	public void showcontents(String loginId) {
		AlgorithmController algorithmController = new AlgorithmController();
		while(true) {
		System.out.println("          ### 알고리즘 문제 풀기 ###");
		System.out.println("  -------------------------------------");
		System.out.println("│             난이도를 선택하세요             	│");
		System.out.println("│        ※난이도는 프로그래머스 0~2수준입니다※    	│");
		System.out.println("│                                       │");
		System.out.println("│         	1.LEVEL 0               │");
		System.out.println("│         	2.LEVEL 1               │");
		System.out.println("│         	3.LEVEL 2               │");
		System.out.println("│         	4.전적보기                 │");
		System.out.println("│         	0.다른계정으로            	│");
		System.out.println("│                                       │");
		System.out.println("  -------------------------------------");
		System.out.print(" 선택 >>> ");
		int select = sc.nextInt();
		switch(select) {
		case 1:
			System.out.println(" ###### LEVEL 0 ######");
			algorithmController.levelZero(loginId);
			break;
		case 2:
			System.out.println(" ###### LEVEL 1 ######");
			algorithmController.levelOne(loginId);
			break;
		case 3:
			System.out.println(" ###### LEVEL 2 ######");
			algorithmController.levelTwo(loginId);
			break;
		case 4:
			algorithmController.showRecord(loginId);
			break;
		case 0:
			RootRouter root = new RootRouter();
			root.loginPage();
			break;
		}
		}
	}
}

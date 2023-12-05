package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import collectionWorkbook.Workbook;
import dao.Dao;
import utils.Configs;
import vo.RecordVo;

public class AlgorithmController extends Configs{
	Workbook book=  new Workbook();
	List<RecordVo> list = null;
	public AlgorithmController() {
		// TODO Auto-generated constructor stub
		dao = new Dao();
	}
	public void levelZero(String loginId) {
		System.out.println("1.숫자 비교");
		System.out.println("2.두 수의 차");
		System.out.print(" 선택 >>> ");
		int select = sc.nextInt();
		switch(select) {
		case 1:
			int cnt = book.compareNumber();
			if(cnt > 0) {
				dao.selectLevelzeroById(loginId);
			}
			break;
		case 2:
			int cnt2 = book.subtract();
			if(cnt2 > 0) {
				dao.selectLevelzeroById(loginId);
			}
			break;
		default:
			System.out.println("다시 선택!!!!");
		}
	}
	public void levelOne(String loginId) {
		System.out.println("1.가운데 글자 가져오기");
		System.out.println("2.나누어 떨어지는 숫자 배열");
		System.out.print(" 선택 >>> ");
		int select = sc.nextInt();
		switch(select) {
		case 1:
			int cnt = book.getMiddleLetter();
			if(cnt > 0) {
				dao.selectLevelOneById(loginId);
			}
			break;
		case 2:
			int cnt2 = book.makeArrDivisor();
			if(cnt2 > 0) {
				dao.selectLevelOneById(loginId);
			}
			break;
		default:
			System.out.println("다시 선택!!!!");
		}
		
	}
	public void levelTwo(String loginId) {
		System.out.println("1.최솟값 만들기");
		System.out.println("2.구명보트");
		System.out.print(" 선택 >>> ");
		int select = sc.nextInt();
		switch(select) {
		case 1:
			int cnt = book.makeMin();
			if(cnt > 0) {
				dao.selectLevelTwoById(loginId);
			}
			break;
		case 2:
			int cnt2 = book.lifeboat();
			if(cnt2 > 0) {
				dao.selectLevelTwoById(loginId);
			}
			break;
		default:
			System.out.println("다시 선택!!!!");
		}
	}
	public void showRecord(String loginId) {
		list = new ArrayList<>();
		list = dao.selectRecord(loginId);
		System.out.println("########## " + list.get(0).getId() + "님의 전적 ##########");
		System.out.println("레벨 0 >> " + list.get(0).getZero() + "개");
		System.out.println("레벨 1 >> " + list.get(0).getOne() + "개");
		System.out.println("레벨 2 >> " + list.get(0).getTwo() + "개");
		System.out.println("##############################");
	}
}

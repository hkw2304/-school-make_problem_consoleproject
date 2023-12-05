package collectionWorkbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Workbook implements WorkbookImpl{
	Random random = new Random();
	Scanner sc = new Scanner(System.in);

	public int compareNumber() {
		int answer = 0;
		// TODO Auto-generated method stub
		int num1 = random.nextInt(10001);
		int num2 = random.nextInt(10001);
		System.out.println("===== 두 수가 같으면 1, 아니면 -1을 반환한다. =====");
		System.out.println("===== 변수로 " + num1 + ", " + num2 + "가 주어졌을 때 답을 구하시오 =====");
		System.out.print("나의 정답 >> ");
		int respond = sc.nextInt();
		boolean ch = (0 <= num1 && num1 <= 10000) && (0 <= num2 && num2 <= 10000);
		if (ch) {
			answer = num1 == num2 ? 1 : -1;
		} else
			answer = -1;
		System.out.println("문제 정답 >> " + answer);
		if (respond == answer) {
			System.out.println("정답!!!!");
			return 1;
		} else {
			System.out.println("땡!!!!");
			return 0;
		}
	}

	public int subtract() {
		// TODO Auto-generated method stub
		int answer = 0;
		int num1 = random.nextInt(50001);
		int num2 = random.nextInt(50001);
		System.out.println("===== " + num1 + ", " + num2 + "가 주어졌을 때 " + num1 + " - " + num2 + " 를 구하시오 =====");
		System.out.print("나의 정답 >> ");
		int respond = sc.nextInt();
		boolean check = (-50000 <= num1 && num1 <= 50000) && (-50000 <= num2 && num2 <= 50000);
		if (check) {
			answer = num1 - num2;
		}
		System.out.println("문제 정답 >> " + answer);
		if (respond == answer) {
			System.out.println("정답!!!!");
			return 1;
		} else {
			System.out.println("땡!!!!");
			return 0;
		}
	}

	public int getMiddleLetter() {
		// TODO Auto-generated method stub
		
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = random.nextInt(21);
		Random random = new Random();
		String str = random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		System.out.println("###### 랜덤한 문자열이 주어졌을 때 가운데의 글자를 추출하세요 ######");
		System.out.println("###### 짝수인 경우 가운데 2글자를 추출하세요 ######");
		System.out.println("랜덤 문자열 >> " + str);
		System.out.print("나의 정답 >>");
		String respond = sc.next();
		String answer = "";
		int index = 0;
		if (str.length() % 2 == 1) {
			answer += str.charAt((str.length() / 2));
		} else {
			for (int i = 0; i < 2; i++) {
				answer += str.charAt(((str.length() / 2) - 1) + index);
				index++;
			}
		}
		System.out.println("문제 정답 >> " + answer);
		if(respond.equals(answer)) {
			System.out.println("정답!!!!");
			return 1;
		}
		else {
			System.out.println("땡!!!!");
			return 0;
		}
	}

	public int makeArrDivisor() {
		// TODO Auto-generated method stub
		ArrayList<Integer> respond = new ArrayList<>();
		System.out.println("###### 배열과 divisor가 주어지고 배열의 요소를 divisor로 나누어 떨어지는 값들을 오름차순으로 만드세요 ######");
		System.out.println("###### 나누어지는 값이 없다면 -1입니다 ######");
		int len = random.nextInt(15) + 1;
		int[] arr = new int[len];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(10) + 1;
		}
		int divisor = random.nextInt(20) + 1;
		System.out.println("배열 >> " + Arrays.toString(arr));
		System.out.println("divisor >> " + divisor);
		int[] answer = {};
		int size = 0;
		int index = 0;
		int temp = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % divisor == 0) {
				size++;
			}
		}
        
		answer = new int[size];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % divisor == 0) {
				answer[index] = arr[i];
				index++;
			}
		}
		for(int i = 0; i < answer.length - 1; i++) {
			for(int j = i; j < answer.length; j++) {
				if(answer[i] > answer[j]) {
					temp = answer[j];
					answer[j] = answer[i];
					answer[i] = temp;
				}
			}
		}
        if(size == 0) {
			answer = new int[1];
			answer[0] = -1;
		}
        while(true) {
        	
        	try {
        		System.out.print("정답 입력(0 : 입력 종료) >> ");
            	int num = sc.nextInt();
        		if(num == 0) {
            		break;
            	}
            	respond.add(num);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자를 입력하세요!!!!");
				break;
				
			}
        }
        System.out.println("나의 정답 >> " + respond.toString());
        System.out.println("문제 정답 >> " + Arrays.toString(answer));
        if(answer.length != respond.size()) {
        	System.out.println("땡!!!!");
			return 0;
        }
        for(int i = 0; i < answer.length; i++) {
        	if(answer[i] != respond.get(i)) {
        		System.out.println("땡!!!!");
    			return 0;
        	}
        }
        System.out.println("정답!!!!");
		return 1;
	}

	public int makeMin() {
		// TODO Auto-generated method stub
		System.out.println("###### 길이가 같은 배열 2개가 있다. ######");
		System.out.println("###### 각 배열에서 요소를 하나씩 뽑아 곱하고 누적을한다. ######");
		System.out.println("###### 이 과정을 배열의 길이만큼 반복 ######");
		System.out.println("###### 누적된 값이 최소가되는 값은 ??? ######");
		int len = random.nextInt(5) + 1;
		int[] arr1 = new int[len];
		for(int i = 0; i < len; i++) {
			arr1[i] = random.nextInt(10) + 1;
		}
		int[] arr2 = new int[len];
		for(int i = 0; i < len; i++) {
			arr2[i] = random.nextInt(10) + 1;
		}
		System.out.println("배열1 >> " + Arrays.toString(arr1));
		System.out.println("배열2 >> " + Arrays.toString(arr2));
		int answer = 0;
		int mul = 0;
		int j = arr2.length - 1;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for(int i = 0; i < arr1.length; i++) {
			mul = arr1[i] * arr2[j];
			answer += mul;
			j--;
		}
		System.out.print("나의 정답 >> ");
		int respond = sc.nextInt();
		System.out.println("문제 정답 >> " + answer);
		if(respond == answer) {
			System.out.println("정답!!!");
			return 1;
		}
		else {
			System.out.println("땡!!!");
			return 0;
		}
	}

	public int lifeboat() {
		// TODO Auto-generated method stub
		System.out.println("###### 구명보트에는 최대 2명까지 탈 수있고 무게 제한도 있다. ######");
		System.out.println("###### 구할수 없는 경우는 없다. ######");
		System.out.println("###### 구명보트의 최소 갯수를 구하세요. ######");
		int len = random.nextInt(5) + 1;
		int[] people = new int[len];
		for(int i = 0; i < len; i++) {
			people[i] = random.nextInt(240) + 1;
		}
		int sub = Arrays.stream(people).max().getAsInt();
		int space = 240 - sub;
		int limit = random.nextInt(space + 1) + sub;
		System.out.println("사람들의 몸무게 >>" + Arrays.toString(people));
		System.out.println("구명보트 무게 제한 >> " + limit);
		System.out.print("나의 정답 >> ");
		int respond = sc.nextInt();
		Arrays.sort(people);
		int startIdx = 0;
		int lastIdx = people.length - 1;
		int cnt = 0;
		int cnt2 = 0;
		loop:while (startIdx <= lastIdx) {
			while(people[startIdx] + people[lastIdx] <= limit) {
				lastIdx--;
				startIdx++;
				cnt++;
				if(startIdx == lastIdx) {
                    cnt++;
					break loop;
				}
                else if(startIdx > lastIdx) {
					break loop;
				}
			}
			lastIdx--;
			cnt2++;
		}
		int answer = cnt + cnt2;
		System.out.println("문제 정답 >> " + answer);
		if(respond == answer) {
			System.out.println("정답!!!");
			return 1;
		}
		else {
			System.out.println("떙!!!");
			return 0;
		}
	}

}

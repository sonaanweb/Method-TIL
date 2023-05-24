package service;

import vo.Emp;
import vo.Student;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

// 1) 리턴타입 : void
public class VoidMethod {
	// 매개변수 : 없음. 반환타입도 void & 입력값도 void
	public void voidParam() {
		System.out.println("안녕하세요 구디아카데미입니다.");
	}
	
	//﻿ 2. 매개변수 : 기본타입(byte, short, int, long, float, double, char, boolean)
	
	public void intParam(int num) {
		if(num % 2 == 0) { // 짝수
			System.out.println("입력한 "+num+"은 짝수입니다");
			return; // 조건에 맞으면 계속 return 조건이 맞지않으면 빠져나가서 홀수출력
		}
		System.out.println("입력한 "+num+"은 홀수입니다");
	}
	
	// 2-1. 두개의 숫자(int)를 입력받아 21을 넘기지 않으면서 21에 더 가까운 수를 출력하는 메서드
	
	int a = 0; 
	int b = 0;
	public void int2param(int a, int b) {
		// a,b중 21을 넘기지 않으면서 21에 더 가까운 수
		// ex) 22, 9 -> 9 출력 & 21, 20 -> 21 출력 & 21, 21 -> 21 출력 & 23, 23 -> 없음
		if(a<21) {
			
		}
	}
	
	
	// 3. 매개변수 : String
	//startswith 첫글자
	public void StringParam(String name) {
		if(name.startsWith("김")||name.startsWith("이")||name.startsWith("박")) {
			System.out.println(name.substring(0,1)+"씨 입니다.");
		}else { // 김이박이 아니면
			System.out.println("김/이/박이 아닙니다");
		}
	}
	
	
	
	// 4. 매개변수(참조타입) : int 배열
	// int 배열을 입력받아 요소중 가장 큰수를 출력
	public void intArrayParam(int[] arr) { // ||(or)은 앞에것이 참이면 뒤를 계산하지 않는 것을 유의하자.
		if(arr == null || arr.length == 0 ) {
			System.out.println("입력 error");
			return; // 1. 메서드 종료 2. 종료 후 호출 코드 부분에 반환값 남김
		}
		int max = arr[0]; // ex) 5,7,10,1.. max값 정해두고 전체 물어봄
		for(int i=0; i<(arr.length); i+=1){
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println(max+"입니다");
	}
	
	// 기본(값)타입 매개변수 vs 참조(주소)타입 매개변수 넘기는 것에 대한 차이
	public void valueTypeParam(int value) {
		value = 777; // value값 777로 바꿈
	}
	
	public void referTypeParam(int[] refer) {
		refer[0] = 777; //래퍼의 0번째 값을 777로 바꿈 (주소값이 넘어간다)
	}
	
	// 5. 매개변수 : 배열(String 배열)
	// a. 어떤 값을 입력 받을 것인가?
	// b. 어떻게 처리(구현)할 것인가? "김"씨 성의 인원을 출력 + 유효성 검사 포함 -> 입력값은 null&0이 들어올 수 있으므로
	// c. 어떤 값을 반환 할 것인가? void
	public void strArrParam(String[] names) {
		// 전체 x명 중 김씨는 y명입니다
		if(names == null || names.length == 0) {
			System.out.println("이름을 배열을 입력하세요");
			return;
		}
		
		int nameCnt = 0;
		for(String n : names) {
			if(n.startsWith("김")) {
				nameCnt += 1; // 김씨면 cnt 1씩 증가
			}
		}
		System.out.printf("전체 %d명중 김씨는 %d명입니다\n",names.length, nameCnt);
		// printf(줄바꿈x) = ( "출력서식" , 내용 표현식 ) & (%d) (%d) <---n.length, nameCnt 순으로 변수명에 들어감
		// %d = 정수형 / %s = 문자열 / %f = 실수형 / %c = 문자형 / %b = boolean 형식으로 출력
		// \n (줄바꿈)
	}
	
	// 6. 매개변수 : 클래스
	// a. 어떤 값을 입력 받을 것인가? 한 학생의 정보
	// b. 어떻게 처리(구현)할 것인가? 학생 정보 출력 + 유효성 검사
	// c. 어떤 값을 반환 할 것인가? void
	/* Quiz. 입력 - id: 10, name:김홍철, gender: 남자, birth:1999
				  출력 - 10번, 김xx , 남자 , 25살 */
	public void clsParam(Student student) {
		if(student == null || student.getName() == null || student.getGender() == null) {
			return;
		}
		Calendar c = Calendar.getInstance();
		int age = c.get(Calendar.YEAR) - student.getBirth();
		System.out.printf("%d번, %sxx, %s, %d살\n",
				student.getId(),
				student.getName().substring(0,1),
				student.getGender(),
				age);
	}
	
	// 7. 매개변수 : 클래스 배열
	// a. 어떤 값을 입력 받을 것인가? 여러 학생의 정보(student[])
	// b. 어떻게 처리(구현)할 것인가? 남자 x명, 여자 x명
	// c. 어떤 값을 반환 할 것인가? void
	public void clsArrParam(Student[]students) {
		if(students == null) {
			return;
		}
		int mCnt = 0; //남자 인원
		int fCnt = 0; //여자 인원
		for(Student s : students) {
			if(s == null || s.getGender() == null) {
				return;
			}
			if(s.getGender().equals("남")) {
				mCnt++;
				
			} else if (s.getGender().equals("여")){
				fCnt++;
			}
		}
			System.out.println("남자는"+mCnt+"명, 여자는"+fCnt+"명\n");
		}
	
	// 8. 매개변수 : ArrayList
	// a. 어떤 값을 입력 받을 것인가? 여러 학생의 정보(List<Student>)
	// b. 어떻게 처리(구현)할 것인가? 전체 x명, 20대 x명, 30대 x명
	// c. 어떤 값을 반환 할 것인가? void
	public void listParam(ArrayList<Student> list) {
		if(list == null) {
			return;
		}

		int ages20 = 0;
		int ages30 = 0;
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for(Student s : list) {
			int age = currentYear - s.getBirth();
			int ages = age/ 10*10;
			if(age / 10 * 10 == 20) {
				ages20 ++;
			} else if(ages == 30) {
				ages30++;
			}
		}System.out.printf("전체 %d명, 20대 %d명, 30대 %d명\n", list.size(), ages20, ages30);
	}
	
	// 9. 매개변수 : HashMap
	// a. 어떤 값을 입력 받을 것인가? student 1명 + emp 1명 (하나의 hashmap으로 입력)
	// b. 어떻게 처리(구현)할 것인가? 학생이름 xxx이고, 담당직원의 이름은 xxx입니다.
	// c. 어떤 값을 반환 할 것인가? void
	public void mapParam(HashMap<String, Object> map) {
		if(map == null || map.size() == 0) {
			return;
		}
		Emp emp = (Emp)(map.get("e1"));
		Student student = (Student)(map.get("s1"));
		System.out.printf("학생 %s의 담당직원은 %s입니다", student.getName(), emp.getEmpName());
}
}
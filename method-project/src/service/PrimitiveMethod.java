package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import vo.Emp;
import vo.Student;
import vo.Subject;

public class PrimitiveMethod {
	
	 /*
		2. 리턴타입 : 기본타입(byte, short, int, long, float, double, char, boolean)
		1) 매개변수 : 없음
		2) 매개변수 : 기본타입(byte, short, int, long, float, double, char, boolean)
		3) 매개변수 : String
		4) 매개변수 : 배열(기본타입 배열)
		5) 매개변수 : 배열(String 배열)
		6) 매개변수 : 클래스
		7) 매개변수 : 배열(클래스 배열)
		8) 매개변수 : ArrayList
		9) 매개변수 : HashMap
	  */
	
	// 1) 매개변수 : 없음
	// a. 어떤 값을 입력 받을 것인가? void
	// b. 어떻게 처리(구현)할 것인가? 0 ~ int 최대값 중 하나를 리턴
	// c. 어떤 값을 반환 할 것인가? int
	public int voidParam() {
		// 최소값 0, 최대값 int타입 최대값 : integer
		double rNum = Math.random(); // 0.000000..~ 0.999999....
		long intMax = (long)Integer.MAX_VALUE +1;
		int returnValue = (int)(Math.floor(intMax * rNum));
		return returnValue;
	}
	
	// 2) 매개변수 : 기본타입
	// a. 어떤 값을 입력 받을 것인가? 태어난 년도
	// b. 어떻게 처리(구현)할 것인가? 성인 true & 아니면 false 
	// c. 어떤 값을 반환 할 것인가? boolean 
	public boolean primitiveParam(int birth) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		if(birth < 0 || birth > currentYear) {
			System.out.println("잘못된 입력");
			return false;
		}
		if(currentYear-birth > 18) { // 성인
			return true;
		}
		return false; // if문에 안 걸리면 false
	}
	
	// 2-1) 매개변수 : 기본타입
	// a. 어떤 값을 입력 받을 것인가? int, int = int값 2개
	// b. 어떻게 처리(구현)할 것인가? 두 입력값 중 더 큰값을 반환
	// c. 어떤 값을 반환 할 것인가? int
	public int primitive2Param(int num1, int num2) {
		if(num2 > num1) {
			return num2;
		} return num1;
}
	
	// 3) 매개변수 : String
	// a. 어떤 값을 입력 받을 것인가? 문자열 2개
	// b. 어떻게 처리(구현)할 것인가? firstNmae과 lastName의 길이를 반환
	// c. 어떤 값을 반환 할 것인가? int
	public int stringParam(String firstName, String lastName) {
		// 문자열 길이를 반환하는 size , length ....
		return firstName.length() + lastName.length();
	}

	// 4) 매개변수 : 배열(기본타입 배열)
	// a. 어떤 값을 입력 받을 것인가? int[]
	// b. 어떻게 처리(구현)할 것인가? 배열의 합
	// c. 어떤 값을 반환 할 것인가? int
	public long arrayParam(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		int sum = 0;
		for(int n : arr) {
			sum += n;
		}
		return sum;
	}
	
	// 5) 매개변수 : 배열(String 배열)
	// a. 어떤 값을 입력 받을 것인가? 이름 배열
	// b. 어떻게 처리(구현)할 것인가? 입력된 이름 중 한명이라도 블랙리스트 명단에 있으면 true, 아니면 false 
	// c. 어떤 값을 반환 할 것인가? boolean
	public boolean strArrParam(String[] names) {
		// 블랙리스트 명단
		final String[] blackList = {"루피","상디","조로"};
		
		// 유효성 검사
		for(String b : blackList) {
			for(String n : names) {
				if(b.equals(n)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	// 6) 매개변수 : 클래스
	// a. 어떤 값을 입력 받을 것인가? 학생타입의 id,pw 속성만 입력
	// b. 어떻게 처리(구현)할 것인가? 로그인
	// c. 어떤 값을 반환 할 것인가? boolean
	public boolean clsParam(Student student) {
		
		// 학생 DB목록
		Student[] db = new Student[3];
		db[0] = new Student();
		db[0].setId(100); db[0].setPw("1234");
		db[0] = new Student();
		db[0].setId(200); db[0].setPw("1234");
		db[0] = new Student();
		db[0].setId(300); db[0].setPw("1234");
		
		for(Student s: db) {
			if(s.getId()==student.getId() && s.getPw().equals(student.getPw())) {
				return true;
			}
		}
		return false;
	} 
	
	// 7) 매개변수 : 배열(클래스 배열)
	// a. 어떤 값을 입력 받을 것인가? 학생배열 Student[]
	// b. 어떻게 처리(구현)할 것인가? 성별이 여자인 사람의 평균 나이(소수점 두번째 자리까지)
	// c. 어떤 값을 반환 할 것인가? double
	public double clsArrParam(Student[] arr) {
		
		// 오늘 날짜의 년도
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		
		// 나이의 총합
		int sumAge = 0;
		
		// 나이의 평균
		double avgAge = 0;
		
		// 인원수
		int cnt = 0;
		
		for(Student s: arr) {
			if(s.getGender().equals("여자")) {
				cnt = cnt +1 ;
				int age = currentYear - s.getBirth();
				sumAge = sumAge + age;
			}
		}
		avgAge = (double)sumAge / (double)cnt;
		avgAge = Math.round(avgAge * 100) / 100; // 자바 반올림 api 정수부분까지 반올림한다,
													// 지금은 소수점 두번째자리까지 구하려고 하기 때문에
		
		return avgAge;
	} 
	
	// 8) 매개변수 : ArrayList
	// a. 어떤 값을 입력 받을 것인가? 성적데이터(4과목: 국어,영어,수학,과학)
	//	 ex) null이면 0+0+0+0, 국어 한 과목이 80이다, 나머지는 입력 안 됨 80+0+0+0
	// b. 어떻게 처리(구현)할 것인가? 4과목(4과목이 안 되면 0점으로 과목 추가) 평균 90이상 A, 80이상 B, 70이상 C 나머지 D
	// c. 어떤 값을 반환 할 것인가? char 'A','B','C','F'
	public char listParam(ArrayList<Subject> list) {
		// 변수값
		int sumScore = 0; //총점
		if(list != null) {
			for(Subject s: list) {
				sumScore += s.getScore();
			}
		}
		double avg = (double)sumScore / 4.0;
		char returnValue = '\0';
		if(avg >= 90) {
			returnValue = 'A';
		} else if(avg >= 80) {
			returnValue = 'B';
		} else if(avg >= 70) {
			returnValue = 'C';
		} else {
			returnValue = 'F';
		}
		return returnValue;
	}
	
	// 9) 매개변수 : HashMap
	// a. 어떤 값을 입력 받을 것인가? 두개의 리스트(student, emp)
	// b. 어떻게 처리(구현)할 것인가? 총인원(리스트사이즈의 합)을 계산
	// c. 어떤 값을 반환 할 것인가? int
	public int mapParam(HashMap<String, Object> map) {
		
		int studentCnt = 0;
		int empCnt = 0;
		
		// null 유효성검사
		
		ArrayList<Student> studentList = (ArrayList<Student>)map.get("studentList");
		ArrayList<Emp> empList = (ArrayList<Emp>)map.get("empList");
		studentCnt = studentList.size();
		empCnt = empList.size();
		return studentCnt + empCnt;
	}
}
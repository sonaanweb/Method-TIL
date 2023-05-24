import java.util.ArrayList;
import java.util.HashMap;

import service.VoidMethod;
import vo.Emp;
import vo.Student;

// 입출력 페이지

public class VoidMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			VoidMethod vm = new VoidMethod();
			vm.voidParam();
			
			int num = 8;
			vm.intParam(num);
			
			String name = "김철수";
			vm.StringParam(name);
			
			//배열
			int[] arr = {5, 1, 10, 7, 999, 21};
			vm.intArrayParam(arr);
			
			
			int value = 100;
			vm.valueTypeParam(value);
			System.out.println(value); // 100 출력
			System.out.println("======");
			
			//래퍼타입
			int[] refer = {1,2,3};
			vm.referTypeParam(refer);
			System.out.println(refer[0]); // 1(X), 777 출력
			
			
			//String배열
			String [] names = {"정현","오빈","김은","송지","김은"};
			vm.strArrParam(names);
			
			
			//클래스
			Student ch = new Student();
			ch.setId(3);
			ch.setName("최동욱");
			ch.setGender("남");
			ch.setBirth(1999);
			vm.clsParam(ch);
			
			//클래스 배열
			Student s1 = new Student();
			s1.setId(3);
			s1.setName("최동욱");
			s1.setGender("남");
			s1.setBirth(1999);
			
			Student s2 = new Student();
			s2.setId(3);
			s2.setName("최미진");
			s2.setGender("여");
			s2.setBirth(1999);
			
			Student s3 = new Student();
			s3.setId(3);
			s3.setName("정미진");
			s3.setGender("여");
			s3.setBirth(1999);
			
			Student[] students = new Student[3];
			students[0] = s1;
			students[1] = s2;
			students[2] = s3;
			vm.clsArrParam(students);
			
			
			//리스트 배열
			ArrayList<Student> list = new ArrayList<>();
			list.add(s1);
			list.add(s2);
			list.add(s3);
			vm.listParam(list);
			
			
			//해시맵
			Emp emp = new Emp();
			emp.setEmpName("루피");
			Student hkd = new Student();
			hkd.setName("홍길동");
			
			HashMap<String, Object> map = new HashMap<>();
			map.put("e1", emp); // 변수명, 들어갈 값
			map.put("s1", hkd);
			vm.mapParam(map);
			
			
	}
}

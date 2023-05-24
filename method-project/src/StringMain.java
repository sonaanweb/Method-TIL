import service.StringMethod;

public class StringMain {

	public static void main(String[] args) {
		StringMethod sm = new StringMethod();
		
		String filename = "dd.pdf";
		String fileEx = sm.stringParam(filename); // 변수에 새로 저장
		System.out.print(fileEx); ///sysout 결과 : pdf 확인
	}

}

package service;

public class StringMethod {
//	1) 매개변수 : 없음
//	2) 매개변수 : 기본타입(byte, short, int, long, float, double, char, boolean)
//	3) 매개변수 : String
	// a. 어떤 값을 입력 받을 것인가? 파일이름(확장자 포함)
	// b. 어떻게 처리(구현)할 것인가? 파일이름을 입력하면 파일의 확장자만 추출
	// c. 어떤값을 반환할 것인가? 확장자만 반환
	public String stringParam(String filename) {
		/*
		 school.jpg -> jpg
		 보고서.hwp -> hwp
		 극장.영수증.pdf -> pdf
		 */
		// String 초기화
		String fileEx="";
		
		if(filename == null || filename.equals("")) {
			return "파일명을 입력하세요"; // string return ""
		}
		fileEx = filename.substring(filename.lastIndexOf(".") + 1);
		// lastindexof 기준점 뒤(오른쪽)
		return fileEx;
}
}
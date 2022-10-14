package edu.kh.jsp.student.model.vo;

public class Student {
	private String studentNo;		// 학번
	
	private String studentName;		// 이름
	
	private String studentAddress;	// 주소

	private String departmentName;  // 학과명
	
	// 기본 생성자 컨+스페이스+엔터
	public Student() {

	
	}

	// alt + shift + s + r
	public String getStudentNo() {
		return studentNo;
	}


	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getStudentAddress() {
		return studentAddress;
	}


	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	
	// alt + shift+ s + s
	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ ", departmentName=" + departmentName + "]";
	}


	// alt + shift + s + o
	public Student(String studentNo, String studentName, String studentAddress, String departmentName) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.departmentName = departmentName;
	}
	
	
}

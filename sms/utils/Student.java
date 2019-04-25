package sms.utils;
/**
 * 学生信息表
 */
public class Student {

	private String stuId;	//声明学生学号
	private String stuName;	//声明学生姓名
	private String stuSex;	//声明学生性别
	private int stuAge;		//声明学生年龄
	private int stuMark = -1;	//声明学生成绩
	private String stuPass;		//学生账号密码
	
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	
	public int getStuMark() {
		return stuMark;
	}
	public void setStuMark(int stuMark) {
		this.stuMark = stuMark;
	}
	
	public String getStuPass() {
		return stuPass;
	}
	public void setStuPass(String stuPass) {
		this.stuPass = stuPass;
	}

}

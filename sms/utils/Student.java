package sms.utils;
/**
 * ѧ����Ϣ��
 */
public class Student {

	private String stuId;	//����ѧ��ѧ��
	private String stuName;	//����ѧ������
	private String stuSex;	//����ѧ���Ա�
	private int stuAge;		//����ѧ������
	private int stuMark = -1;	//����ѧ���ɼ�
	private String stuPass;		//ѧ���˺�����
	
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

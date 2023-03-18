package sms.utils;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
	/**
	 * ����ͼ����Ϣ
	 */
	public static void saveStudent(Student stu){
		String name = "ѧ��������Ϣ��¼.csv";//ƴ���ļ���
		InputStream in = null;
		try {
			in = new FileInputStream(name);
			if(in != null) {
				in.close();//�ر�������
				createFile(name,true,stu);//�����ļ�����ȡ�޸��ļ���ʽ
			}
		}catch (FileNotFoundException e) {
			createFile(name,false,stu);//�������ļ�����ȡ�½��ļ���ʽ
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	//�޸�/���� �ļ�����
	private static void createFile(String name, boolean label, Student stu) {
		BufferedOutputStream out = null;
		StringBuffer sbf = new StringBuffer();//ƴ������
		try {
			if(label) {
				//���������,����׷���ļ�
				out = new BufferedOutputStream(new FileOutputStream(name,true));
			}else {
				//��������������ڱ����ļ�
				out = new BufferedOutputStream(new FileOutputStream(name));
				String[] fieldSort = new String[] {"ѧ��ѧ��","ѧ������","ѧ���Ա�","ѧ������","����ʱ��"};
				//������ͷ
				for (String fielkye : fieldSort) {
					//�½���ʱ������ͷ���뱾���ļ�
					sbf.append(fielkye).append(",");
				}
			}
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyy/MM/dd");//�������ڸ�ʽ
			sbf.append("\r\n");
			sbf.append(stu.getStuId()).append(",");
			sbf.append(stu.getStuName()).append(",");
			sbf.append(stu.getStuSex()).append(",");
			sbf.append(stu.getStuAge()).append(",");
			sbf.append(format.format(date));
			String str = sbf.toString();
			byte[] b = str.getBytes();
			for(int i=0; i<b.length; i++) {
				out.write(b[i]);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(out != null) 
					out.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}

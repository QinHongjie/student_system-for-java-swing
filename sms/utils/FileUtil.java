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
	 * 保存图书信息
	 */
	public static void saveStudent(Student stu){
		String name = "学生添增信息记录.csv";//拼接文件名
		InputStream in = null;
		try {
			in = new FileInputStream(name);
			if(in != null) {
				in.close();//关闭输入流
				createFile(name,true,stu);//存在文件，采取修改文件方式
			}
		}catch (FileNotFoundException e) {
			createFile(name,false,stu);//不存在文件，采取新建文件方式
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	//修改/创建 文件方法
	private static void createFile(String name, boolean label, Student stu) {
		BufferedOutputStream out = null;
		StringBuffer sbf = new StringBuffer();//拼接内容
		try {
			if(label) {
				//创建输出流,用于追加文件
				out = new BufferedOutputStream(new FileOutputStream(name,true));
			}else {
				//创建输出流，用于保存文件
				out = new BufferedOutputStream(new FileOutputStream(name));
				String[] fieldSort = new String[] {"学生学号","学生姓名","学生性别","学生年龄","增加时间"};
				//创建表头
				for (String fielkye : fieldSort) {
					//新建表时，将表头存入本地文件
					sbf.append(fielkye).append(",");
				}
			}
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyy/MM/dd");//定义日期格式
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

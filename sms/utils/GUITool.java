package sms.utils;

import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GUITool {
	
	static Toolkit kit = Toolkit.getDefaultToolkit();

	//��Ҫ�����øù���ȫ������
	public static void setAll(JFrame frame){
		
		center(frame);
		
		frame.setResizable(false);//���ô���ߴ粻�ɸı�
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//��ָ�������Ļ����
	public static void center(Component c) {
		int x = (kit.getScreenSize().width - c.getWidth()) / 2;
		int y = (kit.getScreenSize().height - c.getHeight()) / 2;
		c.setLocation(x, y-50);
	}
}

package sms.register;

import javax.swing.*;

import sms.utils.GUITool;

/**
 * ע��������
 */
public class RegisterGUI {
	
	static JFrame frame = new JFrame("ѧ������ϵͳ-ע��");
	JPanel panel = new JPanel();//��������
	
	RegisterPanel registerPanel = new RegisterPanel();//����ע��������
	
	//���д˴��ڷ���
	public void run() {
		frame.setSize(425, 605);
		frame.setResizable(false);//���ô���ߴ粻�ɸı�
		
		frame.add(registerPanel.panel(frame));//�򴰿���ӽ���

		GUITool.center(frame);	//���ô�������Ļ�о�����ʾ
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new RegisterGUI().run();
	}
}
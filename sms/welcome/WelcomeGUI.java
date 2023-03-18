package sms.welcome;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sms.login.LoginGUI;
import sms.utils.BackgroundPanel;
import sms.utils.GUITool;
/**
 * @ѧ������ϵͳ
 * @ ��ӭ����-��������
 */
public class WelcomeGUI extends BackgroundPanel{	//�̳��б�������
	
	private static JFrame frame = new JFrame("ѧ������ϵͳ-��ӭ����");
	
	private JButton but = new JButton("����ϵͳ");	//������ť

	//���ø��๹�췽��Ϊ�����������ñ���
	protected WelcomeGUI() {
		super("images/stu_welcome.jpg");
		super.font = new Font("����", Font.ITALIC, 30);
	}
	
	void run() {
		frame.setSize(900, 580);
		
		frame.add(fristPanel());	//�������
		buttonClick();
		
		GUITool.setAll(frame);	//ͨ�����������ô��ڱ�����
		frame.setVisible(true);
	}
	//��������
	private JPanel fristPanel() {
		panel.setLayout(null);		//ȡ��Ĭ�ϲ�����
		panel.setOpaque(false);		//��������͸�����Կ����²�ͼƬ
		panel.add(button());		//����������Ӱ�ť���
		return panel;
	}
	//'����ϵͳ'-��ť���
	private JButton button() {	
		but.setBounds(500, 160, 180, 50);	//��ť��λ����С
		but.setFont(font);					//���������ʽ
		return but;
	}
	//���ð�ť����¼�
	private void buttonClick() {
		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginGUI().run();
			}
		});
	}
	
	public static void main(String[] asd) {
		new WelcomeGUI().run();
	}
}
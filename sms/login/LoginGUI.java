package sms.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import sms.utils.GUITool;
/**
 * ��¼����
 */
//@SuppressWarnings("serial")
public class LoginGUI{
	
	public JFrame frame = new JFrame("ѧ������ϵͳ-��¼");
	public JPanel panel = new JPanel();//��������
	
	StudentLoginPanel studentLogin = new StudentLoginPanel();//����ѧ����¼�������
	RootLoginPanel rootLogin = new RootLoginPanel();//���������¼�������
	
	JMenuBar menuBar = new JMenuBar();//�����˵���
	JMenu menu = new JMenu("Ȩ��ѡ��");//�����˵�
	
	JMenuItem item1 = new JMenuItem("����Ա"),
			  item2 = new JMenuItem("ѧ��");//���������˵���
	//���д˴��ڷ���
	public void run() {
		frame.setSize(780, 560);

		frame.setJMenuBar(menuBar());	//���˵�����ӵ�����
		i1Click();	//Ϊ������Ա���˵�����ӵ���¼�
		i2Click();	//Ϊ��ѧ�����˵�����ӵ���¼�
		
		panel = studentLogin.panel(frame);//ʹ����Ϊѧ����¼����
		frame.add(panel);//�򴰿���ӽ���
		
		GUITool.setAll(frame);	//������ô���ͨ������
		frame.setVisible(true);
	}
	//���ò˵���
	protected JMenuBar menuBar() {
		menuBar.add(menu);	//���˵���ӵ��˵���
		
		menu.setSize(100, 20);
		menu.add(item1);	//���'����Ա'�˵���
		menu.addSeparator();//���һ���ָ���
		menu.add(item2);	//���'ѧ��'�˵���
		
		return menuBar;
	}
	//Ϊ'����Ա'-�˵�������¼�������
	private void i1Click() {
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);//ж�ص�ǰ����
				panel = rootLogin.panel(frame);//ʹ����Ϊ�����¼����
				frame.add(panel);//��ӽ���
				panel.updateUI();//ʹ����ǿ��ˢ��
			}
		});
	}
	//Ϊ'ѧ��'-�˵�������¼�������
	private void i2Click() {
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);//ж�ص�ǰ����
				panel = studentLogin.panel(frame);//ѧ����¼����
				frame.add(panel);//��ӽ���
				panel.updateUI();//ǿ��ˢ��
			}
		});
	}
	//���Է���
	public static void main(String[] args) {
		new LoginGUI().run();
	}
}

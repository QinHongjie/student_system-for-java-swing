package sms.root;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import sms.login.LoginGUI;
import sms.utils.GUITool;
/**
 * ѧ������ϵͳ-����������
 */
public class RootGUI {
	
	static JFrame frame = new JFrame("ѧ������ϵͳ-����������");
	LoginGUI loginGUI = new LoginGUI();
	
	JMenuBar menuBar = new JMenuBar();//�����˵���
	JMenu menu = new JMenu("����");//�����˵�
	
	JMenuItem item1 = new JMenuItem("���ص�¼"),
			  item2 = new JMenuItem("�˳�ϵͳ");//���������˵���
	
	//���д˴��ڷ���
	public void run() {
		frame.setSize(1200, 700);
		frame.add(new RootPanel(frame).panel(frame));
		
		frame.setJMenuBar(menuBar());	//���˵�����ӵ�����
		i1Click();	//Ϊ�����ص�¼���˵�����ӵ���¼�
		i2Click();	//Ϊ���˳�ϵͳ���˵�����ӵ���¼�
		
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
	//Ϊ'���ص�¼'-�˵�������¼�������
	private void i1Click() {
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();//�رյ�ǰ����
				loginGUI.run();//�򿪵�¼����
			}
		});
	}
	//Ϊ'�˳�ϵͳ'-�˵�������¼�������
	private void i2Click() {
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//�˳�����
			}
		});
	}
	//���Է���
	public static void main(String[] args) {
		new RootGUI().run();
	}
}
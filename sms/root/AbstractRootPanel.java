package sms.root;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import sms.utils.BackgroundPanel;
import sms.utils.MyFocusListener;

/**
 * �������������ڱ��������
 */
public abstract class AbstractRootPanel extends BackgroundPanel{

	//ѧ����Ϣ��Ҫ�õ������
	protected JTable table = new JTable();	//ѧ���б�
	protected JScrollPane tablePane = new JScrollPane();//�����Ӵ�
	
	private JLabel tableLabel = new JLabel("ѧ����Ϣ��");//ѧ�������
	private JLabel idLabel = new JLabel("ѧ��");//ID����
	private JLabel nameLabel = new JLabel("����");//��������
	private JLabel sexLabel = new JLabel("�Ա�");//�Ա����
	private JLabel ageLabel = new JLabel("����");//�������
	//��ӹ������
	protected JTextField addIdText = new JTextField();//���id�ı���
	protected JTextField addNameText = new JTextField();//��������ı���
	protected JTextField addSexText = new JTextField();//����Ա��ı���
	protected JTextField addAgeText = new JTextField();//��������ı���
	private JButton addButton = new JButton("�����Ϣ");//��Ӱ�ť
	//�޸Ĺ������
	protected JTextField updateIdText = new JTextField();//�޸�id�ı���
	protected JTextField updateNameText = new JTextField();//�޸������ı���
	protected JTextField updateSexText = new JTextField();//�޸��Ա��ı���
	protected JTextField updateAgeText = new JTextField();//�޸������ı���
	private JButton updateButton = new JButton("�޸���Ϣ");//ɾ����ť
	//ɾ���������
	protected JTextField delIdText = new JTextField();//���id�ı�
	private JButton delBtu = new JButton("ɾ����Ϣ");//ɾ����ť
	//���óɼ��������
	private JLabel markLabel = new JLabel("*Ϊѧ�����*");//���óɼ�����
	protected JTextField markIdText = new JTextField();//Ҫ���÷�����id�ı���
	protected JTextField markText = new JTextField();//�޸ķ����ı���
	protected JButton markBut = new JButton("���÷���");//��ְ�ť
	
	//�̳��Ա��������๹�췽���������ڴ����Ȳ�ʵ��
	protected AbstractRootPanel(JFrame frame) {
		super("images/stu_root.jpg");
		addComponent();//������
		addListener(frame);//��Ӱ�ť����
		setFont();//����������ʽ
	}
	
	//������
	private void addComponent() {
		//������
		tableLabel.setBounds(380, 20, 140, 30);
		panel.add(tableLabel);
		//���
		table.getTableHeader().setReorderingAllowed(false);//�в����ƶ�
		table.getTableHeader().setReorderingAllowed(false);//�����������
		table.setEnabled(false);//���ɸ�������
		table.getTableHeader().setPreferredSize(new Dimension(1, 25));//���ñ�ͷ�߶�
		table.getTableHeader().setFont(font);//���ñ�ͷ����
		table.setRowHeight(30);//���ñ��ÿ���ֶθ߶�
		table.setFont(font);
		table.setForeground(Color.WHITE);
		//����װ������ͼ
		tablePane.setBounds(50, 60, 800, 300);
		tablePane.setViewportView(table);//�ӿ�װ����
		tablePane.setOpaque(false);	//����װ������ͼ͸��
		tablePane.getViewport().setOpaque(false);//��ͼ͸��
		panel.add(tablePane);
		//�ֶα���
		idLabel.setBounds(100, 385, 70, 25);
		nameLabel.setBounds(260, 385, 70, 25);
		sexLabel.setBounds(410, 385, 70, 25);
		ageLabel.setBounds(570, 385, 70, 25);
		panel.add(idLabel);
		panel.add(nameLabel);
		panel.add(sexLabel);
		panel.add(ageLabel);
		//�������
		addIdText.setBounds(50, 440, 150, 30);
		addNameText.setBounds(240, 440, 100, 30);
		addSexText.setBounds(390, 440, 100, 30);
		addSexText.addFocusListener(new MyFocusListener("��/Ů",addSexText));
		addAgeText.setBounds(550, 440, 100, 30);
		panel.add(addIdText);
		panel.add(addNameText);
		panel.add(addSexText);
		panel.add(addAgeText);
		addButton.setBounds(700, 440, 140, 35);
		panel.add(addButton);
		//�޸����
		updateIdText.setBounds(50, 500, 150, 30);
		updateNameText.setBounds(240, 500, 100, 30);
		updateSexText.setBounds(390, 500, 100, 30);
		updateSexText.addFocusListener(new MyFocusListener("��/Ů",updateSexText));
		updateAgeText.setBounds(550, 500, 100, 30);
		panel.add(updateIdText);
		panel.add(updateNameText);
		panel.add(updateSexText);
		panel.add(updateAgeText);
		updateButton.setBounds(700, 500, 140, 35);
		panel.add(updateButton);
		//ɾ�����
		delIdText.setBounds(50, 560, 150, 30);
		panel.add(delIdText);
		delBtu.setBounds(700, 560, 140, 35);
		panel.add(delBtu);
		//�������
		markLabel.setBounds(888, 60, 200, 30);
		markIdText.setBounds(888, 120, 150, 30);
		markIdText.addFocusListener(new MyFocusListener("(����ѧ��)",markIdText));
		markText.setBounds(888, 180, 150, 30);
		markText.addFocusListener(new MyFocusListener("Max's 100",markText));
		markBut.setBounds(888, 240, 140, 40);
		panel.add(markLabel);
		panel.add(markIdText);
		panel.add(markText);
		panel.add(markBut);
	}
	
	//��Ӽ�����
	private void addListener(JFrame frame) {
		//��Ӱ�ť����
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//������ӷ���
				addStudent(frame);
			}
		});
		//�޸İ�ť����
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�����޸ķ���
				updateStudent(frame);
			}
		});
		//ɾ����ť����
		delBtu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//����ɾ������
				delStudent(frame);
			}
		});
		//���ְ�ť����
		markBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//����ɾ������
				setMark(frame);
			}
		});
	}
	//Ϊ����������Ԫ������������ʽ
	private void setFont() {
		//Ϊ�����������������ʽ
		Component[] com = panel.getComponents();
		for(int i = 0; i < com.length; i++) {
			com[i].setFont(font);
		}
		//Ϊ���б�ǩ�����������Ϊ��ɫ
		tableLabel.setForeground(Color.WHITE);
		idLabel.setForeground(Color.WHITE);
		nameLabel.setForeground(Color.WHITE);
		sexLabel.setForeground(Color.WHITE);
		ageLabel.setForeground(Color.WHITE);
		markLabel.setForeground(Color.WHITE);
		//Ϊ��ť��������Ϊ��ɫ
		addButton.setForeground(Color.blue);
		updateButton.setForeground(Color.blue);
		delBtu.setForeground(Color.blue);
		markBut.setForeground(Color.blue);
	}
	//��ѯ���ݲ���ӽ�����
	public abstract String[][] tbody();
	//��ӷ���
	public abstract void addStudent(JFrame frame);
	//�޸ķ���
	public abstract void updateStudent(JFrame frame);
	//ɾ������
	public abstract void delStudent(JFrame frame);
	//���ַ���
	public abstract void setMark(JFrame frame);
}

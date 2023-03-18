package sms.root;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sms.jdbc.JDBC;
import sms.utils.FileUtil;
import sms.utils.Student;

public class RootPanel extends AbstractRootPanel{

	String id, name, sex, age, mark;//������Ϣ�洢�ռ�
	
	//����ү�๹�췽��Ϊ�������ñ���
	protected RootPanel(JFrame frame) {
		super(frame);
	}
	public JPanel panel(JFrame frame) {
		//��ӱ�����
		String[] thead = new String[] {"ѧ��","����","�Ա�","����","����"};
		//������������
		TableModel date = new DefaultTableModel(tbody(), thead);
		table.setModel(date);
		
		setTableOpaque(thead);//�����н����ÿ����Ⱦ��͸��
		return panel;
	}
	
	//��ѯ����
	public String[][] tbody() {
		ArrayList<Student> list = new JDBC().select();
		String[][] tbody = new String[list.size()][5];
		for(int i = 0; i < list.size(); i++) {
			Student stu = list.get(i);
			tbody[i][0] = stu.getStuId();
			tbody[i][1] = stu.getStuName();
			tbody[i][2] = stu.getStuSex();
			tbody[i][3] = stu.getStuAge()+"";
			if(stu.getStuMark() == -1) {
				tbody[i][4] = null;
			}else {
				tbody[i][4] = stu.getStuMark()+"";
			}
		}
		return tbody;
	}
	
	//��ӷ���
	public void addStudent(JFrame frame) {
		id = addIdText.getText();
		name = addNameText.getText();
		sex = addSexText.getText();
		age = addAgeText.getText();
		RootCheck rootCheck = new RootCheck(frame, id, name, sex, age);
		if(!rootCheck.isSome(id, name)) {
			if(rootCheck.flag) {
				//����ȷ��Ϣ��ӽ����ݿ�
				new JDBC().add(id, name, sex, Integer.parseInt(age), id);
				//��¼������Ϣ
				Student stu = new Student();
				stu.setStuId(id);
				stu.setStuName(name);
				stu.setStuSex(sex);
				stu.setStuAge(Integer.parseInt(age));
				FileUtil.saveStudent(stu);
				//��Ϣ��ӳɹ���ʾ
				rootCheck.right(frame,"���");
				//�����Ϣ��ȷ����ˢ�½���
				frame.remove(panel);
				panel = new RootPanel(frame).panel(frame);
				frame.add(panel);
				panel.updateUI();
			}
		}
	}
	
	//�޸ķ���
	public void updateStudent(JFrame frame) {
		id = updateIdText.getText();
		name = updateNameText.getText();
		sex = updateSexText.getText();
		age = updateAgeText.getText();
		RootCheck rootCheck = new RootCheck(frame, id, name, sex, age);
		if(!rootCheck.alterIsSome(id, name)) {
			if(rootCheck.flag) {
				//����ȷ��Ϣ��ӽ����ݿ�
				new JDBC().alter(id, name, sex, Integer.parseInt(age));
				//��Ϣ�޸ĳɹ���ʾ
				rootCheck.right(frame,"�޸�");
				//�����Ϣ��ȷ����ˢ�½���
				frame.remove(panel);
				panel = new RootPanel(frame).panel(frame);
				frame.add(panel);
				panel.updateUI();
			}
		}
	}
	
	//ɾ������
	public void delStudent(JFrame frame) {
		id = delIdText.getText();
		new JDBC().delete(id);
		//ˢ�½���
		frame.remove(panel);
		panel = new RootPanel(frame).panel(frame);
		frame.add(panel);
		panel.updateUI();
	}

	//���ַ���
	public void setMark(JFrame frame) {
		id = markIdText.getText();
		mark = markText.getText();
		MarkCheck markCheck = new MarkCheck(frame, id, mark);
		if(markCheck.flag) {
			//ˢ�½���
			frame.remove(panel);
			panel = new RootPanel(frame).panel(frame);
			frame.add(panel);
			panel.updateUI();
		}
	}
	
	//��Ⱦ���͸��
	private void setTableOpaque(Object[] thead) {
		//Ĭ�ϵı��Ԫ����Ⱦ��
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		//��������������У�������Ⱦ������Ϊrenderer
		renderer.setOpaque(false);//����renderer��Ԫ������-͸��
		for(int i = 0; i < thead.length; i++) {
			table.getColumn(thead[i]).setCellRenderer(renderer);
		}
		table.setOpaque(false);//��table����Ϊ͸��
	}
}

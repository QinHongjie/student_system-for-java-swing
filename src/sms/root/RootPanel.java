package sms.root;

import sms.jdbc.JDBC;
import sms.utils.FileUtil;
import sms.utils.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class RootPanel extends AbstractRootPanel{

	String id, name, sex, age, mark;//创建信息存储空间

	//利用爷类构造方法为容器设置背景
	protected RootPanel(JFrame frame) {
		super(frame);
	}
	public JPanel panel(JFrame frame) {
		//添加表列名
		String[] thead = new String[] {"学号","姓名","性别","年龄","分数"};
		//向表中添加数据
		TableModel date = new DefaultTableModel(tbody(), thead);
		table.setModel(date);

		setTableOpaque(thead);//利用列将表格每列渲染成透明
		return panel;
	}

	//查询方法
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

	//添加方法
	public void addStudent(JFrame frame) {
		id = addIdText.getText();
		name = addNameText.getText();
		sex = addSexText.getText();
		age = addAgeText.getText();
		RootCheck rootCheck = new RootCheck(frame, id, name, sex, age);
		if(!rootCheck.isSome(id, name)) {
			if(rootCheck.flag) {
				//将正确信息添加进数据库
				new JDBC().add(id, name, sex, Integer.parseInt(age), id);
				//记录增添信息
				Student stu = new Student();
				stu.setStuId(id);
				stu.setStuName(name);
				stu.setStuSex(sex);
				stu.setStuAge(Integer.parseInt(age));
				FileUtil.saveStudent(stu);
				//信息添加成功提示
				rootCheck.right(frame,"添加");
				//如果信息正确无误，刷新界面
				frame.remove(panel);
				panel = new RootPanel(frame).panel(frame);
				frame.add(panel);
				panel.updateUI();
			}
		}
	}

	//修改方法
	public void updateStudent(JFrame frame) {
		id = updateIdText.getText();
		name = updateNameText.getText();
		sex = updateSexText.getText();
		age = updateAgeText.getText();
		RootCheck rootCheck = new RootCheck(frame, id, name, sex, age);
		if(!rootCheck.alterIsSome(id, name)) {
			if(rootCheck.flag) {
				//将正确信息添加进数据库
				new JDBC().alter(id, name, sex, Integer.parseInt(age));
				//信息修改成功提示
				rootCheck.right(frame,"修改");
				//如果信息正确无误，刷新界面
				frame.remove(panel);
				panel = new RootPanel(frame).panel(frame);
				frame.add(panel);
				panel.updateUI();
			}
		}
	}

	//删除方法
	public void delStudent(JFrame frame) {
		id = delIdText.getText();
		new JDBC().delete(id);
		//刷新界面
		frame.remove(panel);
		panel = new RootPanel(frame).panel(frame);
		frame.add(panel);
		panel.updateUI();
	}

	//评分方法
	public void setMark(JFrame frame) {
		id = markIdText.getText();
		mark = markText.getText();
		MarkCheck markCheck = new MarkCheck(frame, id, mark);
		if(markCheck.flag) {
			//刷新界面
			frame.remove(panel);
			panel = new RootPanel(frame).panel(frame);
			frame.add(panel);
			panel.updateUI();
		}
	}

	//渲染表格透明
	private void setTableOpaque(Object[] thead) {
		//默认的表格单元格渲染器
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		//遍历表格中所有列，将其渲染器设置为renderer
		renderer.setOpaque(false);//设置renderer单元格属性-透明
		for(int i = 0; i < thead.length; i++) {
			table.getColumn(thead[i]).setCellRenderer(renderer);
		}
		table.setOpaque(false);//将table设置为透明
	}
}

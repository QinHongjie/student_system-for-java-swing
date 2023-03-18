package sms.login;

import com.mysql.jdbc.Connection;
import sms.utils.GUITool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * 验证登录信息是否为空
 */
public abstract class LoginCheckNull {
	
	protected Font font = new Font("宋体", Font.BOLD, 25);//创建字体
	protected static JDialog dialog;//创建弹出提示窗对象
	protected JLabel label = new JLabel();//创建标签
	protected JButton button = new JButton("确认");//创建按钮
	
	static Connection conn = null;	//创建mysql连接对象
	static Statement stmt = null;	//创建执行mysql命令对象
	static ResultSet rs = null;	//创建mysql返回结果集对象
	
	protected String name = "姓名",pass = "密码";
	
	//构造注册事件验证
	public LoginCheckNull(JFrame frame, String user, String password) {
		dialog = new JDialog(frame,"提示",true);//向主窗体添加弹窗
		dialog().add(label());	//向弹窗添加提示标签
		dialog().add(button());	//向弹窗添加确认按钮
		buttonClick();//添加按钮点击事件
	}
	//判断 用户名/密码 是否为空
	public Boolean isNull(String user, String password) {
		if(user.length() == 0 || user.startsWith("请输入")) {
			label.setText(name+"不能为空！");
			label.setForeground(Color.red);
			return true;
		}else {
			if(password.length() == 0) {
				label.setText(pass+"不能为空！");
				label.setForeground(Color.red);
				return true;
			}
		}
		return false;
	}
	//弹出窗组件设置
	private JDialog dialog() {
		dialog.setLayout(new FlowLayout(FlowLayout.CENTER,30,40));
		dialog.setResizable(false);//设置窗体尺寸不可改变
		dialog.setSize(300, 250);
		GUITool.center(dialog);	//设置弹窗在屏幕中居中显示
		return dialog;
	}
	//标签提示信息组件
	private JLabel label() {
		label.setSize(180, 35);		//设置标签信息大小
		label.setFont(font);		//添加字体
		return label;
	}
	//'确认'按钮组件
	private JButton button() {	
		button.setSize(180, 50);	//按钮大小
		button.setFont(font);		//添加字体样式
		return button;
	}
	//确认按钮-点击事件
	private void buttonClick() {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();//关闭当前弹窗
			}
		});
	}
}

package sms.utils;

import javax.swing.*;
import java.awt.*;

public class GUITool {

	static Toolkit kit = Toolkit.getDefaultToolkit();

	//需要的设置该工具全部性质
	public static void setAll(JFrame frame){

		center(frame);

		frame.setResizable(false);//设置窗体尺寸不可改变

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//将指定组件屏幕居中
	public static void center(Component c) {
		int x = (kit.getScreenSize().width - c.getWidth()) / 2;
		int y = (kit.getScreenSize().height - c.getHeight()) / 2;
		c.setLocation(x, y-50);
	}
}

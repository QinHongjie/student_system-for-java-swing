package sms.utils;

import javax.swing.*;
import java.awt.*;
/**
 * 背景图片设置工具类
 */
@SuppressWarnings("serial")
public abstract class BackgroundPanel{

	protected Font font = new Font("宋体", Font.BOLD, 25);//创建字体

	protected JPanel panel = new JPanel();//创建容器

	//构造方法
	protected BackgroundPanel(String url){
		panel = set(url);//调用方法为容器设置背景
		panel.setLayout(null);//取消容器默认布局流
	}

	public JPanel set(String url) {
		//创建有背景的Panel容器对象
		JPanel panel = new JPanel() {
			//重写painComponent方法，以设置容器背景
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				//背景图片
				ImageIcon img = new ImageIcon(url);
				//向容器添加背景图片,并使背景图片填充整个窗口容器
				g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), img.getImageObserver());

			}
		};
		return panel;
		//向容器插入图片方法
//        JLabel label = new JLabel();
//        ImageIcon img = new ImageIcon(url);// 创建图片对象
//        label.setIcon(img);
//        panel.add(label);
//        jf.add(panel);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);// JFrame最大化
//        setVisible(true);// 显示JFrame
	}

}
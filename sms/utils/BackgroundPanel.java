package sms.utils;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * ����ͼƬ���ù�����
 */
@SuppressWarnings("serial")
public abstract class BackgroundPanel{
	
	protected Font font = new Font("����", Font.BOLD, 25);//��������
	
	protected JPanel panel = new JPanel();//��������
	
	//���췽��
	protected BackgroundPanel(String url){
		panel = set(url);//���÷���Ϊ�������ñ���
		panel.setLayout(null);//ȡ������Ĭ�ϲ�����
	}
	
    public JPanel set(String url) {
    	//�����б�����Panel��������
        JPanel panel = new JPanel() {
        	//��дpainComponent��������������������
        	public void paintComponent(Graphics g) {
	        	super.paintComponent(g);
	        	//����ͼƬ
	        	ImageIcon img = new ImageIcon(url);
	        	//��������ӱ���ͼƬ,��ʹ����ͼƬ���������������
	        	g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), img.getImageObserver());
	        	
        	}
        };
        return panel;
        //����������ͼƬ����
//        JLabel label = new JLabel();
//        ImageIcon img = new ImageIcon(url);// ����ͼƬ����
//        label.setIcon(img);
//        panel.add(label);
//        jf.add(panel);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);// JFrame���
//        setVisible(true);// ��ʾJFrame
    }
    
}
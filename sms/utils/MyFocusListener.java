package sms.utils;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
/**
 * �����¼���
 */
public class MyFocusListener implements FocusListener{
	
	String info;//���ڴ洢��ʾ��Ϣ
    JTextField jtf;//�ı�������
    
    public MyFocusListener(String info, JTextField jtf) {
        this.info = info;
        this.jtf = jtf;
    }
    
    @Override
    public void focusGained(FocusEvent e) {//��ý����ʱ��,�����ʾ����
        String temp = jtf.getText();
        if(temp.equals(info)){
            jtf.setText("");
            jtf.setForeground(Color.black);
        }
    }
    @Override
    public void focusLost(FocusEvent e) {//ʧȥ�����ʱ��,�ж����Ϊ��,����ʾ��ʾ����
        String temp = jtf.getText();
        if(temp.equals("")){
            jtf.setText(info);
            jtf.setForeground(Color.gray);
        }
    }

}

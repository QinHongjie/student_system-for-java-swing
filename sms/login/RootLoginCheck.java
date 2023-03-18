package sms.login;

import java.awt.Color;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;

import sms.root.RootGUI;
import sms.utils.JDBCUtils;

/**
 * ����Ա��¼��֤��
 */
public class RootLoginCheck extends LoginCheckNull {
	
	//���췽����֤��Ϣ��ȷ��
	@SuppressWarnings("static-access")
	public RootLoginCheck(JFrame frame, String user, String password) {
		super(frame, user, password);
		//���������ʾ
		if(isNull(user,password)) {
			dialog.setVisible(true);
		}else {
			//������/IDȷ������
			if(isRightData(user, password)) {
				frame.dispose();//�رյ�¼����
				new RootGUI().run();//�򿪹���������
			}else {
				dialog.setVisible(true);
			}
		}
	}
	//��֤ �û���/���� �����Ƿ���ȷ
		public Boolean isRightData(String user, String password) {
			Map<String, String> dataList = new HashMap<String, String>();
			try {
				conn = JDBCUtils.getConnection();//�������ݿ⹤���࣬��ȡ����
				stmt = conn.createStatement();
				//4.ʹ��Statementִ��SQL���
				String sql = "select * from teachers";
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					//��ȡ���ݿ�id�ֶ���Ϣ����תΪ����
					String pass = rs.getString("password");
					//��ȡ���ݿ�name�ֶ���Ϣ
					String name = rs.getNString("user");
					//��id/name�ֶ���Ϣ���뼯��
					dataList.put(pass, name);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtils.release(stmt, conn);//�������ݿ⹤���࣬�ͷ���Դ
			}
			//foreachѭ������dataList��������
			for (Entry<String, String> entry : dataList.entrySet()) {
				String name = entry.getValue();
				String pass = entry.getKey();
				//�ж�����/������ȷ�ԣ���������Ӧ�ĵ�����Ϣ
				if(user.equals(name)) {
					if(password.equals(pass)){
						return true;
					}else {
						label.setText("�����������");
						label.setForeground(Color.red);
						return false;
					}
				}else {
					label.setText("���û�����û��ȡȨ�ޣ�");
					label.setForeground(Color.blue);
				}
			}
			return false;
		}
	
}

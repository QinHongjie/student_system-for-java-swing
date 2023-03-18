package sms.jdbc;

import java.util.ArrayList;
/**
 * ���ݿ�����ӿڣ������ر�����
 */
public interface JdbcConnector {
	
	//��ӻ���ѧ����Ϣ��¼����
	void add(String id, String name, String sex, int age, String password);
	
	//���ѧ����������
	void setMark(String id, int mark);
	
	//ɾ��ѧ����Ϣ��¼����
	void delete(String id);
	
	//�޸�ѧ��������Ϣ��¼
	void alter(String id, String name, String sex, int age);
	
	//�޸�ѧ����¼����
	void alterPass(String name, String pass);
	
	//�鿴ѧ����Ϣ��¼�����Լ��Ϸ�ʽ����
	@SuppressWarnings("rawtypes")
	ArrayList select();

	//�ж�ѧ�����������ݿ����Ƿ�����
	Boolean ishavaName(String name);
	
	//�ж�ѧ��ID�����ݿ����Ƿ�����
	Boolean ishavaId(String id);
	
	//�ж�ѧ����������ֱ�����⣬�����ݿ����Ƿ�����
	Boolean alterIshavaName(String id, String name);
	
	//�ж�ѧ��ID�����Լ����⣬�����ݿ����Ƿ�����
//	Boolean alterIshavaId(String id);
}

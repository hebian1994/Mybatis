package com.how2java;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.how2java.pojo.student;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestMybatis {
	    //������¼��
	    static Logger logger = Logger.getLogger(TestMybatis.class);
	    
		public static void main(String[] args) throws IOException {
			/*����ָ���������ļ�
			 * [%-5p] %d{yyyy-MM-dd HH:mm:ss,SSS} [%t] (%F:%L)-%m%n
			 * �����5�����ȵȼ�
			 * �����־ʱ�������ڻ�ʱ��
			 * %t �����������־�¼����߳���
			 * %f �����־��Ϣ�������������
			 * %l �����־�¼��ķ���λ�ã��������־��Ϣ����䴦�������ڵ���ĵڼ���
			 * %m ���������ָ������Ϣ����logger.info("�����Ϣ");�е������Ϣ
			 * %n ���һ���س����з���Windowsƽ̨Ϊ��rn����Unixƽ̨Ϊ��n��
			 * */
			PropertyConfigurator.configure("e:\\project\\Mybatis2\\src\\log4j.properties");
	        
			String resource = "mybatis-config.xml";
	        InputStream inputStream = Resources.getResourceAsStream(resource);
	        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	        SqlSession session = sqlSessionFactory.openSession();
	        
	        logger.trace("������Ϣ");
            logger.debug("������Ϣ");
            logger.info("�����Ϣ");
            logger.warn("������Ϣ");
            logger.error("������Ϣ");
            logger.fatal("������Ϣ");
	         //��ȡ
	        //student c= session.selectOne("getstudent",3136);
	        //System.out.println(c.getId()+" "+c.getsNAME()+" "+c.getQqnumber()+" "+c.getSchool());
	         
	        //����
	        //student a= session.selectOne("getstudent",3136);
	        //a.setsNAME("mimi");
	        //session.update("updatestudent",a);
	        
	        //��ô���м����һ������
	        //student i = new student("986524714","����","2018-08-09","���Ͻ�ͨ��ѧ","how2java","�ֿ���¥����","¬����");
			//session.insert("addstudent",i);
	        
	        
	         //ɾ��
	        
	        student d=new student();
	        for(int j=3154;j<3175;j++){
	        d.setId(j);
	        session.delete("deletestudent",d);
	        }
	        listAll(session);
	        session.commit();
	        session.close();
	        
	    }
	 
	    private static void listAll(SqlSession session) {
	        List<student> cs = session.selectList("liststudent");
	        for (student c : cs) {
	        	System.out.println(c.getId()+" "+c.getsNAME()+" "+c.getQqnumber()+" "+c.getSchool());
	        }
	    }
}

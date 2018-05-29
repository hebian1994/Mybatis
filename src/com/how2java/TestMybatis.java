package com.how2java;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.student;

public class TestMybatis {

		public static void main(String[] args) throws IOException {
	        String resource = "mybatis-config.xml";
	        InputStream inputStream = Resources.getResourceAsStream(resource);
	        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	        SqlSession session = sqlSessionFactory.openSession();
	 
	        
	         //��ȡ
	        //student c= session.selectOne("getstudent",3136);
	        //System.out.println(c.getId()+" "+c.getsNAME()+" "+c.getQqnumber()+" "+c.getSchool());
	         
	        //����
	        //student a= session.selectOne("getstudent",3136);
	        //a.setsNAME("mimi");
	        //session.update("updatestudent",a);
	        
	        //��ô���м����һ������
	       // student i = new student("986524714","����","2018-08-09","���Ͻ�ͨ��ѧ","how2java","�ֿ���¥����","¬����");
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

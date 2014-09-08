package nhn.controller;
import nhn.dao.DataDAO;
import nhn.service.NewArticleCommand;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
public class JdbcTestClient {

	public static void main(String[] args) {
		// configuration metadata를 읽는다.
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// EmpDao 객체를 생성.
		DataDAO empdao = (DataDAO) ac.getBean("DataDAO");
		
		// 실행인자 in 인 경우 insert 수행                         
		
		// 실행인자 all 인 경우 전체 조회수행
		
		List lemp = (List)empdao.searchAll();
		if(lemp != null){
			Iterator empIter= lemp.iterator();
			System.out.println("======= all list ======");
			while(empIter.hasNext()){
				NewArticleCommand emplist = (NewArticleCommand)empIter.next();
				System.out.println("title:"+emplist.getTitle());
				System.out.println("email:"+emplist.getEmail());
				System.out.println("=====================");
			}
		}
		else{
			System.out.println("data is empty");
		}
	}
}
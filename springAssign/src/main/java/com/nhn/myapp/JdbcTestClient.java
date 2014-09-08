package com.nhn.myapp;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nhn.dao.DataDAO;
import com.nhn.service.NewArticleCommand;
public class JdbcTestClient {

	public static void main(String[] args) {
		// configuration metadata??? ?????????.
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// EmpDao ????????? ??????.
		DataDAO empdao = (DataDAO) ac.getBean("DataDAO");
		
		// ???????????? in ??? ?????? insert ??????                         
		
		// ???????????? all ??? ?????? ?????? ????????????
		
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
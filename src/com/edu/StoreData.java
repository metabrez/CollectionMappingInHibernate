package com.edu;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	public static void main(String[] args) {
		
		Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		
		Transaction t=session.beginTransaction();
		
		
		ArrayList<String> list1=new ArrayList<String>();
		list1.add("Java is Programming Language");
		list1.add("Java is Platform independent");
		
		ArrayList<String> list2=new ArrayList<String>();
		list2.add("Serlvet is an interfacr");
		list2.add("Servlet is an API");
		
		Question question1=new Question();
		
		question1.setQname("What is Java ?");
		question1.setAnswer(list1);
		
		Question question2=new Question();
		question2.setQname("What is Servlet ?");
		question2.setAnswer(list2);
		
		session.persist(question1);
	
		session.persist(question2);
		
		t.commit();
		session.close();
		System.out.println("Success");
	}

}

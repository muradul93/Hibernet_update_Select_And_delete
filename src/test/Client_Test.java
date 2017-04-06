package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Client_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			
			Configuration cfg = new Configuration();
			cfg.configure("resources/oracle.cfg.xml");
			
			SessionFactory sf= cfg.buildSessionFactory();
			
			Session s=sf.openSession();
			
			Transaction t=s.beginTransaction();
			
			
			Scanner input= new Scanner(System.in);
			
			System.out.println(" enter your id");
			
			System.out.println();
			String id=input.next();
			
			System.out.println(" enter your name");
			 String name=input.nextLine();
			 
			 System.out.println();
			 
			 System.out.println(" enter your email");
			 String email=input.nextLine();
			 System.out.println();
			
			Student st=new Student();
			st.setId(id);
			st.setName(name);
			st.setEmail(email);
			//String pk=(String)s.save(st);  //for insert data
			//System.out.println(pk);
			
			
			s.merge(st);  //for update only one data at a time
			t.commit();
			s.close();
			sf.close();
			System.out.println("Data insert succefully ");
			 
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println( "  Error  "+  e.getMessage());
			
		}
		

	}

	

}

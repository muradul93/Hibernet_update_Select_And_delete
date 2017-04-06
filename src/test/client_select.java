package test;



import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class client_select {

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
			
			
			
			Object o=s.get(Student.class, id);    //select from table all data at a time 
			
			//Object o=s.load(Student.class, id);  //select from table one by one
			
			Student st=(Student)o;
			
		
			System.out.println("  ID : "+st.getId());
			
			 
			 System.out.println("  Name : "+st.getName());
			 
			 System.out.println("  Email : "+st.getEmail());
			 
			 System.out.println();
			
		
			
			
			s.close();
			sf.close();
			System.out.println("Data fetch succefully ");
			 
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println( "  Error  "+  e.getMessage());
			
		}
		

	}

	

}

package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class client_delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			
			Configuration cfg = new Configuration();
			cfg.configure("resources/oracle.cfg.xml");
			
			SessionFactory sf= cfg.buildSessionFactory();
			
			Session s=sf.openSession();
			
			Transaction t=s.beginTransaction();
			
			
			Scanner input= new Scanner(System.in);
			
			System.out.println(" enter your id you want to delete");
			
			System.out.println();
			String id=input.next();
			
			
			Student st=new Student();
			st.setId(id);
			
			//String pk=(String)s.save(st);  //for insert data
			//System.out.println(pk);
			
			
			s.delete(st);  //for delete  data at a time
			t.commit();
			s.close();
			sf.close();
			System.out.println("Data delete succefully ");
			 
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println( "  Error  "+  e.getMessage());
			
		}
		

	}

	

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Apply;
import utility.ConnectionManager;
import utility.HibernateConnectionManager;

public class ApplyDao implements ApplyDaoInterface {
	
	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();

	// final String sql="insert into application(firstname,lastname,course,email,phnumber,age,gender) values(?,?,?,?,?,?,?)";
	public void insertApplication(Apply apply) throws ClassNotFoundException {
		
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if(session.save(apply)!=null) {
			transaction.commit();
			session.close();
		}
		else {
			System.out.println("Application insertion ERROR");
		}
		
		/*
		 * try { Connection con=ConnectionManager.getConnection(); PreparedStatement
		 * ps=con.prepareStatement(sql); ps.setString(1, apply.getFirstname());
		 * ps.setString(2, apply.getLastname()); ps.setString(3, apply.getCourse());
		 * ps.setString(4, apply.getEmail()); ps.setLong(5, apply.getPhnumber());
		 * ps.setInt(6, apply.getAge()); ps.setString(7, apply.getGender());
		 * System.out.println(ps); ps.executeUpdate(); } catch(SQLException e) {
		 * e.printStackTrace(); }
		 */
		
	}
	public List<Apply> displayAll() throws ClassNotFoundException {
		
		 Session session = this.sessionFactory.openSession();
		 Query query = session.createQuery("from Apply");
		 List<Apply> listApply = query.list();
		 System.out.println(listApply);
		return listApply;
	
		
	}
/*		List<Apply> applylist=new ArrayList<Apply>();
		Apply apply=null;
		final String sql="select * from application";
		 try {
				Connection con=ConnectionManager.getConnection();
				 PreparedStatement ps=con.prepareStatement(sql);
				  ResultSet rs=ps.executeQuery();
				  while(rs.next()) {
					  String firstname=rs.getString(1);
					  String lastname=rs.getString(2);
					  String course=rs.getString(3);
					  String email=rs.getString(4);	
					  long phnumber=rs.getLong(5);	
					  int age=rs.getInt(6);	
					  String gender=rs.getString(7);	
					  
					  apply=new Apply();
					  apply.setFirstname(firstname);
					  apply.setLastname(lastname);
					  apply.setCourse(course);
					  apply.setEmail(email);
					  apply.setPhnumber(phnumber);
					  apply.setAge(age);
					  apply.setGender(gender);
					  applylist.add(apply);
					  }			   
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		return applylist;
		
	}*/
	@Override
	public void deleteApply(String firstname) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Apply apply=(Apply) session.get(Apply.class,firstname);
		session.delete(apply);
		transaction.commit();
		session.close();
		
	}

}

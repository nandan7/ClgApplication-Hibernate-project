package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.User;
import utility.ConnectionManager;
import utility.HibernateConnectionManager;

public class UserDao {

	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();

	public int signup(User user) throws ClassNotFoundException {
		
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if(session.save(user)!=null) {
			transaction.commit();
			session.close();
			return 1;
		}
		else {
			return 0;
		}
		
		/*
		 * String sql=" insert into users2(email,password)values(?,?)"; int result=0;
		 * try { Connection con=ConnectionManager.getConnection(); PreparedStatement
		 * ps=con.prepareStatement(sql); ps.setString(1,user.getEmail());
		 * ps.setString(2,user.getPassword()); System.out.println(ps);
		 * result=ps.executeUpdate(); } catch(SQLException e) { e.printStackTrace(); }
		 * return result;
		 */
	}

	public boolean loginUser(User user) throws ClassNotFoundException {
		
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User where email='"+user.getEmail()+"'"+"and password='"+user.getPassword()+"'", User.class);
			user = (User)query.uniqueResult();
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return true;
		
		/*
		 * boolean status=false; try { Connection con=ConnectionManager.getConnection();
		 * PreparedStatement
		 * ps=con.prepareStatement("select * from users2 where email=? and password=?");
		 * ps.setString(1,user.getEmail()); ps.setString(2,user.getPassword());
		 * ResultSet rs=ps.executeQuery(); status=rs.next(); } catch(SQLException e) {
		 * e.printStackTrace(); } return status;
		 */
	}

}

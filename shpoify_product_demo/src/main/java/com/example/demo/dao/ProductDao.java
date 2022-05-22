package com.example.demo.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
//
//import org.hibernate.HibernateException;
//import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.exception.exception;
import com.example.demo.model.Product;
import com.example.demo.util.HibUtil;




@Component 
public class ProductDao extends DAO {

	private SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(ProductDao.class);

	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

		public void save(Product product)
				throws exception {

			try {
				begin();
				getSession().update(product);
				commit();
			} catch (HibernateException e) {
				rollback();
				throw new exception("Could not save product", e);
			}
			
		}
		public List<Product> list() throws exception  {

			try {
				begin();
				Criteria criteria = getSession().createCriteria(Product.class);

				List<Product> list = criteria.list();

				commit();
				return list;
			} catch (HibernateException e) {
				rollback();
				throw new exception("Could not list products", e);
			}
		}
		public List<Product> getAllByCategoryId(int categoryId){
	        Query<Product> query = getSession().createQuery("FROM Product where category_id = :ID");// query for selecting products by all products
	        query.setParameter("ID", categoryId);//setting the category id
	        return query.list();//executing the query
	    }
		
	    public void addcreate(Product Product) {

	        Session session = getSession();

	        try {

	            begin();

	            session.save(Product);

	            commit();

	        } catch (Exception e) {

	            System.out.println("Could not add Product!PLease try again..!");

	            e.printStackTrace();}

//	        } finally {
//
//	            session.close();
//
//	        }

	    }
	   
		public void deleteById(int product_uid){
	        org.hibernate.Transaction txn = getSession().beginTransaction();//begin transaction
	        Query query = getSession().createQuery("delete Product where product_uid=:product_uid");
	        query.setParameter("product_uid", product_uid);//setting the id

	        int result = query.executeUpdate();
	        if (result > 0) {
	            System.out.println(product_uid+ " product was removed");
	        }
	        System.out.println(product_uid+ " did u come here for removing");
	        txn.commit();//commit transaction
	    }

	    public Product getProductById(int product_id) {
	    	Product pr = null;
			try {
				begin();
				pr = (Product) getSession().get(Product.class, product_id);
				commit();
			} catch (HibernateException e) {
				rollback();
				e.printStackTrace();
			}
			return pr;

		}
	    

	    
	    public List<String> getProducts() {
	    	Session session = getSession();
	    	Query query = getSession().createQuery("from Product");
	    	List users = (List<Product>)query.list();
	    	List<String> lst = new ArrayList<>();
	    	for (Object o : users) {
	    		Product u = (Product) o;
	    		lst.add(u.getProduct_id() + " " + u.getBookName()+ " " + u.getPrice());
	    	}
	    	return users;
	    }
}

	 
	    
		
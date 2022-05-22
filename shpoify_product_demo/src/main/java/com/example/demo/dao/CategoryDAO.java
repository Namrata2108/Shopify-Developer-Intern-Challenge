package com.example.demo.dao;



import com.example.demo.exception.exception;
import com.example.demo.model.Category;
import com.example.demo.model.Product;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDAO extends DAO {
    // Query for Saving Category
    public void save(Category category) {
        try {
            begin();//begin the transaction
            getSession().save(category);//update category
            commit();//commit the transaction
        } catch (HibernateException e) {
        	System.out.println("Could not add Product!PLease try again..!");
            rollback();//rollback
            
        }
    }

    // Query to find category id
    public Category findById(int id) {
//        return getSession().get(Category.class, id);
        Category pr = null;
		try {
			begin();
			pr = (Category) getSession().get(Category.class, id);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return pr;
    }
    public Category getCategoryById(int id){
        return this.findById(id);
    }

    // Query to findAll category id
    public List<Category> findAll() throws exception{
//        Query<Category> query = getSession().createQuery("FROM Category");// create query string
//        List<Category> list = query.list(); // add categery rows to lsit
//        return list;
        
        try {
			begin();
			Criteria criteria = getSession().createCriteria(Category.class);

			List<Category> list = criteria.list();

			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new exception("Could not list categories", e);
		}
    }

    // Query to delete category by id
    public void deleteById(int id){
        Transaction txn = getSession().beginTransaction();//begin the transaction
        Query query = getSession().createQuery("delete Category where id = :ID");//Query String
        query.setParameter("ID", id);//setting the id

        int result = query.executeUpdate();//getting result query
        if (result > 0) {// if result set has more than 1 row
            System.out.println(id + " category was removed");
        }
        txn.commit();//commiting the transaction
    }

    // Query to update category
    public void update(Category category) throws exception {
        try {
            begin();//begin the transaction
            getSession().update(category);//update category
            commit();//commit the transaction
        } catch (HibernateException e) {
            rollback();//rollback
            throw new exception("Could not save category", e);
        }
    }
}

package com.mkyong.hibernate.manager;

import java.util.List;

import org.hibernate.Session;


import com.mkyong.customer.model.Customer;
import com.mkyong.hibernate.util.HibernateUtil;

public class CustomerManager {
	private static CustomerManager cm;
	public static CustomerManager getCustomerManager() {
		if(cm == null) {
			cm = new CustomerManager();
		}
		return cm;
	}
	
	public void addCustomer(Customer customer){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
	}

	//return all the customers in list
	public List<Customer> listCustomer(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List result = session.createQuery("from Customer").list();
        session.getTransaction().commit();
        return result;
	}
	
}

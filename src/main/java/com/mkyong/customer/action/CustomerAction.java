package com.mkyong.customer.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mkyong.customer.model.Customer;
import com.mkyong.hibernate.manager.CustomerManager;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction implements ModelDriven{
	Customer customer = new Customer();
	List<Customer> customerList = new ArrayList<Customer>();
	CustomerManager customerManager = CustomerManager.getCustomerManager();

	
	public String execute() {
		return "success";
	}
	
	public CustomerManager getCustomerManager() {
		return customerManager;
	}

	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}

	public Object getModel() {
		return customer;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	//save customer
	public String addCustomer() throws Exception{

		//save it
		customer.setCreatedDate(new Date());
		customerManager.addCustomer(customer);

		//reload the customer list
		customerList = null;
		customerList = customerManager.listCustomer();

		return "success";

	}

	//list all customers
	public String listCustomer() throws Exception{

		customerList = customerManager.listCustomer();

		return "success";

	}

}
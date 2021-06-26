package com.ec.onlineplantnursery.customer.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.customer.entity.Customer;
import com.ec.onlineplantnursery.customer.repository.ICustomerRepository;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;

@Service
public class ICustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerRepository custRepo;
	
	public ICustomerServiceImpl() {
		super();
	}

	public ICustomerServiceImpl(ICustomerRepository custRepo) {
		super();
		this.custRepo = custRepo;
	}
	
	/*Method Name:addCustomer
	 *Parameters:Customer
	 *ReturnType:Customer
	 *Author Name:Srividya
	 *Created Date: 21/05/2021 */
	
	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
		custRepo.save(customer);
		return customer;
	}
	
	
	/*Method Name:updateCustomer
	 *Parameters:Customer
	 *ReturnType:Customer
	 *Author Name:Srividya
	 *Created Date: 21/05/2021 */
	
	@Override
	@Transactional
	public Customer updateCustomer(Customer tenant) throws ResourceNotFoundException{
		
		Optional<Customer> updatedCustomer = custRepo.findById(tenant.getId());

		if(updatedCustomer.isPresent()) {
			
			return custRepo.save(tenant);
		}
		else {
			throw new ResourceNotFoundException();
		}
	}
    
	/*Method Name:deleteCustomer
	 *Parameters:Customer
	 *ReturnType:Customer
	 *Author Name:Srividya
	 *Created Date: 21/05/2021 */
	
	@Transactional
	@Override
	public Customer deleteCustomer(Customer customer) throws ResourceNotFoundException{
		
		
		Optional<Customer> deletedCustomer = custRepo.findById(customer.getId());
		if(deletedCustomer.isPresent()) {
			custRepo.delete(customer);
		}
		else {
			
			throw new ResourceNotFoundException();
		}
		return deletedCustomer.get();
		
	}
	
	/*Method Name:viewCustomer
	 *Parameters:customerId
	 *ReturnType:Customer
	 *Author Name:Srividya
	 *Created Date: 21/05/2021 */
	
	@Override
	public Customer viewCustomer(int customerId) throws ResourceNotFoundException {
		Optional<Customer> s = custRepo.findById(customerId);
	      if(s.isPresent()) {
	    	  return s.get();
	      }
	      else {
			
			throw new ResourceNotFoundException();
		}
	}
    
	/*Method Name:viewAllCustomers
	 *Parameters: none
	 *ReturnType:List<Customer>
	 *Author Name:Srividya
	 *Created Date: 21/05/2021 */
	@Override
	public List<Customer> viewAllCustomers() {
		return custRepo.findAll();
	}

	/*Method Name:validateCustomer
	 *Parameters:username,password
	 *ReturnType:boolean
	 *Author Name:Srividya
	 *Created Date: 21/05/2021 */
	
	@Override
	public boolean validateCustomer(String email, String password) {
		List<Customer> customers = custRepo.findByUserName(email);
		for(Customer cust : customers) {
			if(cust.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
}
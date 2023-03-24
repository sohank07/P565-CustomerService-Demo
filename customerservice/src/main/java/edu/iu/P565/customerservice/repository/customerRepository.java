package edu.iu.P565.customerservice.repository;

import edu.iu.P565.customerservice.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class customerRepository {
    private List<Customer> customerList = new ArrayList<>();

    public List<Customer> findAll(){
        return customerList;
    }

    public int createCustomer(Customer customer){
        int id = customerList.size() + 1;
        customer.setId(id);
        customerList.add(customer);
        return id;
    }

    public void updateCustomer(Customer customer, int id){
        Customer c = getCustomerById(id);
        if (c != null){
            c.setName(customer.getName());
            c.setEmail(customer.getEmail());
        }else {
            throw new IllegalStateException("Customer with this ID was not found.");
        }

    }

    public void deleteCustomer(int id){
        Customer c = getCustomerById(id);
        if (c != null){
            customerList.remove(c);
        }else {
            throw new IllegalStateException("Customer with this ID was not found.");
        }
    }

    private Customer getCustomerById(int id) {
        return customerList.stream().filter(x -> x.getId() == id).findAny().orElse( null);
    }
}

package edu.iu.P565.customerservice.controller;

import edu.iu.P565.customerservice.model.Customer;
import edu.iu.P565.customerservice.repository.customerRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/customers")
public class customerController {

    private customerRepository repository;

    public customerController(customerRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Customer> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public int create(@Valid @RequestBody Customer customer){
        return repository.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Customer customer, @PathVariable int id){
        repository.updateCustomer(customer, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        repository.deleteCustomer(id);
    }
}

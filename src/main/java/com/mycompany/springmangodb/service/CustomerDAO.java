/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmangodb.service;

import com.mycompany.springmangodb.model.Customer;
import java.util.List;


public interface CustomerDAO {

    public void addCustomer(Customer customer);

    public List<Customer> listCustomer();

    public void deleteCustomer(Customer customer);

    public void updateCustomer(Customer customer);
}

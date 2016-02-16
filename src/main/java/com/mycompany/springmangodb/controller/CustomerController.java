/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmangodb.controller;

import com.mycompany.springmangodb.model.Customer;
import com.mycompany.springmangodb.service.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class CustomerController {

    @Autowired
    private CustomerDAO customerDao;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String getCustomerList(ModelMap model) {
        model.addAttribute("customerList", customerDao.listCustomer());
        return "customr";
    }

    @RequestMapping(value = "/customer/save", method = RequestMethod.POST)
    public View createCustomer(@RequestParam(value = "name", required = true) String name,@RequestParam(value = "id", required = false) String id, ModelMap model) {
        Customer customer = new Customer();
        if(StringUtils.hasText(id)){
            customer.setId(id);
        }
        if(StringUtils.hasText(name)){
            customer.setName(name);
        }
        if (StringUtils.hasText(customer.getId())) {
            customerDao.updateCustomer(customer);
        } else {
            customerDao.addCustomer(customer);
        }
        return new RedirectView("/SpringMangoDB/customer");
    }

    @RequestMapping(value = "/customer/delete", method = RequestMethod.GET)
    public View deleteCustomer(@ModelAttribute Customer customer, ModelMap model) {
        customerDao.deleteCustomer(customer);
        return new RedirectView("/SpringMangoDB/customer");
    }
}

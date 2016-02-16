/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmangodb.controller;

import com.mycompany.springmangodb.model.Order;
import com.mycompany.springmangodb.model.Product;
import com.mycompany.springmangodb.service.OrderDAO;
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

/**
 *
 * @author Patgaonkar
 */
@Controller
public class OrderController {

    @Autowired
    private OrderDAO orderDao;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String getOrderList(ModelMap model) {
        model.addAttribute("orderList", orderDao.listOrders());
        return "ordr";
    }

    @RequestMapping(value = "/order/save", method = RequestMethod.POST)
    public View createOrder(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "size", required = false) String size,@RequestParam(value = "id", required = false) String id, ModelMap model) {
        Order order = new Order();
        if(StringUtils.hasText(id)){
            order.setId(id);
        }
        if(StringUtils.hasText(name)){
            Product product = new Product();
            product.setName(name);
            order.setProduct(product);
        }
        if (StringUtils.hasText(order.getId())) {
            orderDao.updateOrder(order);
        } else {
            orderDao.addOrder(order);
        }
        return new RedirectView("/SpringMangoDB/order");
    }

    @RequestMapping(value = "/order/delete", method = RequestMethod.GET)
    public View deleteOrder(@ModelAttribute Order order, ModelMap model) {
        orderDao.deleteOrder(order);
        return new RedirectView("/SpringMangoDB/order");
    }

}

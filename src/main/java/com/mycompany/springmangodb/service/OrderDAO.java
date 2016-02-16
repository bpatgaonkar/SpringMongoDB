/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmangodb.service;


import com.mycompany.springmangodb.model.Order;
import java.util.List;

/**
 *
 * @author Patgaonkar
 */
public interface OrderDAO {
    public void addOrder(Order order);

    public List<Order> listOrders();

    public void deleteOrder(Order order);

    public void updateOrder(Order order);
}

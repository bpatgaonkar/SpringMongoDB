/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmangodb.service;

import com.mycompany.springmangodb.model.Order;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Patgaonkar
 */
@Repository
public class OrderDAOImpl implements OrderDAO{
 @Autowired
    private MongoTemplate mongoTemplate;
    public static final String COLLECTION_NAME = "order";
    @Override
    public void addOrder(Order order) {
        /*if (!mongoTemplate.collectionExists(Order.class)) {
            mongoTemplate.createCollection(Order.class);
        }*/
        order.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(order, COLLECTION_NAME);
    }

    @Override
    public List<Order> listOrders() {
        return mongoTemplate.findAll(Order.class, COLLECTION_NAME);
    }

    @Override
    public void deleteOrder(Order order) {
        mongoTemplate.remove(order,COLLECTION_NAME);
    }

    @Override
    public void updateOrder(Order order) {
        mongoTemplate.insert(order,COLLECTION_NAME);
    }
    
}

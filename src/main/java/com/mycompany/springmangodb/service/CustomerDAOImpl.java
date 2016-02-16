/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmangodb.service;

import com.mycompany.springmangodb.model.Customer;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private MongoTemplate mongoTemplate;
    public static final String COLLECTION_NAME = "customer";

    public void addCustomer(Customer customer) {
        /*if (!mongoTemplate.collectionExists(Customer.class)) {
            mongoTemplate.createCollection(Customer.class);
        }*/
        //Query query = new Query(Criteria.where("firstName").is(customer.getName()));
        //Update update = new Update().inc("name",1);
        //.update(COLLECTION_NAME, customer)
        //Customer p = mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true).upsert(true), Customer.class);        
        //customer.setId(UUID.randomUUID().toString());
        //mongoTemplate.insert(customer, COLLECTION_NAME);
        long list=mongoTemplate.count(new Query(Criteria.where("name").in(customer.getName())), Customer.class);
        if(list==0){
            mongoTemplate.insert(customer, COLLECTION_NAME);
        }
    }

    public List<Customer> listCustomer() {
        return mongoTemplate.findAll(Customer.class, COLLECTION_NAME);
    }

    public void deleteCustomer(Customer customer) {
        mongoTemplate.remove(customer, COLLECTION_NAME);
    }

    public void updateCustomer(Customer customer) {
        mongoTemplate.insert(customer, COLLECTION_NAME);
    }
}

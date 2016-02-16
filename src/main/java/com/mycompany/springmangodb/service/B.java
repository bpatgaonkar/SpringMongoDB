/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmangodb.service;

/**
 *
 * @author Patgaonkar
 */
public class B extends A{
    public void method(){
        System.out.println("method ===> b");
    }
    public static void main(String args[]){
        A a = new A();
        a.method();
        A a1 = new B();
        a1.method();
    }
}

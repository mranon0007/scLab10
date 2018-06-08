/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labppl.controllers;

import com.labppl.entities.Car;
import com.labppl.hibernate.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ehsan
 */
public class CarAdder {
    public static void addCar(String name, String type, Integer quantity, Integer price){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Car car = new Car();
        car.setName(name);
        car.setType(type);
        car.setQuantity(quantity);
        car.setPrice(price);
        session.beginTransaction();
        session.save(car);
        session.getTransaction().commit();
        session.close();
    }
}

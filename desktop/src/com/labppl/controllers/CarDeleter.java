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
public class CarDeleter {
    public static void deleteCar(Integer Id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Car car = (Car)session.get(Car.class, Id);
        session.beginTransaction();
        session.delete(car);
        session.getTransaction().commit();
        session.close();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labppl.controllers;

import com.labppl.entities.Record;
import com.labppl.entities.Car;
import com.labppl.hibernate.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ehsan
 */
public class ReturnConfirmer {
    public static void confirmReturn(Integer Id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Record record = (Record)session.get(Record.class, Id);
        record.setStatus("Returned");
        Car car = (Car)session.get(Car.class, record.getCarId().getId());
        car.setQuantity(car.getQuantity() + 1);
        session.beginTransaction();
        session.update(car);
        session.update(record);
        session.getTransaction().commit();
        session.close();
    }
}

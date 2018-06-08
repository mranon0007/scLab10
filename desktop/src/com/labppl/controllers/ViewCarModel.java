/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labppl.controllers;

import com.labppl.entities.Car;
import com.labppl.hibernate.HibernateUtil;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ehsan
 */
public class ViewCarModel extends AbstractTableModel {

    private List Data;
    
    public ViewCarModel() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Car C";
        Query query = session.createQuery(hql);
        Data = query.list();
        session.close();
    }
    
    
    
    @Override
    public int getRowCount() {
        return Data.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Car car = (Car)Data.get(rowIndex);
        switch(columnIndex){
            case 0:
                return car.getId();
            case 1:
                return car.getName();
            case 2:
                return car.getType();
            case 3:
                return car.getQuantity();
            case 4:
                return car.getPrice();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
       switch(column){
           case 0:
               return "ID";
           case 1:
               return "Name";
           case 2:
               return "Type";
           case 3:
               return "Quantity";
           case 4:
               return "Price";
           default:
               return "";
       }
    }
    
    

}

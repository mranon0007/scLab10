/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labppl.controllers;

import com.labppl.entities.Record;
import com.labppl.hibernate.HibernateUtil;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ehsan
 */
public class ViewStatusModel extends AbstractTableModel {

    private List Data;
    
    public ViewStatusModel() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Record R";
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
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Record record = (Record)Data.get(rowIndex);
        switch(columnIndex){
            case 0:
                return record.getId();
            case 1:
                return record.getUsername().getUsername();
            case 2:
                return record.getCarId().getName();
            case 3:
                return record.getType();
            case 4:
                return record.getRentDate().toString();
            case 5:
                return record.getStatus();
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
               return "User";
           case 2:
               return "Car";
           case 3:
               return "Type";
           case 4:
               return "Date";
           case 5:
               return "Status";
           default:
               return "";
       }
    }
    
    

}

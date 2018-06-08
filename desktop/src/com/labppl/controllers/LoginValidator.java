/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labppl.controllers;

import com.labppl.entities.User;
import com.labppl.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author ehsan
 */
public class LoginValidator {
    public static Boolean validate(String usr, String pwd){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM User U WHERE U.username=:username";
        Query query = session.createQuery(hql);
        query.setParameter("username", usr);
        List result = query.list();
        if(!result.isEmpty() && 
                ((User)result.get(0)).getPassword().equals(pwd)
                && ((User)result.get(0)).getType().equals("Admin")){
            session.close();
            return true;
        }
        session.close();
        return false;
    }
}

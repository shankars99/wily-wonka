/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlineshop;

import javax.ejb.Stateful;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author shankar
 */
@Stateful
public class Bill extends HttpServlet implements BillRemote  {

    static Vector<Item> cart = new Vector<Item>();

    @Override
    public Vector<Item> addItem(String name, String price) {

        for(Item item : cart){
            if(item.getName().equals(name))
            {
                item.setQuant( item.getQuant()+1 );
                return cart;
            }
        }

        cart.add(new Item(name,Integer.parseInt(price),1));                
        return cart;
    }
    
}

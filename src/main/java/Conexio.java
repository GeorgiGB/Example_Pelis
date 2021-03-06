/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joange
 */
public class Conexio {
    
    private String host,port,user,pass,ddbb;
    
    private java.sql.Connection laConexio;
    
    public Conexio(){
        host="localhost";
        port="49153";
        user="root";
        pass="2502";
        ddbb="cine";
        
       laConexio=null;
    }
    
    private void connectar(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url="jdbc:mysql://"+host+":"+port+"/"+ddbb;
            
            Properties p= new Properties();
            
            p.put("user", user);
            p.put("password", pass);
            
            laConexio=DriverManager.getConnection(url,p);
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public java.sql.Connection getConexio(){
        
        if (laConexio==null)
            this.connectar();
        
        return laConexio;
    }
    
    public void tancarConexio(){
        try {
            laConexio.close();
            laConexio=null;
        } catch (SQLException ex) {
            Logger.getLogger(Conexio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}


package com.bilisimegitim.personelweb.vt;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VTBaglanti {
    
    public Connection baglantiAc(){
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pbs", "postgres", "postgres");
            return conn;
        } catch (ClassNotFoundException ex) {
            System.err.println("Postgresql JDBC Driver Bulunamadı!");
            ex.printStackTrace();
            return null;
        } catch (SQLException ex) {
            System.err.println("SQL Hatası Oluştu! "+ex.getMessage());
            ex.printStackTrace();
            return null;
        }

    }
    
    public void baglantiKapat(Connection p_conn){
        try {
            p_conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
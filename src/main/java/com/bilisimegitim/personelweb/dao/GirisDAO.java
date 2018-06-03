
package com.bilisimegitim.personelweb.dao;

import com.bilisimegitim.personelweb.vt.VTBaglanti;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GirisDAO {
    
    public static boolean giriseYetkiliMi(String p_kullanici,String p_sifre){
        VTBaglanti vt = null;
        Connection conn = null;
        try {
            
            String vtSifre=null;
            
            vt = new VTBaglanti();
            conn = vt.baglantiAc();
            
            String sorgu = "select sifre from giris where kullanici=?";
            PreparedStatement ps = conn.prepareStatement(sorgu);
            
            ps.setString(1,p_kullanici);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                vtSifre = rs.getString("sifre");
            }
            rs.close();
            ps.close();
            
            if(vtSifre!=null && vtSifre.equals(p_sifre)){
                return true;
            }
            else{
                return false;
            }
            
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }finally{
            vt.baglantiKapat(conn);
            
        }
        
        
        
    }
    
}

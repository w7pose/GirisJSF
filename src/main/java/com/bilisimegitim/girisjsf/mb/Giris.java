
package com.bilisimegitim.girisjsf.mb;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "giris")
@RequestScoped
public class Giris {

    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
    private String kullanici;
    private String sifre;

    public Giris() {
    }
    
    public String girisKontrol(){
        return "menu.xhtml";
    }
}

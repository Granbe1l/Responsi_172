/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import DAOdataperpus.dataperpusDAO;
import DAOImplement.dataperpusImplement;
import Model.*;
import View.MainView;
        

public class dataperpuscontroller {
    MainView frame;
    dataperpusImplement impldataperpus;
    List<dataperpus>dp;
    
    public dataperpuscontroller(MainView frame){
        this.frame = frame;
        impldataperpus = new dataperpusDAO();
        dp = impldataperpus.getAll();  
    }
    public void isistabel(){
        dp = impldataperpus.getAll();
        modeltabeldataperpus mp = modeltabeldataperpus(dp);
        frame.getTabelDataperpus().setModel(mp);
        
    }
    public void insert(){
        dataperpus dp = new dataperpus();
        dp.setJudul(frame.getJTxtjudul().getText);
        dp.set
        
    }
}

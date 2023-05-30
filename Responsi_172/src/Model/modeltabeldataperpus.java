/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class modeltabeldataperpus extends AbstractTableModel{
    List<dataperpus> dp;
    public modeltabeldataperpus(List<dataperpus> dp){
        this.dp = dp;
    }

    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "JUDUL";
            case 2:
                return "GENRE";
            case 3:
                return "PENULIS";
            case 4:
                return "PENERBIT";
            case 5:
                return "LOKASI";
            case 6:
                return "STOCK";
            default:
                return null;
                
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
                switch(column){
            case 0:
                return dp.get(row).getId();
            case 1:
                return dp.get(row).getJudul();
            case 2:
                return dp.get(row).getGenre();
            case 3:
                return dp.get(row).getPenulis();
            case 4:
                return dp.get(row).getPenerbit();
            case 5:
                return dp.get(row).getLokasi();
            case 6:
                return dp.get(row).getStock();
            default:
                return null;
                
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdataperpus;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import Model.*;
import  DAOImplement.dataperpusImplement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dataperpusDAO implements dataperpusImplement{
    Connection connection;
    final String select = "select * from dataperpus";
    final String insert = "INSERT INTO dataperpus(judul,genre,penulis,penerbit,lokasi,stock) VALUES (?,?,?,?,?,?)";
    final String update = "update dataperpus set judul=?, genre=?, penulis=?, penerbit=?, lokasi=?, stock=? where id=?";
    final String delete = "delete from dataperpus where id=?";
    
    public dataperpusDAO(){
        connection = connector.connection();
    }
    
    @Override
    public void insert(dataperpus p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,p.getJudul());
            statement.setString(2,p.getGenre());
            statement.setString(3,p.getPenulis());
            statement.setString(4,p.getPenerbit());
            statement.setString(5,p.getLokasi());
            statement.setString(6,p.getStock());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setId(rs.getInt(1));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            
        }
    }

    @Override
    public void update(dataperpus p) {
         PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1,p.getJudul());
            statement.setString(2,p.getGenre());
            statement.setString(3,p.getPenulis());
            statement.setString(4,p.getPenerbit());
            statement.setString(5,p.getLokasi());
            statement.setString(6,p.getStock());
            statement.setInt(7,p.getId());
            statement.executeUpdate();
        }catch(SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            
        }
    }

    @Override
    public void delete(int id) {
      PreparedStatement statement = null;
      try{
           statement = connection.prepareStatement(delete);
           statement.setInt(1,id);
           statement.executeUpdate();
               
      }catch(SQLException ex) {
          ex.printStackTrace();
      }finally{
            try{
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            
        }
    }

    @Override
    public List<dataperpus> getAll() {
        List<dataperpus> dp =null;
        try{
            dp = new ArrayList<dataperpus>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                dataperpus perpus = new dataperpus();
                perpus.setId(rs.getInt("id"));
                perpus.setJudul(rs.getString("judul"));
                perpus.setGenre(rs.getString("genre"));
                perpus.setPenulis(rs.getString("penulis"));
                perpus.setPenerbit(rs.getString("penerbit"));
                perpus.setLokasi(rs.getString("lokasi"));
                perpus.setStock(rs.getString("stock"));
                dp.add(perpus);
            }
            
        }catch (SQLException ex){
            Logger.getLogger(dataperpusDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return dp;
    }
    
}

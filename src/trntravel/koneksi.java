/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trntravel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class koneksi {
    
    String SQL;
Connection connection;
Statement statement;
    private static Connection koneksi;
    public static Statement stm;  
    public static Connection getKoneksi(){
      if (koneksi==null){
          
          try {
              String url = "jdbc:mysql://localhost:3306/db_trn";
              String user = "admin";
              String password = "admin";
              DriverManager.registerDriver(new com.mysql.jdbc.Driver());
              koneksi = DriverManager.getConnection(url, user, password);
              JOptionPane.showMessageDialog(null,"Berhasil Koneksi");
          } 
          catch (SQLException t){
              JOptionPane.showMessageDialog(null,"Error Membuat Koneksi");
        }
      }
      return koneksi;
  }
    
}

package com.p2.jdbc.latihan;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.*;

public class Update{
	public static void main(String[] args){
		try{
			//host, port, nama database, user, pass
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2", "root", "");
			
			Statement stm = conn.createStatement();
			String query = "Update produk set nama = 'luki', harga='4500' where nama = 'lala'";
			int hasil = stm.executeUpdate(query);
			
			if(hasil == 1){
				JOptionPane.showMessageDialog(null,"berhasil update");
			}
			else{
				JOptionPane.showMessageDialog(null,"gagal update");
			}	
		}
		catch(SQLException se){
			Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, se);
		}
	}
}
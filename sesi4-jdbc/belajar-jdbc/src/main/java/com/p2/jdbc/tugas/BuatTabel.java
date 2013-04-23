package com.p2.jdbc.tugas;

import java.sql.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;

public class BuatTabel{
	public static void main(String[] args){
		try{
			//host, port, nama database, user, pass
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2", "root", "");
			
			String query = "create table terserah"
			+ "(Nama text,"
			+ "Alamat varchar(255),"
			+ "Tglahir date,"
			+ "IPK decimal(5,2),"
			+ "Telepon int(12))";
			
			Statement st = conn.createStatement();
			boolean hasil = st.execute(query);
			
			if(hasil){
				JOptionPane.showMessageDialog(null,"Tabel gagal dibuat");
			}
			else{
				JOptionPane.showMessageDialog(null,"Tabel berhasil dibuat");
			}	
		}
		catch(SQLException se){
			Logger.getLogger(BuatTabel.class.getName()).log(Level.SEVERE, null, se);
		}
}
	}
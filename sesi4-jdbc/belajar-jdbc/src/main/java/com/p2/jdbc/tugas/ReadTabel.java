package com.p2.jdbc.tugas;

import java.sql.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;

public class ReadTabel{
	public static void main(String[] args){
		try{
			//host, port, nama database, user, pass
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2", "root", "");
			String query = "select * from terserah where Nama = 'Luki'";
			Statement st = conn.createStatement();
			
			//hasil query ditaruh di resultset
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				String nama = rs.getString("Nama");
				String alamat = rs.getString("Alamat");
				Date tanggal = rs.getDate("Tglahir");
				BigDecimal ipk = rs.getBigDecimal("IPK");
				int telepon = rs.getInt("Telepon");
				
				System.out.println(" ");
				System.out.println("Berikut hasil pencarian Anda :");
				System.out.println("Nama : " +nama);
				System.out.println("Alamat : " +alamat);
				System.out.println("TTL : " +tanggal);
				System.out.println("IPK : " +ipk);
				System.out.println("Telepon : " +telepon);
			}
		}
		catch(SQLException se){
			Logger.getLogger(ReadTabel.class.getName()).log(Level.SEVERE, null, se);
		}
}
	}
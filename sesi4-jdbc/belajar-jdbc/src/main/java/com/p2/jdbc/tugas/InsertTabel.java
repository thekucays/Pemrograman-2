package com.p2.jdbc.tugas;

import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;

public class InsertTabel{
	public static void main(String[] args){
		try{
			//host, port, nama database, user, pass
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2", "root", "");
			
			BigDecimal ipk = new BigDecimal(3.20);
			
			String query = "insert into terserah values (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "Luki");
			ps.setString(2, "Depok");
			//ps.setString(3, "1993-03-23");
			ps.setDate(3, getCurrentDate());
			ps.setBigDecimal(4, ipk);
			ps.setInt(5, 123);
			
			int hasil = ps.executeUpdate();
			
			if(hasil == 1){
				JOptionPane.showMessageDialog(null,"Data berhasil dimasukkan");
			}
			else{
				JOptionPane.showMessageDialog(null,"Data gagal dimasukkan");
			}	
		}
		catch(SQLException se){
			Logger.getLogger(InsertTabel.class.getName()).log(Level.SEVERE, null, se);
		}
	}
	
	//buat nge-return tanggal sekarang
	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}
	
}
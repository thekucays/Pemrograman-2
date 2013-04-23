package com.p2.jdbc.tugas;

import java.sql.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;

public class UpdateTabel{
	public static void main(String[] args){
		try{
			//host, port, nama database, user, pass
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2", "root", "");
			
			BigDecimal ipk = new BigDecimal(3.20);
			
			String query = "update terserah set Alamat = ? where Nama = 'Daniel'";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "Djakarta");
			int hasil = ps.executeUpdate();
			
			if(hasil == 1){
				JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
			}
			else{
				JOptionPane.showMessageDialog(null,"Data gagal diupdate");
			}	
		}
		catch(SQLException se){
			Logger.getLogger(UpdateTabel.class.getName()).log(Level.SEVERE, null, se);
		}
}
	}
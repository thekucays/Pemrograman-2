package com.p2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App{
    public static void main( String[] args ){
        try{
			//parameter yang dikirim adalah host, port, nama database,user, dan password
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikump2", "root", "");
			String query ="insert into mahasiswa (nim,nama) VALUES (?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,"44");
			ps.setString(2,"Luki Ramadon");
			ps.executeUpdate();
		}catch(SQLException se){
			Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,se);
		}
    }
}

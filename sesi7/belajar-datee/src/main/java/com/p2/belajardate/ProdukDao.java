package com.p2.belajardate;

import java.math.BigDecimal;
import java.sql.*;:3636/p2
import java.util.*;

public class ProdukDao{
	public void simpanProduk(Produk p) throws SQLException{
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2", "root", "");
		String sqlSimpan = "insert into 'produk'('kodeProduk','idJenis','nama','harga','waktuInput') values (?,?,?,?,?)";
		PreparedStatement psSimpan = c.PrepareStatement(sqlSimpan);
		psSimpan.setString(1, p.getKodeProduk()); //p ini objek class Produk.java
		psSimpan.setInt(2, p.getJp().getId());
		psSimpan.setString(3, p.getNama());
		psSimpan.setBigDecimal(4, p.setHarga());
		psSimpan.setDate(5, new java.sql.Date(p.getWaktuInput().getTime()));
		
		psSimpan.executeUpdate();
		c.close();
	}
	
}

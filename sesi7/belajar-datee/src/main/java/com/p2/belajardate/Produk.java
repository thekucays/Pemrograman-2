package com.p2.belajardate;
import java.math.BigDecimal;

public class Produk{
	private Integer id;
	private JenisProduk jp; //ini objek class JenisProduk.java
	private String kodeProduk;
	private String nama;
	private BigDecimal harga;
	private Date waktuInput;
	
	public Integer getId(){
		return id;
	}
	public JenisProduk getJp(){
		return jp;
	}
	public String getKodeProduk(){
		return kodeProduk;
	}
	public String getNama(){
		return nama;
	}
	public BigDecimal getHarga(){
		return harga;
	}
	public Date getWaktuInput(){
		return waktuInput;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public void setJp(JenisProduk jp){
		this.jp = jp;
	}
	public void setKodeProduk(String kodeProduk){
		this.kodeProduk = kodeProduk;
	}
	public void setName(String nama){
		this.nama = nama;
	}
	public void setHarga(BigDecimal harga){
		this.harga = harga;
	}
	public void setWaktuInput(Date waktuInput){
		this.waktuInput = waktuInput;
	}
}

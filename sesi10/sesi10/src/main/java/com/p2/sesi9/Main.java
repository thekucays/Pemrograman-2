package com.p2.sesi9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;
import java.util.Scanner;
import java.lang.String;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.lang.reflect.InvocationTargetException;

public class Main{
	public static void main(String[] args){
		Scanner data = new Scanner(System.in);
		int pilih = 0;
		int pilihSub = 0;
		
		while(pilih != 6){
			System.out.println("=================");
			System.out.println("MENU PILIHAN");
			System.out.println("1. Tampil daftar mahasiswa");
			System.out.println("2. Input mahasiswa");
			System.out.println("3. Pencarian mahasiswa");
			System.out.println("4. Tampil daftar mata kuliah");
			System.out.println("5. Tambah mata kuliah");
			System.out.println("6. Keluar");
			System.out.print("Masukan Pilihan Anda : ");
			
			pilih = data.nextInt();
			data.nextLine();
			if(pilih == 1){
				try{
					//koneksi ke database dengan nama sesi09, dengan username root, dan password "" (kosong)
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sesi09","root","");
					String sql = "SELECT * FROM mahasiswa ";
					
					PreparedStatement psTampil = c.prepareStatement(sql);
					ResultSet rs = psTampil.executeQuery();
					
					while(rs.next()){
						//mendapatkan nilai hasil ResultSet berdasarkan nama kolom pada tabelnya
						System.out.println("------------------------------");
						System.out.println("NIM : " + rs.getInt("nim"));
						System.out.println("Nama : " + rs.getString("nama"));
						System.out.println("Alamat : " + rs.getString("alamat"));
						System.out.println("Semester : " + rs.getInt("semester"));
						System.out.println("------------------------------");
					}
					
					c.close();
				}
				catch(SQLException SE){
					SE.printStackTrace();
				}	
			}
			else if(pilih == 2){
				System.out.println("--------------------------------");
				System.out.println("Input Data Mahasiswa");
				System.out.println("--------------------------------");
				
				System.out.println("Masukkan NIM : ");
				String nim = data.nextLine();
				System.out.println("Masukkan nama : ");
				String nama = data.nextLine();
				System.out.println("Masukkan alamat : ");
				String alamat = data.nextLine();
				System.out.println("Masukkan semester : ");
				int semester = data.nextInt();
				
				try{
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sesi09","root","");
					String sql = "insert into mahasiswa (nim, nama, alamat, semester) values (?,?,?,?)";
					PreparedStatement ps = c.prepareStatement(sql);
					
					//men-set parameter yang dibutuhkan untuk string query sql nya
					ps.setString(1, nim);
					ps.setString(2, nama);
					ps.setString(3, alamat);
					ps.setInt(4, semester);
					ps.executeUpdate();
					
					c.close();
				}
				catch(SQLException SE){
					SE.printStackTrace();
				}
			}
			else if(pilih == 3){
				System.out.println("--------------------------------");
				System.out.println("Pencarian Data Mahasiswa");
				System.out.println("--------------------------------");
				
				//buat nampung id mahasiswa buat nanti kalau mau ditambahkan mata kuliah
				int tempIDMhs;
				
				System.out.println("Masukkan NIM mahasiswa : ");
				String nim = data.nextLine();
				try{
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sesi09","root","");
					String sql = "SELECT * FROM mahasiswa where nim = ?";
					PreparedStatement ps = c.prepareStatement(sql);
					ps.setString(1, nim);
					ResultSet rs = ps.executeQuery();

					while(rs.next()){
						if(rs.getString("nim")!=""){
							System.out.println("DATA MAHASISWA YANG DITEMUKAN : ");
							System.out.println("NIM : " + rs.getInt("nim"));
							System.out.println("Nama : " + rs.getString("nama"));
							System.out.println("Alamat : " + rs.getString("alamat"));
							System.out.println("Semester : " + rs.getInt("semester"));
							
							//ID Mahasiswa diambil jika ingin menambahkan Mata Kuliah
							tempIDMhs = rs.getInt("id");
							
							do{
								System.out.println("--------------------------------");
								System.out.println("MENU PENCARIAN MAHASISWA");
								System.out.println("--------------------------------");
								System.out.println("1. Edit data Mahasiswa");
								System.out.println("2. Tambah Mata Kuliah");
								System.out.println("3. Keluar");
								System.out.println("Pilihan Anda : ");
								pilihSub = data.nextInt();
								data.nextLine();
								
								if(pilihSub == 1){
									System.out.println("Masukkan NIM : ");
									String nimE = data.nextLine();
									System.out.println("Masukkan Nama : ");
									String namaE = data.nextLine();
									System.out.println("Masukkan Alamat : ");
									String alamatE = data.nextLine();
									System.out.println("Masukkan Semester : ");
									int semesterE = data.nextInt();
									
									try{
										String sqlEdit = "update mahasiswa set nim=?, nama=?, alamat=?, semester=? where id=?";
										PreparedStatement psEdit = c.prepareStatement(sqlEdit);
										psEdit.setString(1, nimE);
										psEdit.setString(2, namaE);
										psEdit.setString(3, alamatE);
										psEdit.setInt(4, semesterE);
										psEdit.setInt(5, tempIDMhs); //id  diambil dari id pencarian yang telah ditemukan tadi..
										psEdit.executeUpdate();
									}
									catch(SQLException SE){
										SE.printStackTrace();
									}
								}
								else if(pilihSub == 2){
									int count = 0;  //untuk menghitung jumlah row yang direturn ResultSet nya
									int inputdua;
									
									//NGAMBIL LIST MATA KULIAH YANG UDAH ADA DI TABEL
									String sqla = "SELECT * FROM matkul";
					
									PreparedStatement psTampila = c.prepareStatement(sqla);
									ResultSet rsa = psTampila.executeQuery();
									while(rsa.next()){
										count++; 
										
										System.out.println("------------------------------");
										System.out.println(count + " ."); 
										System.out.println("kode: " + rsa.getString("kode"));
										System.out.println("nama MK: " + rsa.getString("namaMK"));
										System.out.println("jumlah SKS: " + rsa.getInt("jmlSks"));
										System.out.println("tgl UAS: " + rsa.getDate("tglUas"));
										System.out.println("------------------------------");
									}
									
									System.out.println("masukkan pilihan Anda : ");
									inputdua = data.nextInt();
									
									//Melakukan pemasukan data ke tabel mk_ambil
									try{
										String sqlb = "insert into  mk_ambil (idMhs, idMk) values (?,?)";
										PreparedStatement psb = c.prepareStatement(sqlb);
										psb.setInt(1, tempIDMhs); //id  diambil dari id pencarian yang telah ditemukan tadi..
										psb.setInt(2, inputdua);
										psb.executeUpdate();
									}
									catch(SQLException SE){
										SE.printStackTrace();
									}
								}
							}
							while(pilihSub != 3);
						}
					}
				}
				catch(SQLException SE){
					SE.printStackTrace();
				}
			}else if(pilih == 4){
				try{
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sesi09","root","");
					String sql = "SELECT * FROM matkul";
					
					PreparedStatement psTampil = c.prepareStatement(sql);
					ResultSet rs = psTampil.executeQuery();
					
					while(rs.next()){
						System.out.println("------------------------------");
						System.out.println("kode: " + rs.getString("kode"));
						System.out.println("nama MK: " + rs.getString("namaMK"));
						System.out.println("jumlah SKS: " + rs.getInt("jmlSks"));
						System.out.println("tgl UAS: " + rs.getDate("tglUas"));
						System.out.println("------------------------------");
					}
					
					c.close();
				}
				catch(SQLException SE){
					SE.printStackTrace();
				}	
			}else if(pilih == 5){
				System.out.println("--------------------------------");
				System.out.println("Input Mata Kuliah");
				System.out.println("--------------------------------");
				
				System.out.println("Masukkan kode Mata Kuliah: ");
				String kode = data.nextLine();
				System.out.println("Masukkan nama Mata Kuliah: ");
				String namaMK = data.nextLine();
				System.out.println("Masukkan jumlah SKS: ");
				int jmlSks = data.nextInt();
				
				data.nextLine();
				
				System.out.println("Masukkan tanggal UAS (DD-MM-YYYY) : ");
				String tglUas = data.nextLine();
				
				try{
					try{
						Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sesi09","root","");
						String sql = "insert into matkul (kode, namaMK, jmlSks, tglUas) values (?,?,?,?)";
						PreparedStatement ps = c.prepareStatement(sql);

						////HANDLING INPUTAN TANGGAL/////////////////
						//pendeklarasian format date dalam string					
						final String OLD_FORMAT = "dd-MM-yyyy";
						final String NEW_FORMAT = "yyyy-MM-dd";

						//memasukan variabel tanggal ke oldDateString
						String oldDateString = tglUas;
						String newDateString;
						
						//mengkonversi format dari format lama ke format baru
						SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
						Date d = sdf.parse(oldDateString);
						sdf.applyPattern(NEW_FORMAT);
						newDateString = sdf.format(d);
						/////////////////////////////////////////////
						
						
						ps.setString(1, kode);
						ps.setString(2, namaMK);
						ps.setInt(3, jmlSks);
						ps.setString(4, newDateString);
						ps.executeUpdate();
						
						c.close();
					}
					catch(SQLException SE){
						SE.printStackTrace();
					}
				}
				catch(ParseException PE){
					//parsing tanggal
					PE.printStackTrace();
				}
			}
		}
		System.out.println("Untuk keluar, tekan ENTER");
		data.nextLine();
	}
}

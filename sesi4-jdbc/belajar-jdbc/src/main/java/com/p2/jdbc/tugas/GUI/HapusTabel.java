package com.p2.jdbc.tugas.GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;

public class HapusTabel implements ActionListener{
	Connection conn;
	Statement st;
	PreparedStatement ps;
	Font f;
	Panel p1;
	Frame f1;
	Label L;
	TextField T;
	Button hapusButton, exitButton;

	//Constructor nya
	public HapusTabel(){
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2", "root", "");
			st = conn.createStatement();
		}
		catch(Exception e){
			System.out.println("error beroooh");
		}
	}
	
	public void buatForm(){
		f1 = new Frame("Hapus Data Dalam Tabel");
		p1 = new Panel();
		L = new Label("Nama : ");
		T = new TextField(10);
		hapusButton = new Button("Hapus Data");
		exitButton = new Button("Keluar");
		
		p1.setLayout(null);
		L.setBounds(75,70,50,25);  //x, y, width, height
		T.setBounds(180,70,100,25);
		hapusButton.setBounds(75, 110, 100,20);
		exitButton.setBounds(75, 140, 100,20);
		
		p1.add(L);
		p1.add(T);
		p1.add(hapusButton);
		p1.add(exitButton);
		
		f1.add(p1);
		f1.setSize(600,200);
		f1.setVisible(true);
		
		hapusButton.addActionListener(this);
		exitButton.addActionListener(this); //bisa pake this karena class nya implemen ActionListener
	}
	
	//listenernya
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand() == "Keluar"){
			System.exit(0);
		}
		if(ae.getActionCommand() == "Hapus Data"){
			try{
				//host, port, nama database, user, pass
				BigDecimal ipk = new BigDecimal(3.20);
				
				String query = "delete from terserah where Nama = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, T.getText());
				int hasil = ps.executeUpdate();
				
				if(hasil == 1){
					JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
				}
				else{
					JOptionPane.showMessageDialog(null,"Data gagal dihapus");
				}	
			}
			catch(SQLException se){
				Logger.getLogger(HapusTabel.class.getName()).log(Level.SEVERE, null, se);
			}
		}
	}
	
	public static void main(String[] args){
		HapusTabel ht = new HapusTabel();
		ht.buatForm();
	}
}
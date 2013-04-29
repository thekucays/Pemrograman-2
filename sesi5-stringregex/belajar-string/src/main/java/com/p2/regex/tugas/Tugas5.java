package com.p2.regex.tugas;

import java.util.regex.*;
import java.util.Scanner;

public class Tugas5{
	public static void main(String[] args){
		String regNamaAlay = "\\w+[a-z]";
		String regEmail = "\\w+@\\w+\\.[a-zA-Z]{3,}";
		
		//yg ini blum bisa
		//String regTgLahir = "[0-3]?[0-9]\\s[a-zA-Z]{4,}\\s[0-2][0-9]{3,}";
		
		//yg ini formatnya dd/mm/yyyy
		String regTgLahir = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
		String regSitus = "\\w+\\.[a-zA-Z]{3,}";
		
		String nama = "n";
		String email = "n";
		String tg = "n";
		String situs = "n";
		
		String inNama;
		String inEmail;
		String inTg;
		String inSitus;
		Scanner data = new Scanner(System.in);
		
		while(nama.equals("n")){
			System.out.println("Masukkan nama Anda : ");
			inNama = data.next();
			
			if(inNama.matches(regNamaAlay)){
				System.out.println("OK");
				nama = "y";
			}
			else{
				System.out.println("nama kamu gaboleh alay eaaaaaahh");
			}
		}
		while(email.equals("n")){
			System.out.println("Masukkan email Anda : ");
			//inEmail = data.next();
			inEmail = data.next();
			
			if(inEmail.matches(regEmail)){
				System.out.println("OK");
				email = "y";
			}
			else{
				System.out.println("email kamu yang bener donk ah~~");
			}
		}
		while(tg.equals("n")){
			System.out.println("Masukkan tanggal lahir Anda : ");
			inTg = data.next();
			
			if(inTg.matches(regTgLahir)){
				System.out.println("OK");
				tg = "y";
			}
			else{
				System.out.println("masa nulis tanggal lahir sendiri salah sih -___-");
			}
		}
		while(situs.equals("n")){
			System.out.println("Masukkan situs milik Anda : ");
			inSitus = data.next();
			
			if(inSitus.matches(regSitus)){
				System.out.println("OK");
				situs = "y";
			}
			else{
				System.out.println("massukkan situs Anda yang valid.");
			}
		}
	}
}
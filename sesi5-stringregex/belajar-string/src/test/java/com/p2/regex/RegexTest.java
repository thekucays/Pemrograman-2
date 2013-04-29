package com.p2.regex;

import org.junit.*;
import static org.junit.Assert.*;

public class RegexTest{
	@Test
	public void testValidasiTgl(){
		RegexMain rm = new RegexMain();
		assertTrue(rm.valid(
			"[0-3]?[0-9]\\s[a-zA-z]{3}\\s[0-2][0-9]{3}",
			"19 feb 1992"
		));
	}
}


/*
	\\s			buat space
	[0-2]		angka range 0 sampai 2
	[0-9]{3}	angka range 0-9, sebanyak 3 kali

*/
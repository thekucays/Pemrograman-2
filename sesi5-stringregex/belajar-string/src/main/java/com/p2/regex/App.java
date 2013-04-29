package com.p2.regex;

import java.util.regex.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		String text = "thekucays@gmail.com";
        String regex = "\\w+@\\w+\\.[a-zA-Z]{2,}";
		
		/*  \\w+@\\w+\\.[a-zA-Z]{2,}.{a-zA-Z]{2,}  */
		
		if(text.matches(regex)){
			System.out.println("pas berooh");
		}
		else{
			System.out.println("engga pas berooh");
		}
    }
}

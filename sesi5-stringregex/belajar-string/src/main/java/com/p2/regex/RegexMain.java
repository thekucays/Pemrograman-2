package com.p2.regex;
import java.util.regex.*;

public class RegexMain{
	public boolean valid(String regexp, String input){
		Pattern p = Pattern.compile(regexp);
		Matcher m = p.matcher(input);
		
		return m.matches();
	}
}
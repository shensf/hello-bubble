package com.bubble.hello;

import java.util.HashMap;
import java.util.Map;

public class Util {
	
	public static void main(String[] args) {
		
		/*if(null == null){
			System.out.println("null equals null");
		}
		
		if("a" == null){
			System.out.println("a equals null");
		}
		
		if(null instanceof String){
			 System.out.println("null instanceof String");
		}
		
		String anObject = null;
		if(anObject instanceof String){
			 String anotherString = (String) anObject;
		}
		*/
		Map<String, String> map = new HashMap<>();
		map.put("name", null);
		map.put("sex", "man");
		System.out.println(map.get("name"));
		if("2".equals(map.get("name"))){
			System.out.println("a");
		}
		System.out.println("b");
	}
	

}

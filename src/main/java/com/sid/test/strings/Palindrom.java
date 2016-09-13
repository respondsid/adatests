package com.sid.test.strings;

import java.util.BitSet;

public class Palindrom {
	public static void main(String[] args) {
		String inputStr="MAIMMMAIY";
		boolean isPalAnagram=isAnagramAPalindrom(inputStr);
		System.out.println(inputStr+"'s permutation is a palindrom::"+isPalAnagram);
	}

	private static boolean isAnagramAPalindrom(String string) {
		// TODO Auto-generated method stub
		if(string.length()==1){
			return true;
		}
		BitSet charFlags= new BitSet(26);
		char[] charArrays=string.toLowerCase().toCharArray();
		for(char c:charArrays){
			int bitIndex=getBitIndex(c);
			if(!charFlags.get(bitIndex)){
				charFlags.set(bitIndex);
			}else{
				charFlags.clear(bitIndex);
			}
			
		}
		return (charFlags.cardinality()==0 || charFlags.cardinality()==1);
	}

	private static int getBitIndex(char c) {
		return Character.getNumericValue(c)-Character.getNumericValue('a');
	}
}

package com.sid.test.strings;

import java.util.HashSet;
import java.util.Set;

public class GenPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> permutations = findPermutations("ABCD");
	}

	private static Set<String> findPermutations(String string) {
		// TODO Auto-generated method stub
		Set<String> words = permutations(string);
		System.out.println("Permutations::"+words.size());
		for (String word:words){
			System.out.println(word);
		}
		return null;
	}

	private static Set<String> permutations(String inputString) {
		// TODO Auto-generated method stub
		int length = inputString.length();
		Set<String> words = null;
		if (length == 1) {
			words = new HashSet<String>();
			words.add(inputString);
			return words;
		} else {
			char[] inputChars = inputString.toCharArray();
			char thisChar = inputChars[0];
			Set<String> recurrWords = permutations(inputString.substring(1));
			words = generateCombinations(thisChar, length, recurrWords);
		}
		return words;
	}

	private static Set<String> generateCombinations(char thisChar, int length, Set<String> recurrWords) {
		Set<String> words = new HashSet<String>();
		for (String word : recurrWords) {
			for (int i = 0; i < length ; i++) {
				StringBuilder tempBuilder = new StringBuilder(word);
				tempBuilder.insert(i, thisChar);
				words.add(tempBuilder.toString());
			}

		}
		return words;
	}

}

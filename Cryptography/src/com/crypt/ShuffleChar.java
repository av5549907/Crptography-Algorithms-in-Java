package com.crypt;

import java.util.*;
public class ShuffleChar {

	public String shuffle(String s) {
		List<Character> characters = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);
        StringBuilder shuffledString = new StringBuilder();
        for (char c : characters) {
            shuffledString.append(c);
        }
        return shuffledString.toString();
     }
	public int shuffleintlist(int arr[]) {
		ArrayList<Integer> l = new ArrayList<Integer>();
        for (int c : arr) {
            l.add(c);
        }
        Collections.shuffle(l);
        StringBuilder shuffledString = new StringBuilder();
        for (int c : l) {
            shuffledString.append(c);
        }
        return l.get(0);
     }
}


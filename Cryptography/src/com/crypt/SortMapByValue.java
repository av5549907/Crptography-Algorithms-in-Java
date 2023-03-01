package com.crypt;

import java.util.*;
import java.util.Map.Entry;
public class SortMapByValue {
	
	public HashMap<Character,Integer> sortByVal(HashMap<Character,Integer> h){
		HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
		List<Entry<Character,Integer>> listOfEntry = new LinkedList<>(h.entrySet());
         
        Collections.sort(listOfEntry, new Comparator<Entry<Character,Integer>>() 
        {
            @Override
            public int compare(Entry<Character,Integer> o1, Entry<Character,Integer> o2) 
            {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
         
         
        //Map<Character,Character> sortedIdNameMap = new LinkedHashMap<Character,Character>();
         
        for (Entry<Character,Integer> entry : listOfEntry) 
        {
            hm.put(entry.getKey(), entry.getValue());
        }
		return hm;
	}
	
	
	public LinkedHashMap<Character,Double> sortByValDouble(HashMap<Character,Double> h){
		Map<Character,Double> unSortedMap = h;
		LinkedHashMap<Character,Double> reverseSortedMap = new LinkedHashMap<>();
		unSortedMap.entrySet()
		  .stream()
		  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
		  .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
		 
		return reverseSortedMap;
	}

}

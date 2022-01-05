package com.wipro.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AverageCalculator {
		
	private Map<String,LinkedHashMap<String,Float>> outputMap;
	
	public void constructMap(Map<String,HashMap<String,Integer>> inputMap,String st) 
	{
		outputMap = new HashMap<String,LinkedHashMap<String,Float>>();
		
		for(String key : inputMap.keySet()){
			
			HashMap<String,Integer> testScore = inputMap.get(key);
			LinkedHashMap<String,Float> scoreCal = new LinkedHashMap<String,Float>();
			scoreCal.put("Test Score",calScore(testScore,"test"));
			scoreCal.put("Quiz Score", calScore(testScore,"quiz"));
			scoreCal.put("Lab Score", calScore(testScore,"lab"));
			scoreCal.put("Project Score",calScore(testScore,"project"));
			scoreCal.put("OverAll Rating", overAllRating(scoreCal));
			
			outputMap.put(key, scoreCal);
		}
		
		displayData(st);
	}

	public float overAllRating(LinkedHashMap<String,Float> scoreMap) {
		float sum = 0.0f;
		
		for(String key : scoreMap.keySet()) {
			sum += scoreMap.get(key);
		}	
		return sum;
	}
	
	public float calScore(HashMap<String,Integer> scores,String matchString) 
	{
		List<Integer> marks = new ArrayList<Integer>();
		int counter = 0;
		float average = 0.0f;
		
		for(String exam : scores.keySet()) {
			if(exam.startsWith(matchString)) {
			  counter++;
			  marks.add(scores.get(exam));
			}
		}
		
		for(Integer i : marks) {
			if(matchString.equals("test")){
			    average = average + (40/marks.size())*i;
			}else if(matchString.equals("quiz")){
				average = average + (20/marks.size())*i;
			}else if(matchString.equals("lab")){
				average = average + (10/marks.size())*i;
			}else if(matchString.equals("project")){
				average = average + (30/marks.size())*i;
			}
		}
		
		return average/100;
	}
	
	public void displayData(String str) {
		System.out.println("=".repeat(125));
		System.out.println("|" + String.format("%24s", str) + "|" + String.format("%19s", "Test Score") 
		                    + "|" + String.format("%19s","Quiz Score") + "|" + String.format("%19s","Lab Score") 
		                    + "|" + String.format("%18s","Project Score") + "|" 
		                    + String.format("%18s","OverAll Rating") + String.format("%2s","|"));
		System.out.println("=".repeat(125));
		for(String key : outputMap.keySet()) 
		{	
			System.out.print("|" + String.format("%24s",key));
			LinkedHashMap<String,Float> lhm = outputMap.get(key);	
			for(String key2 : lhm.keySet()) {
				if(lhm.get(key2) == 0) {
					System.out.print("|" + String.format("%19s","NA"));
				}else {
				   System.out.print("|" + String.format("%19s",lhm.get(key2)));
				}
			}
			System.out.println();
			System.out.println("-".repeat(125));
		}
	}
}

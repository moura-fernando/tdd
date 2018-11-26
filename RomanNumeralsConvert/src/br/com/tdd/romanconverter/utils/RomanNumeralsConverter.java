package br.com.tdd.romanconverter.utils;

import java.util.HashMap;
import java.util.Map;

import br.com.tdd.romanconverter.model.LastNumbers;

public class RomanNumeralsConverter {

	
	private LastNumbers lastNumbers;
	
	public static Map<Character, Integer> conversionTable;
	static {
		conversionTable = new HashMap();
		conversionTable.put('I', 1);
		conversionTable.put('V', 5);
		conversionTable.put('X', 10);
		conversionTable.put('L', 50);
		conversionTable.put('C', 100);
		conversionTable.put('D', 500);
		conversionTable.put('M', 1000);
	}

	public int toDecimal(String romanNumeral) {
		int cont = 0;  
	    lastNumbers =  new LastNumbers.LastNumbersBuilder(0, 0, 0).build();
		
		for(int i = romanNumeral.length() -1; i >= 0 ; i--) {
			
			if (!isARomanNumeralValid(conversionTable.get(romanNumeral.charAt(i)))) 
	    		throw new RuntimeException("Este não é um número romano válido!");
    		
			lastNumbers.setCurrent(conversionTable.get(romanNumeral.charAt(i)));
			
			if (lastNumbers.getCurrent() < lastNumbers.getLast()) {
				cont -= lastNumbers.getCurrent();
			} else {
				cont += lastNumbers.getCurrent();
			}
			
			if (!isAMalFormedRomanNumeral(romanNumeral, i)) 
	    		throw new RuntimeException("Este é um número romano mal formado!");
    					
			lastNumbers.setPenultimate(lastNumbers.getLast());
			lastNumbers.setLast(lastNumbers.getCurrent());
		}
		return cont;
	}
	
	public static Map<Character, Integer> getConversionTable() {
		return conversionTable;
	}
	
	private boolean isARomanNumeralValid(Integer romanNumeral) {
		if (romanNumeral==null) return false;
		return true;
	}
	
	private boolean isAMalFormedRomanNumeral(String romanNumeral, int i) {
		int current = lastNumbers.getCurrent();
		int last = lastNumbers.getLast();
		int penultimate =  lastNumbers.getPenultimate();
		
		//Testa regra de mais de 3 simbolos repetidos
		if (i-1>=0) {
			if (isEquals(conversionTable.get(romanNumeral.charAt(i-1)), current, last, penultimate)) {
				return false;
			}
		} 
		//Testa Regra de números menores entre um maior
		if (penultimate != 0 && penultimate < last && current < last ) {
			return false;
		}
		// Testa Regra dos números que não podem se repetir
		if (current==last) {
			if (current == 5 || current == 50 || current == 500) return false;	
		}
	    return true;
    }
	
	private boolean isEquals(int n1, int n2, int n3, int n4) {
		if (n1 == n2 && n2 == n3 && n3 == n4) return true;
		return false;
	}	
	
}

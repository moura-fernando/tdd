package br.com.tdd.romanconverter.main;

import java.util.Scanner;

import br.com.tdd.romanconverter.utils.RomanNumeralsConverter;

public class ConverterApplication {
	
	public static void main(String[] args) {	
	    inputReader();
	}

	private static void inputReader() {
		RomanNumeralsConverter convert = new RomanNumeralsConverter();
		int result = 0;
		
		System.out.print("Digite um número romano ou um número inválido para sair: ");
		try (Scanner scanner = new Scanner(System.in)) {
		    while (scanner.hasNext()) {
		    	String str = scanner.next().toUpperCase();
		    	result = convert.toDecimal(str);
		    	System.out.println(str+ " é igual a: " + result);
		    	System.out.print("Digite outro número romano:");
		    }
		} catch (RuntimeException e) {
			System.out.println();
		    System.out.println(e.getMessage());
		    System.out.println("Aplição finalizada!");
		}
	}
}

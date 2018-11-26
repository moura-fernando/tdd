import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.tdd.romanconverter.utils.RomanNumeralsConverter;

/**
 * Classe de testes dos números romanos
 * 
 * @author Fernando
 *
 */
public class RomanNumeralsConverterTest {
	
	private RomanNumeralsConverter converter;
	
	@BeforeClass
	public static void testConversionTable() {
	    Map<Character, Integer> conversionTable = new HashMap();
		conversionTable.put('I', 1);
		conversionTable.put('V', 5);
		conversionTable.put('X', 10);
		conversionTable.put('L', 50);
		conversionTable.put('C', 100);
		conversionTable.put('D', 500);
		conversionTable.put('M', 1000);
		
		assertThat(conversionTable, equalTo(RomanNumeralsConverter.getConversionTable()));
	}
	
	@Before
	public void createConverter() {
		this.converter = new RomanNumeralsConverter();
	}
	
	@Test
	public void testNumberI() {
		int numberOne = converter.toDecimal("I");
		assertThat(1, equalTo(numberOne));
	}
	
	@Test
	public void testNumberV() {
		int numberFive = converter.toDecimal("V");
		assertThat(5, equalTo(numberFive));
	}
	
	@Test
	public void testNumberX() {
		int numberTen = converter.toDecimal("X");
		assertThat(10, equalTo(numberTen));
	}

	@Test
	public void testNumberWithEqualsCharacters() {
		int numberThree = converter.toDecimal("III");
		assertThat(3, equalTo(numberThree));
	}
	
	@Test
	public void testNumberWithMultiplesSumsToConversion() {
		int numberThirtyThree  = converter.toDecimal("XXXIII");
		assertThat(33, equalTo(numberThirtyThree));
	}
	
	@Test
	public void testNumberWithASubtractionToConversion() {
		int numberFour = converter.toDecimal("IV");
		assertThat(4, equalTo(numberFour));
	}
	
	@Test
	public void testNumberWithSumsAndSubtractionToConversion() {
		int numberTwentyFour = converter.toDecimal("XXIV");
		assertThat(24, equalTo(numberTwentyFour));
	}
	
	@Test(expected=RuntimeException.class)
	public void testANonRomanLiteral() {
	    converter.toDecimal("A");
	}
	 
	@Test(expected=RuntimeException.class)
	public void testAMalFormedRepeatedRomanNumbers() {
		converter.toDecimal("IIII");
	}
	
	@Test(expected=RuntimeException.class)
	public void testAMalFormedRomanNumbers() {
		converter.toDecimal("IVI");
	} 
	
}

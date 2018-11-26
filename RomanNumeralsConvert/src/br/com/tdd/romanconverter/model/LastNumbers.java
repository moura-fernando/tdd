package br.com.tdd.romanconverter.model;


/**
 * Objeto utilizando o Pattern Builder, para armazenar os três últimos 
 * valores do literal Romano. 
 * 
 * @author Fernando
 *
 */
public class LastNumbers {
	
	private int current;
	private int last;
	private int penultimate;

	
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getPenultimate() {
		return penultimate;
	}
	public void setPenultimate(int penultimate) {
		this.penultimate = penultimate;
	}
	
	private LastNumbers(LastNumbersBuilder builder) {
		this.current = builder.current;
		this.last = builder.last;
		this.penultimate = builder.penultimate;
	}
	
	//Builder Class
	public static class LastNumbersBuilder {
		
		private int current;
		private int last;
		private int penultimate;
		
		public LastNumbersBuilder(int current, int last, int penultimate ) {
			this.current = current;
			this.last = last;
			this.penultimate = penultimate;
		}
		
		public LastNumbers build() {
			return new LastNumbers(this);
		}
	}
}

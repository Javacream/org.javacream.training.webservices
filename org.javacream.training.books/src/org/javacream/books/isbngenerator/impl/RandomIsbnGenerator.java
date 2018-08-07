package org.javacream.books.isbngenerator.impl;

import java.util.Random;

import org.javacream.books.isbngenerator.api.IsbnGenerator;

public class RandomIsbnGenerator implements IsbnGenerator {

	private String prefix;
	private String suffix;
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	private Random random;
	
	{
		random = new Random(this.hashCode() + System.currentTimeMillis());
	}
	
	/* (non-Javadoc)
	 * @see org.javacream.keygeneration.business.KeyGenerator#next()
	 */
	public String next(){
		return prefix + random.nextInt() + suffix;
	}

	public String getPrefix(){
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}

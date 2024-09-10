package org.jgnn.study.web.securejpa;

import java.util.Random;

public class RandomNumberGerator {
    
	private Random random = new Random();
	
	private int seed=101;
	
	public RandomNumberGerator(int seed) {
		this.random = new Random();
		this.seed=seed;
	}
	
	public int getNextRandomNumber(){
		return random.nextInt(seed); 
	}
}

package com.santhosh.corejava.streams.parallelStreams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import com.santhosh.corejava.streams.Person;

public class ParallelStreamTester {
	static int COLLECTION_SIZE = 100000	;
	
	private static Collection <Person> getPersonCollection (){
		List <Person> personList = new ArrayList <Person> ();

		String [] names = {"David", "Marry", "Satya", "Matt", "Patrick", "Bill", "Mike", "Jake", "Amber", "Dianne"};
		int [] 	age = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		String [] states = {"NY", "MA", "MO", "CA", "TX", "MN", "WA", "PE", "NE", "NH", "OH"};		
		
		for (int i=0; i< COLLECTION_SIZE; i++){
			personList.add(new Person (names [getRandom()], age[getRandom()], states [getRandom()]));
		}
		
		System.out.println ("Generated the collection \n");
		return personList;
	}
	
private static void sequentialStreamPerformance (Collection <Person> persons){
    long t1 = System.currentTimeMillis(), count;
    
    count = persons.stream().
    		filter(x-> (x.getState().equals("NY") || x.getState().equals("TX")))
    			.filter(x-> x.getAge() > 50)
    				.filter(x-> x.getName().startsWith("M"))
    					.count();
    
    long t2 = System.currentTimeMillis();
    System.out.println("Count = " + count + " Normal Stream Takes " + (t2-t1) + " ms\n");
}
	
private static void parallelStreamPerformance (Collection <Person> persons){
    long t1 = System.currentTimeMillis(), count;
    
    count = persons.parallelStream().
    		filter(x-> (x.getState().equals("NY") || x.getState().equals("TX")))
    			.filter(x-> x.getAge() > 50)
    				.filter(x-> x.getName().startsWith("M"))
    					.count();
    
    long t2 = System.currentTimeMillis();
    System.out.println("Count = " + count + " Parallel Stream takes " + (t2-t1) + " ms\n");
}
	
	private static void forkJoinPoolParallelStreamPerformance (Collection <Person> persons){
	    long t1 = System.currentTimeMillis(), count;	    

		try {
			ForkJoinPool customThreadPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
			count = customThreadPool.submit(
					()-> persons.parallelStream()
						.filter(x-> (x.getState().equals("NY") || x.getState().equals("TX")))
	        				.filter(x-> x.getAge() > 50)
	        					.filter(x-> x.getName().startsWith("M"))
	        						.count()).get();
	        long t2 = System.currentTimeMillis();
	        
	        System.out.println("Count = " + count + " ForkJoinPool Stream Takes= " + (t2-t1) + " ms\n");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	private static int getRandom (){
		return new Random().ints(0, 10).findFirst().getAsInt();
	}
	
	public static void main(String[] args) {
		Collection <Person> persons = getPersonCollection ();
		//sequentialStreamPerformance (persons);
		parallelStreamPerformance (persons);
		//forkJoinPoolParallelStreamPerformance (persons);
	}
	
}
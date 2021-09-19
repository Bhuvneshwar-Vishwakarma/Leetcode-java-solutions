 package arrays_and_String_9;
import java.util.*;

public class Sieve_Of_Eratosthenes_16 {
    
    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static void printPrimeUsingSieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        
        for(int i = 2; i * i <= isPrime.length; i++) {
        	if(isPrime[i] == true) {
        		// making multiple not prime
        		for(int j = i + i; j < isPrime.length; j += i) {
        			isPrime[j] = false; // not prime;
        		}
        	}
        }
        // print all prime till n
        for(int i = 2; i < isPrime.length; i++) {
        	if(isPrime[i] == true){
        		System.out.print(i + " ");
        	}
        }
        System.out.println();
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {   
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPrimeUsingSieve(n);
    }
}
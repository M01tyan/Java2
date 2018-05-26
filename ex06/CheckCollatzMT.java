import java.math.BigInteger;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;


// The implementation of CheckCollatz.check() will be extremely slow
// if we try very large values for n.
// It is actually easy to share the computation on multiple threads,
// by spawning as many threads as cores and running the checks
// for an interval [lower, upper] on 1 core.
//
public class CheckCollatzMT extends Thread{
  BigInteger n;
  public static void main(String[] args) {
  	if (args.length != 2) {
  	    System.out.println("Usage:");
  	    System.out.println("java CheckCollatzMT n num_threads");
  	    System.out.println("where positive integers i: 1<= i <= n will be checked");
  	    System.out.println("and num_threads is the number of threads to use");
  	    System.exit(1);
  	}

	// TODO complete
	// Spawn num_threads,
	// each of them will verify the conjecture for i in [lower, upper]
	// where lower and upper are determined such that each thread has
	// approximately the same amount of work to perform.
	//

  	CheckCollatzMT[] threads = new CheckCollatzMT[Integer.parseInt(args[1])];

  	for(int i=0; i<threads.length; i++){
  	    threads[i] = new CheckCollatzMT(new BigInteger(args[0]));
  	}

  	long start_time = new Date().getTime();
  	for(int i=0; i<threads.length; i++){
  	    threads[i].start();
    }
  	long end_time = new Date().getTime();
  	System.out.println("Ellapsed time: " + (end_time-start_time) + "ms");
    System.out.println("The conjecture seems valid up to n="+args[0]);
/*
  	if (v) {
  	    System.out.println("The conjecture seems valid up to n="+args[0]);
  	} else {
  	    System.out.println("The conjecture is not valid");
  	}
    */
  }

  public CheckCollatzMT(BigInteger n){
	  this.n = n;
  }



    public void run(){
  	  for(int i=1; i<this.n.intValue(); i++){
  	    boolean v = check(new BigInteger(String.valueOf(i)));
        if(!v) {
          System.out.println("The conjecture is not valid");
          return;
        }
  	  }
    }


    public static boolean check(BigInteger n) {
    	boolean v;
    	//BigInteger n = new BigInteger(String.valueOf(i));
    	if(n.mod(new BigInteger("2")).equals(java.math.BigInteger.ZERO)){
    	    return true;
    	} else {
    	    if (n.mod(new BigInteger("2")).equals(java.math.BigInteger.ZERO)) {
    		    v = check(n.divide(new BigInteger("2")));
    	    } else {
    		    v = check(n.multiply(new BigInteger("3")).add(java.math.BigInteger.ONE));
    	    }
	    }
	    return v;
    }
}

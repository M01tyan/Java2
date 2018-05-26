import java.math.BigInteger;
import java.util.Date;


// Collatz.check() checks the Collatz conjecture for a given
// number n.
// Now, to prove the conjecture to be correct, we would need to
// to verify it for all n.
// This is not possible to check for all n with a given computer
// but at least we can check for several values.
//
public class CheckCollatz {

  // Check the conjecture for 1 <= i <= n
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

  public static boolean checkfor(BigInteger n){
    boolean v = false;
    for(int i=1; i<=n.intValue(); i++){
      if(check(new BigInteger(String.valueOf(i))) == false) return false;
    }
    return true;
  }


  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage:");
      System.out.println("java CheckCollatz n");
      System.out.println("will check the Collatz conjecture for");
      System.out.println("every 1 <= i <= n");
      System.exit(1);
    }

    long start_time = new Date().getTime();
    boolean v = CheckCollatz.checkfor(new BigInteger(args[0]));
    long end_time = new Date().getTime();
    System.out.println("Ellapsed time: " + (end_time-start_time) + "ms");

    if (v) {
      System.out.println("The conjecture seems valid up to n="+args[0]);
    } else {
      System.out.println("The conjecture is not valid");
    }
  }
}

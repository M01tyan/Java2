// COMPLETE
//
// "Transfer" threads select a random amount of money in [0, max_amount]
// and transfer it to a random account in the bank.
//
import java.util.Random;

public class Transfer {
	public Transfer(Bank bank, int from, int max_amount) {
		bank_ = bank;
		from_ = from;
		max_ = max_amount;
	}

	// COMPLETE
  public void rand_transfer(){
    while(true){
      Random rand = new Random();
      rand_amount = rand.nextInt(max_);
      to_ = rand.nextInt(4);
      bank_.transfer(from_, to_, rand_amount);
    }
  }


  private int to_;
  private int rand_amount;
	private Bank bank_;
	private int from_;
	private int max_;
}

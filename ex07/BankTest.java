import java.util.Random;

public class BankTest extends Thread{
	public static final int N_ACCOUNTS = 5;
	public static final int INIT_BALANCE = 1000;
	private int num;

	public static void main(String args[]) {

		// COMPLETE
		BankTest[] b = new BankTest[N_ACCOUNTS];
		for(int i=0; i<N_ACCOUNTS; i++){
			b[i] = new BankTest(i);
		}
		for(int i=0; i<N_ACCOUNTS; i++){
			b[i].start();
		}
	}

	public BankTest(int num){
		this.num = num;
	}

	public void run(){
		Bank bank = new Bank(N_ACCOUNTS, INIT_BALANCE);
		Transfer transfer = new Transfer(bank, num, INIT_BALANCE);
		transfer.rand_transfer();
	}
}

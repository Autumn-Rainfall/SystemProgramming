import java.util.concurrent.Semaphore;

public class Account {
	private Semaphore semaphoreBalance;
	private Semaphore synchronization;
	private Semaphore mutualExclusion;
	
	private int count;

	private int balance;
	// shared variable
	private String owner;

	public Account(String owner, int balance) throws InterruptedException {
		this.owner = owner;
		this.balance = balance;

		this.semaphoreBalance = new Semaphore(1); // 1명 들어가면 lock
		this.synchronization = new Semaphore(1);
		this.synchronization.acquire();
		this.mutualExclusion = new Semaphore(1);
		}

	public void deposite(int amount) {
		try {
			this.semaphoreBalance.acquire();
			this.balance = this.balance + amount;
			System.out.println(this.owner + "::deposite-" + this.balance);
			this.semaphoreBalance.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void withdraw(int amount) {
		try {
			this.semaphoreBalance.acquire();
			this.balance = this.balance - amount;
			System.out.println(this.owner + "::withdraw-" + this.balance);
			this.semaphoreBalance.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void provide(int amount) throws InterruptedException {
		this.mutualExclusion.acquire();
		count++;
		this.balance = this.balance + amount;
		System.out.println(this.owner + "::deposite-" + this.balance);
		this.mutualExclusion.release();
		this.synchronization.release();
	}
	
	public void consume(int amount) throws InterruptedException {
		this.synchronization.acquire();
		this.mutualExclusion.acquire();
		this.balance = this.balance - amount;
		System.out.println(this.owner + "::withdraw-" + this.balance);
		count--;
		this.mutualExclusion.release();
	}
}


public class Consumer implements Runnable {
	private String name;
	private Account account;

	public Consumer(String name, Account account) {
		this.name = name;
		this.account = account;
	}

	public void run() {
		for (int i = 0; i < 5; i++)
			try {
				this.account.consume(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

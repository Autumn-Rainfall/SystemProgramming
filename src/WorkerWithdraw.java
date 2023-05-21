
public class WorkerWithdraw extends Thread {
	private String name;
	private Account account;

	public WorkerWithdraw(String name, Account account) {
		this.name = name;
		this.account = account;
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				this.account.withdraw(200);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

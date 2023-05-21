
public class WorkerDeposite extends Thread {
	private String name;
	private Account account;

	public WorkerDeposite(String name, Account account) {
		this.name = name;
		this.account = account;
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				this.account.deposite(200);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

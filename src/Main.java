
public class Main {
	private String name;

	public Main() {
		this.name = new String("main");
	}

	public void run() throws InterruptedException {
		// shared object
		Account account = new Account("ȫ�浿", 10000);
		
		WorkerDeposite workerDeposite = new WorkerDeposite("worker1", account);
		WorkerWithdraw workerWithdraw = new WorkerWithdraw("worker2", account);
		
//		workerDeposite.start();
//		workerWithdraw.start();
		
		Provider provider = new Provider("worker1", account);
		Consumer consumer = new Consumer("worker2", account);
		
		provider.run();
		consumer.run();

		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(this.name + "-" + i);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Main main = new Main();
		main.run();
	}
}

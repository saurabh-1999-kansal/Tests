package test2.question2;

public class Main {

	public static void main(String[] args) {
		job job = new job();
		Thread thread1 = new Thread(job, "A");
		Thread thread2 = new Thread(job, "B");
		Thread thread3 = new Thread(job, "C");
		Thread thread4 = new Thread(job, "D");
		Thread thread5 = new Thread(job, "E");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();

		System.out.println(job.getSum());
	}
}

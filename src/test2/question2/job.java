package test2.question2;

import java.util.Random;

class job implements Runnable {
	Random random = new Random();
	private int sum;

	private boolean isDone = false;
	int count = 0;

	@Override
	public void run() {
		int randomNumber = random.nextInt(10) + 1;
		System.out.println(randomNumber);
		count++;
		sum = sum + randomNumber;
		if (count == 5) {

			isDone = true;
			synchronized (this) {
				notifyAll();
			}
		}
	}

	public synchronized int getSum() {
		if (!isDone) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sum;
	}
}
package LinkedBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class main {

	public static void main(String[] args) {
		final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
		// Thread 1
		new Thread(() -> {
			try {
				for (int i = 0; i < 1000000; i++) {
					queue.put(i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		// Thread 2
		new Thread(() -> {
			try {
				for (int i =  1000000; i < 2000000; i++) {
					queue.put(i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		// Thread takes data from queue and processes sequentially
		new Thread(()->{
			while(true) {
				try {
					int i = queue.take();
					// process item i
					System.out.println(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}

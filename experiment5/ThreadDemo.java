class Counter {
    private int count;

    synchronized void increment() {
        count++;
    }

    synchronized int get() {
        return count;
    }
}

class WorkerThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread subclass started");
    }
}

class Seats {
    private int available = 10;

    synchronized int book() {
        if (available == 0) {
            return 0;
        }
        return available--;
    }

    synchronized int getAvailable() {
        return available;
    }
}

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        WorkerThread worker = new WorkerThread();
        worker.start();
        worker.join();

        Counter counter = new Counter();
        Runnable incrementJob = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };
        Thread firstCounter = new Thread(incrementJob);
        Thread secondCounter = new Thread(incrementJob);
        firstCounter.start();
        secondCounter.start();
        firstCounter.join();
        secondCounter.join();
        System.out.println("Synchronized final count = " + counter.get());

        Seats seats = new Seats();
        Thread[] bookingThreads = new Thread[3];
        for (int i = 0; i < bookingThreads.length; i++) {
            String counterName = "Counter-" + (i + 1);
            bookingThreads[i] = new Thread(() -> {
                for (int booking = 0; booking < 4; booking++) {
                    int seat = seats.book();
                    if (seat > 0) {
                        System.out.println(counterName + " booked seat " + seat);
                    }
                }
            });
            bookingThreads[i].start();
        }
        for (Thread bookingThread : bookingThreads) {
            bookingThread.join();
        }
        System.out.println("Seats remaining = " + seats.getAvailable());
    }
}
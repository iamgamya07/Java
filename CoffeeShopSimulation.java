import java.util.LinkedList;
import java.util.Queue;

class CounterEmptyException extends Exception {
    public CounterEmptyException(String message) {
        super(message);
    }
}

class CoffeeCounter {
    private final int capacity;
    private final Queue<String> counter;

    public CoffeeCounter(int capacity) {
        this.capacity = capacity;
        this.counter = new LinkedList<>();
    }

    public synchronized void addCoffee(String coffee) throws InterruptedException {
        while (counter.size() == capacity) {
            System.out.println(Thread.currentThread().getName() + " is waiting. Counter is full.");
            wait();
        }
        counter.add(coffee);
        System.out.println(Thread.currentThread().getName() + " prepared coffee. Counter: " + counter.size());
        notifyAll();
    }

    public synchronized String takeCoffee() throws InterruptedException, CounterEmptyException {
        while (counter.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " is waiting. Counter is empty.");
            wait();
        }
        String coffee = counter.poll();
        System.out.println(Thread.currentThread().getName() + " picked up coffee. Counter: " + counter.size());
        notifyAll();
        return coffee;
    }

    public synchronized String sampleCoffee() throws InterruptedException, CounterEmptyException {
        if (counter.isEmpty()) {
            throw new CounterEmptyException("Counter is empty. No coffee to sample.");
        }
        String coffee = counter.poll();
        System.out.println(Thread.currentThread().getName() + " sampled coffee. Counter: " + counter.size());
        notifyAll();
        return coffee;
    }
}

class Barista implements Runnable {
    private final CoffeeCounter counter;
    private final int coffeeCount;

    public Barista(CoffeeCounter counter, int coffeeCount) {
        this.counter = counter;
        this.coffeeCount = coffeeCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < coffeeCount; i++) {
                counter.addCoffee("Coffee");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Customer implements Runnable {
    private final CoffeeCounter counter;
    private final int coffeeCount;

    public Customer(CoffeeCounter counter, int coffeeCount) {
        this.counter = counter;
        this.coffeeCount = coffeeCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < coffeeCount; i++) {
                counter.takeCoffee();
            }
        } catch (InterruptedException | CounterEmptyException e) {
            System.out.println(e.getMessage());
        }
    }
}

class CoffeeReviewer implements Runnable {
    private final CoffeeCounter counter;

    public CoffeeReviewer(CoffeeCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            counter.sampleCoffee();
        } catch (InterruptedException | CounterEmptyException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class CoffeeShopSimulation {
    public static void main(String[] args) {
        CoffeeCounter counter = new CoffeeCounter(3);

        Thread barista1 = new Thread(new Barista(counter, 2), "Barista 1");
        Thread barista2 = new Thread(new Barista(counter, 3), "Barista 2");

        Thread customer1 = new Thread(new Customer(counter, 1), "Customer 1");
        Thread customer2 = new Thread(new Customer(counter, 2), "Customer 2");
        Thread customer3 = new Thread(new Customer(counter, 1), "Customer 3");

        Thread reviewer = new Thread(new CoffeeReviewer(counter), "Coffee Reviewer");

        barista1.start();
        barista2.start();
        customer1.start();
        customer2.start();
        customer3.start();
        reviewer.start();

        try {
            barista1.join();
            barista2.join();
            customer1.join();
            customer2.join();
            customer3.join();
            reviewer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class SynchronizedMultiThreadType {

    public static void main(String[] args) throws InterruptedException {
        Counter count = new Counter();

        incrementor inc = new incrementor(count);
        decrementor dec = new decrementor(count);

        new Thread(inc).start();
        new Thread(dec).start();

        System.out.println("total count = " + count.getCount() + " vs. expected = " + (0));
    }
}

class decrementor implements Runnable {
    Counter counter;

    decrementor(Counter c) {
        this.counter = c;
    }

    public void run(){
        for (int i = 0; i < 1000000; i++){
            counter.decrementCount();
        }
    }
}

class incrementor implements Runnable {
    Counter counter;

    incrementor(Counter c) {
        this.counter = c;
    }

    public void run(){
        for (int i = 0; i < 1000000; i++){
            counter.incrementCount();
        }
    }
}
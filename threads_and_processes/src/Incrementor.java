class Incrementor implements Runnable {
    Counter counter;

    Incrementor(Counter c) {
        this.counter = c;
    }

    public void run(){
        for (int i = 0; i < 1000000; i++){
            counter.incrementCount();
        }
    }
}
class Decrementor implements Runnable {
    Counter counter;

    Decrementor(Counter c) {
        this.counter = c;
    }

    public void run(){
        for (int i = 0; i < 1000000; i++){
            counter.decrementCount();
        }
    }
}
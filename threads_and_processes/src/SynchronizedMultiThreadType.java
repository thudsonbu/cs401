public class SynchronizedMultiThreadType {
    public static void main(String[] args) throws InterruptedException {
        Counter count = new Counter();

        Thread inc = new Thread(new Incrementor(count));
        Thread dec = new Thread(new Decrementor(count));

        while(inc.isAlive() && dec.isAlive()){}

        System.out.println("total count = " + count.getCount() + " vs. expected = " + (0));
    }
}

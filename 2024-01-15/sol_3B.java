/*
Design a Java program that simulates the production process in the warehouse using two types of
 threads: `Manufacturer` and `Packager`. The `Manufacturer` thread should produce products at a
 fixed rate and put them in a shared buffer [String]. The `Packager` thread should take products from
 the buffer and pack them into boxes.
 - The shared buffer has a maximum capacity to prevent overproduction.
 - The `Manufacturer` thread should wait if the buffer is full and resume production when there
    is space.
 - The `Packager` thread should wait if the buffer is empty and resume packing when there
    are products available.
 - Implement a mechanism for interthread communication to synchronize the actions of the
    `Manufacturer` and `Packager` threads.
*/

// solution

class Buffer {
    private String[] arr;
    private int front, rear;
    Buffer() {
        arr = new String[10];
        front = rear = -1;
    }
    public synchronized void produce(String x) {
        try {
            while((rear+1)%10 == front) wait();
            rear = (rear+1)%10;
            arr[rear] = x;
            if(front == -1) front++;
            System.out.println("Manufactured: " + x);
            notifyAll();
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Manufacture interrupted.");
        }
    }
    public synchronized String consume() {
        try {
            while(front == -1) wait();
            String x = arr[front];
            if(front==rear) front = rear = -1;
            else front = (front+1)%10;
            System.out.println("Packaged: " + x);
            notifyAll();
            return x;
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Packaging interrupted.");
            return null;
        }
    }
}

class Manufacturer extends Thread {
    private Buffer buffer;

    public Manufacturer(Buffer buffer) {
        this.buffer = buffer;
    }
    
    public void run() {
        int n = 1;
        while(true) {
            String product = "Product" + n++;
            buffer.produce(product);
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

class Packager extends Thread {
    private Buffer buffer;

    public Packager(Buffer buffer) {
        this.buffer = buffer;
    }
    
    public void run() {
        while(true) {
            String product = buffer.consume();
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

class sol_3B {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Manufacturer m = new Manufacturer(buffer);
        Packager p = new Packager(buffer);
        m.start();
        p.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        m.interrupt();
        p.interrupt();
    }
}

/*
sample output:
Manufactured: Product1
Packaged: Product1
Manufactured: Product2
Packaged: Product2
Manufactured: Product3
Packaged: Product3
Manufactured: Product4
Manufactured: Product5
Packaged: Product4
Manufactured: Product6
Packaged: Product5
Manufactured: Product7
Packaged: Product6
Manufactured: Product8
Manufactured: Product9
Packaged: Product7
Manufactured: Product10
Packaged: Product8
*/
package SafeCinema;


public class Happy12306 {
    public static void main(String[] args) {
        Web12306 web12306 = new Web12306(5, "CyWeb12306");
        new Passenger(web12306, "AA", 2).start();
        new Passenger(web12306, "BB", 3).start();

    }

}

//顾客
class Passenger extends Thread {
    int seats;

    public Passenger(Runnable target, String name, int seats) {
        super(target, name);
        this.seats = seats;
    }
}

//火车票网站
class Web12306 implements Runnable {
    int available;//可用位置
    String name;

    public Web12306(int available, String name) {
        this.available = available;
        this.name = name;
    }

    @Override
    public void run() {
        Passenger p = (Passenger) Thread.currentThread();
        boolean flag = this.bookTickets(p.seats);
        if (flag) {
            System.out.println(Thread.currentThread().getName() + "-->出票成功" + "-->位置为：" + p.seats);

        } else {
            System.out.println(Thread.currentThread().getName() + "-->出票失败" + "-->位置不够");
        }
    }

    public synchronized boolean bookTickets(int seats) {
        System.out.println(Thread.currentThread().getName()+"可用位置为：" + available);
        if (seats > available) {
            return false;
        }
        available -= seats;
        return true;
    }
}
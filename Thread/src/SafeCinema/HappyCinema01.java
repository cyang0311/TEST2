package SafeCinema;

public class HappyCinema01 {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(2,"CyCinema");
        new Thread(new Customer(cinema,2),"AA").start();
        new Thread(new Customer(cinema,2),"BB").start();

    }
}
//顾客
class Customer implements Runnable{
    Cinema cinema;
    int seats;
    public Customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema){
            boolean flag = cinema.bookTickets(seats);
            if (flag){
                System.out.println(Thread.currentThread().getName()+"-->出票成功"+"-->位置为："+seats);
            }else {
                System.out.println(Thread.currentThread().getName()+"-->出票失败"+"-->位置不够");
            }
        }
    }
}

//影院
class Cinema {
    int available;//可用位置
    String name;

    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }
    public Boolean bookTickets(int seats){
        System.out.println("可用位置为："+available);
        if (seats>available){
            return false;
        }
        available-=seats;
        return true;
    }
}
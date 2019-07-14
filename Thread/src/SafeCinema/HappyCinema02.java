package SafeCinema;

import java.util.ArrayList;
import java.util.List;

public class HappyCinema02 {
    public static void main(String[] args) {
        List<Integer> available = new ArrayList<Integer>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(4);

        List<Integer> seats1 = new ArrayList<Integer>();
        List<Integer> seats2 = new ArrayList<Integer>();
        seats1.add(1);
        seats1.add(2);
        seats1.add(3);
        seats1.add(4);
        seats2.add(1);
        seats2.add(2);
        HCinema cinema = new HCinema(available,"CyCinema");
        new Thread(new HCustomer(cinema,seats1),"AA").start();
        new Thread(new HCustomer(cinema,seats2),"BB").start();

    }
}
//顾客
class HCustomer implements Runnable{
    HCinema cinema;
    List<Integer> seats;
    public HCustomer(HCinema cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema){
            List<Integer> least = new ArrayList<Integer>();
            least.addAll(this.cinema.available);
            least.removeAll(seats);
            boolean flag = cinema.bookTickets(seats);
            if (flag){
                System.out.println(Thread.currentThread().getName()+"-->出票成功"+"-->位置为："+seats);
                System.out.println("剩余位置为："+least);
                System.out.println();
            }else {
                System.out.println(Thread.currentThread().getName()+"-->出票失败"+"-->位置不够");
                System.out.println();
            }
        }
    }
}

//影院
class HCinema {
    List<Integer> available;//可用位置
    String name;

    public HCinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }
    public Boolean bookTickets(List<Integer> seats){
        System.out.println("可用位置为："+available);
        List<Integer> copy = new ArrayList<Integer>();
        //容器复制
        copy.addAll(available);
        //容器相减
        copy.removeAll(seats);
        if (available.size()-copy.size()!=seats.size()){
            return false;
        }
        available = copy;
        return true;
    }
}
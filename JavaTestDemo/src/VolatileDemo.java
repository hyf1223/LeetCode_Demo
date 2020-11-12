import java.util.concurrent.TimeUnit;

/**
 * @author: monar
 * @time: 2020/10/26 14:40
 * @description:
 */
class MyData {
    volatile int num = 0;

    public void addTo50() {
        this.num = 50;
    }
}
public class VolatileDemo {

    public static void main(String[] args) {
        seeOkByVolatile();
    }
    // 可以保证可见性，即时通知其他线程
    public static void seeOkByVolatile() {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {// 暂停线程3秒钟
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo50();
            System.out.println(Thread.currentThread().getName() + " \t updated num val " + myData.num);

        }, "线程A").start();

        // 第二个线程就是main线程

        while (myData.num == 0) {
            // main线程就一直循环等待，知道num值不在为0.
        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }

}

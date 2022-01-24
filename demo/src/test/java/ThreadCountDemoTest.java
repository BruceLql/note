import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lql
 * @Date 2021/12/23 4:37 下午
 */
public class ThreadCountDemoTest {
    public static final int THREAD_NUM = 10;
    public ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_NUM);// 创建10个线程放入线程池内

    public void doHandler() {
        try {
            List<Map<String, Object>> list = getList();
            final CountDownLatch countdown = new CountDownLatch(THREAD_NUM);// 子线程数
            int oneThreadCount = list.size() / THREAD_NUM + 1;
            for (int num = 0; num < THREAD_NUM; num++) {// 开启线程个数
                System.out.println("----------------共有的线程个数:" + countdown.getCount());
                threadPool.execute(new myRun(list, num, countdown, oneThreadCount));
            }
            countdown.await();// 这里进行同步等待,等所有子线程结束后，执行 countdown.await()后面的代码
            System.out.println("##结束等待------------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    public static List<Map<String, Object>> getList() {
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 99; i++) {
            Map<String, Object> tmpMap = new HashMap<String, Object>();
            tmpMap.put("id", 1);
            tmpMap.put("name", "rose");
            tmpMap.put("salary" + i, 10000 + i);
            resultList.add(tmpMap);
        }
        return resultList;
    }

    public class myRun implements Runnable {

        private List<Map<String, Object>> tmpList;
        private int threadCount;
        private CountDownLatch countdown;
        private int oneThreadCount;

        public myRun(List<Map<String, Object>> tmpList, int threadCount,
                     CountDownLatch countdown, int oneThreadCount) {
            super();
            this.tmpList = tmpList;
            this.threadCount = threadCount;
            this.countdown = countdown;
            this.oneThreadCount = oneThreadCount;
        }

        @Override
        public void run() {
            for (int i = threadCount * oneThreadCount; i < (threadCount + 1) * oneThreadCount
                    && i < tmpList.size(); i++) {
                System.out.println(Thread.currentThread().getName() + "#" + i);
                System.out.println(tmpList.get(i));
            }
            countdown.countDown();// 每个子线程结束后进行线程减1
            System.out.println(Thread.currentThread().getName()
                    + "##线程结束------------------------");
            System.out.println("----------------剩余的线程个数:"
                    + countdown.getCount());
        }

    }

    @Test
    public void test() {
        doHandler();
    }
}
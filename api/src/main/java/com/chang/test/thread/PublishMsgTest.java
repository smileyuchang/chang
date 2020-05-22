package com.chang.test.thread;

import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Java使用多线程发送消息
 *
 *  在后台管理用户信息的时候，经常会用到批量发送提醒消息，首先想到的有：
 *
 * （1）、循环发送列表，逐条发送。优点是：简单，如果发送列表很少，而且没有什么耗时的操作，是比较好的一种选择，缺点是：针对大批量的发送列表，不可取，耗时，程序会出现严重的阻塞问题。
 *
 * （2）、使用队列（BlockingQueue），开启多个线程，分为三个部分。一部分负责处理将发送列表放入队列；一部分负责从队列中读取并发送消息；第三部分负责监视队列是否为空及后续的操作。
 *
 * （3）、以下说到的这种模式，使用Future、Callable来返回发送结果，觉得是一种比较好的方式，很简单代码也很详细，就不介绍了。
 */
public class PublishMsgTest {
    //创建固定大小为100 的线程池
    private static ExecutorService service = Executors.newFixedThreadPool(100);

    //发送消息的业务逻辑方法
    public int sendMsg(List<Integer> receivers, String content) {
        long begin = System.nanoTime();
        AtomicInteger ai = new AtomicInteger(0);
        List<Future<Integer>> list = new ArrayList<>();
        //循环发送消息
        for (int i = 0; i < receivers.size(); i++) {
            Integer receiver = receivers.get(i);
            //使用Future，Callable实现发送消息后返回发送结果
            Future<Integer> future = service.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    //调用相对比较耗时的发送消息接口
                    Thread.sleep(200);
                    //发送消息
                    int resultStatus = sendMsg(receiver, content);
                    System.out.println("接收者【" + receiver + "】,发送结果【" + resultStatus + "】");
                    return resultStatus;
                }
            });
            list.add(future);
        }
        System.out.println("-----------------------" + (System.nanoTime() - begin) / 1000_000d + "-----------------------");
        //循环接收发送结果，相当于一个使线程同步的过程，这个过程是比较耗时的
        for (int i = 0; i < list.size(); i++) {
            try {
                int resultStatus = list.get(i).get();
                if (resultStatus == 0) {//发送成功
                    ai.incrementAndGet();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //关闭线程池 ---yc
        service.shutdownNow();
        System.out.println("发送消息结束，耗时：" + (System.nanoTime() - begin) / 1000_000d);
        return ai.get();
    }

    public static void main(String[] args) {
        PublishMsgTest pmt = new PublishMsgTest();
        //待接收人
        List<Integer> receivers = new ArrayList<Integer>();
        for (int i = 0; i < 1000; i++) {
            receivers.add(i);
        }
        String content = "群发消息_测试代码";
        int successCount = pmt.sendMsg(receivers, content);
        System.out.println("共有【" + receivers.size() + "】接收者，发送成功【" + successCount + "】");
    }

    //完成发送消息
    private int sendMsg(Integer receiver, String content) {
        if (receiver % 2 == 0) {//模拟被2整除，即为发送成功
            return 0;
        }
        return 1;
    }



}
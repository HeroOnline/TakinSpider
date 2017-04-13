package com.bj58.chr.data.spider.zhilian.demo;

import java.io.File;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class ZLPipline implements PageModelPipeline<ZLJobInfo> {

    private static final Logger logger = LoggerFactory.getLogger(ZLPipline.class);

    private static final File zljob = new File("D:/opendata/zhilian1/job.txt");
    private static final AtomicLong success = new AtomicLong(0);
    public static final AtomicLong submit = new AtomicLong(0);
    public static final AtomicLong queue = new AtomicLong(0);
    public static final AtomicLong duplicate = new AtomicLong(0);

    public ZLPipline() {
        try {
            //            Files.write("", zljob, Charsets.UTF_8);
            ScheduledExecutorService respScheduler = new ScheduledThreadPoolExecutor(1);

            respScheduler.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    count();
                }
            }, 10, 5, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void count() {
        try {
            logger.info(String.format("statics submit:%s queue:%s duplicate:%s success:%s ", submit.get(), queue.get(), duplicate.get(), success.get()));
            logger.info(String.format("statics queuetrate:%f duprate:%f sucrate:%f ", (float) queue.get() / submit.get(), (float) duplicate.get() / submit.get(), (float) success.get() / queue.get()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(ZLJobInfo job, Task task) {
        try {
            success.getAndIncrement();
            //            Files.append(JSON.toJSONString(job) + "\n", zljob, Charsets.UTF_8);
            logger.info(JSON.toJSONString(job));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

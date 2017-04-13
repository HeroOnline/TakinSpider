package com.bj58.chr.data.spider.chr.cv;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by liyan23 on 2016/9/10.
 */
public class CvDataPipeline implements PageModelPipeline {

    private static final File zljob = new File("D:/opendata/chinahrcv/job.txt");
    private static final AtomicLong success = new AtomicLong(0);

    private static final Logger logger = LoggerFactory.getLogger(CvDataPipeline.class);

    public CvDataPipeline() {
        ScheduledExecutorService respScheduler = new ScheduledThreadPoolExecutor(1);
        respScheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                count();
            }
        }, 10, 5, TimeUnit.SECONDS);
    }

    private void count() {
        SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss");

        System.out.println((sf.format(new Date()) + "--split success:" + success.get()));
    }

    public void process(Object o, Task task) {
        try {
            success.getAndIncrement();
            Files.append(JSON.toJSONString(o) + "\n", zljob, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

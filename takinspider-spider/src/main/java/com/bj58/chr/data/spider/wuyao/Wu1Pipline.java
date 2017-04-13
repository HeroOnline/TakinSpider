package com.bj58.chr.data.spider.wuyao;

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

/**
 * 抓取结果处理
 *
 * @author WangYazhou
 * @date  2016年7月21日 上午11:51:22
 * @see
 */
public class Wu1Pipline implements PageModelPipeline<Wu1JobInfo> {

    private static final Logger logger = LoggerFactory.getLogger(Wu1Pipline.class);

    private static final File wuyjob = new File("D:/opendata/51/job.txt");
    private static final AtomicLong success = new AtomicLong(0);
    public static final AtomicLong submit = new AtomicLong(0);
    public static final AtomicLong queue = new AtomicLong(0);
    public static final AtomicLong duplicate = new AtomicLong(0);

    public Wu1Pipline() {
        try {
            Files.write("", wuyjob, Charsets.UTF_8);//清空文件
            ScheduledExecutorService respScheduler = new ScheduledThreadPoolExecutor(1);

            respScheduler.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    count();
                }
            }, 10, 60, TimeUnit.SECONDS);
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
    public void process(Wu1JobInfo job, Task task) {
        try {
            success.getAndIncrement();
            //            Files.append(JSON.toJSONString(job) + "\n", wuyjob, Charsets.UTF_8);
            logger.info(JSON.toJSONString(job));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

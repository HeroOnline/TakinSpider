package com.bj58.chr.data.spider.zhilian.demo;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bj58.chr.data.spider.util.MapDbDuplicateRemover;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.scheduler.DuplicateRemovedScheduler;
import us.codecraft.webmagic.scheduler.QueueScheduler;

public class ZLBootStrap {

    private static final Logger logger = LoggerFactory.getLogger(ZLBootStrap.class);

    public static void main(String[] args) {
        try {
            PropertyConfigurator.configure("D:/log4j.properties");
            logger.info("init success");
            String starturl = "http://sou.zhaopin.com/jobs/searchresult.ashx";
            Site site = Site.me().setRetryTimes(2).setTimeOut(5000).setSleepTime(50);
            //            DuplicateRemovedScheduler sche = new QueueScheduler().setDuplicateRemover(new MapDbDuplicateRemover());
            OOSpider.create(site, new ZLPipline(), ZLJobInfo.class).addUrl(starturl).thread(2).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

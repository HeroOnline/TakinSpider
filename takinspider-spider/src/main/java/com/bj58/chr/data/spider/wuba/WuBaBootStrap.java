package com.bj58.chr.data.spider.wuba;

import org.apache.log4j.PropertyConfigurator;

import com.bj58.chr.data.spider.util.MapDbDuplicateRemover;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.scheduler.DuplicateRemovedScheduler;
import us.codecraft.webmagic.scheduler.QueueScheduler;

/**
 * 怎样实现这个功能：在抓取职位的同时，把企业对应的URL也抓取下来，并解析
 * 目前的实现是一个抓取只与一个结果对应，还是有点浪费资源的
 * @author WangYazhou
 * @date  2016年7月21日 上午11:50:47
 * @see
 */
public class WuBaBootStrap {

    public static void main(String[] args) {
        try {
            PropertyConfigurator.configure("D:/log4j.properties");
            Site site = Site.me().setRetryTimes(2).setTimeOut(5000).setSleepTime(500);
            DuplicateRemovedScheduler sche = new QueueScheduler().setDuplicateRemover(new MapDbDuplicateRemover());
            String starturl = "http://bj.58.com/huijiguwen/?PGTID=0d30364d-0000-150a-a29a-9145e60f8182&ClickID=2";
            //            String starturl = "http://jobs.51job.com/guangzhou/79841625.html?s=0";
            OOSpider.create(site, new WuBaPipline(), WuBaJobInfo.class).setScheduler(sche).addUrl(starturl).thread(2).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.bj58.chr.data.spider.wuyao;

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
public class Wu1BootStrap {

    public static void main(String[] args) {
        try {
            PropertyConfigurator.configure("D:/log4j.properties");
            Site site = Site.me().setRetryTimes(2).setTimeOut(5000).setSleepTime(500);
            //            DuplicateRemovedScheduler sche = new QueueScheduler().setDuplicateRemover(new MapDbDuplicateRemover());
            String starturl = "http://search.51job.com/kwd-wenyuan-all.html";
            //            String starturl = "http://jobs.51job.com/guangzhou/79841625.html?s=0";
            OOSpider.create(site, new Wu1Pipline(), Wu1JobInfo.class).addUrl(starturl).thread(2).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

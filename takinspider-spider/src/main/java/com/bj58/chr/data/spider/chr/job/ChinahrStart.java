package com.bj58.chr.data.spider.chr.job;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;

/**
 * Created by liyan23 on 2016/9/10.
 */
public class ChinahrStart {

    public static void main(String[] args) {
        // PropertyConfigurator.configure("D:/log4j.properties");
        String url = "http://www.chinahr.com/sou/";
        Site site = Site.me().setRetryTimes(2).setTimeOut(5000).setSleepTime(30);
        OOSpider.create(site, new DataPipeline(), JobInfo.class).addUrl(url).thread(50).run();
    }
}

package com.bj58.chr.data.spider.zhilian.jobmv;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bj58.chr.data.spider.util.StringUtil;
import com.bj58.chr.data.spider.zhilian.demo.ZLBootStrap;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;

public class MvZhilianStart {

    private static final Logger logger = LoggerFactory.getLogger(ZLBootStrap.class);

    public static void main(String[] args) {
        try {
            PropertyConfigurator.configure("D:/log4j.properties");
            logger.info("init success");
            String starturl = "http://sou.zhaopin.com/jobs/searchresult.ashx";
            Site site = Site.me().setRetryTimes(2).setTimeOut(5000).setSleepTime(1000);
            //            DuplicateRemovedScheduler  = new QueueScheduler().setDuplicateRemover(new MapDbDuplicateRemover());
            OOSpider.create(site, new MvZhilianPipline(), ZhiLianBean.class).addUrl(starturl).thread(1).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void http() {
        try {
            String uu = "http://localhost:800/bjobmv/jobImport?type=1&data=";
            //            String uu = "http://qy.chinahr.com/bjobmv/jobImport?type=1&data=";
            List<String> lines = Files.readLines(new File("D:/two.txt"), Charsets.UTF_8);
            for (String line : lines) {
                if (StringUtil.isNotNullOrEmpty(line)) {
                    String ss = DesUtil.encrypt(line.trim(), DesUtil.DES_KEY_STRING);
                    System.out.println(ss);
                    System.out.println(ss.length());
                    System.out.println(URLEncoder.encode(ss, "UTF-8"));
                    String u = uu + URLEncoder.encode(ss, "UTF-8");
                    System.out.println(u);
                    new HttpRequestor().doPost(u, "");
                }
            }
        } catch (Exception e) {

        }
    }
}

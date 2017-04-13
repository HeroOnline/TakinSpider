package com.bj58.chr.data.spider.zhilian.demo;

//package com.bj58.chr.data.spider.zhilian.job;
//
//import us.codecraft.webmagic.Page;
//import us.codecraft.webmagic.Site;
//import us.codecraft.webmagic.processor.PageProcessor;
//
//public class ZLPageProcessor implements PageProcessor {
//
//    @Override
//    public void process(Page page) {
//        //提取详情页
//        page.addTargetRequests(page.getHtml().links().regex("http://jobs\\.zhaopin\\.com/.*").all());
//
//        //提取详情页
//        page.putField("jobname", page.getHtml().xpath("//[@class='inner-left fl']/h1[1]/text()"));
//        page.putField("salary", page.getHtml().xpath("//[@class='terminal-ul clearfix']/li[1]/strong/text()"));
//        page.putField("local", page.getHtml().xpath("//[@class='terminal-ul clearfix']/li[2]/strong/a/text()"));
//        page.putField("pdate", page.getHtml().xpath("//[@class='terminal-ul clearfix']/li[3]/strong/span/text()"));
//        page.putField("desc", page.getHtml().xpath("//[@class='tab-inner-cont'][1]/*"));
//        page.putField("company", page.getHtml().xpath("//[@class='inner-left fl']/h2[1]/a/text()"));
//
//        //
//    }
//
//    @Override
//    public Site getSite() {
//        return site;
//    }
//
//    private Site site = Site.me().setTimeOut(2000).setRetryTimes(3).setSleepTime(1);
//
//}

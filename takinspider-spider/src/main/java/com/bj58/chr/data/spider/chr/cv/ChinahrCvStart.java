package com.bj58.chr.data.spider.chr.cv;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;

/**
 * Created by liyan23 on 2016/9/10.
 */
public class ChinahrCvStart {

    public static void main(String[] args) {
        Site site = Site.me().setRetryTimes(5).setTimeOut(5000).setSleepTime(30).setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.75 Safari/537.36");
        site.setDomain("qy.chinahr.com");
        Map<String, String> chinaHrCookMap = getChinaHrCookMap();
        for (Map.Entry<String, String> en : chinaHrCookMap.entrySet()) {
            site.addCookie(en.getKey(), en.getValue());
        }
        List<String> beginUrl = getBeginUrl();
        System.out.println("url 准备完毕,共:" + beginUrl.size());
        OOSpider.create(site, new CvDataPipeline(), CvBean.class).addUrl(beginUrl).thread(70).run();
    }

    private static List<String> getBeginUrl() {
        List<String> urls = Lists.newArrayList();
        String sourceUrl = "http://qy.chinahr.com/cv/sou?page=%d&live=%s";
        try {
            String citys = (String) FileUtils.readLines(new File("d:/city.js"), "utf-8").get(0);
            List<Map> cityIds = JSON.parseArray(citys, Map.class);
            for (int page = 1; page <= 2; page++) {
                for (Map<String, String> cityId : cityIds) {
                    String livingCityId = cityId.get("id");
                    urls.add(String.format(sourceUrl, page, livingCityId));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urls;
    }

    private static Map<String, String> getChinaHrCookMap() {
        Map<String, String> cookieMap = Maps.newHashMap();
        cookieMap.put("als", "0");
        cookieMap.put("pgv_pvi", "9547315698");
        cookieMap.put("s-u-v2", "1");
        cookieMap.put("chrId", "a2960b0563e041e7a1d79012f997ef55");
        cookieMap.put("__utma", "162484963.1723964967.1470023583.1472801269.1473219063.20");
        cookieMap.put("__utma", "162484963.1723964967.1470023583.1472801269.1473219063.20");
        cookieMap.put("__utmz", "162484963.1472020573.18.15.utmcsr=qy.chinahr.com|utmccn=(referral)|utmcmd=referral|utmcct=/bjobmanager/common/preview");
        cookieMap.put("live", "34,398");
        cookieMap.put("_blong", "1");
        cookieMap.put("_buname", "xinzhuce");
        cookieMap.put("PPS", "\"uid=fdf3ae8494d5cc5553eee91cj&lt=1476252645653&lts=89c5e0944ab3&st=1473678645653&sts=42c82f761969\"");
        cookieMap.put("loginTime", "1473660645");
        cookieMap.put("gtid", "a71d810e877f44dca83fbfaf18a5351e");
        cookieMap.put("RecentVisitCity", "398_beijing");
        cookieMap.put("RecentVisitCityFullpathPc", "34,398");
        cookieMap.put("bps", "\"buid=4241344544897&blt=156282153363&blts=a2cfee32a301598a5d6&bst=156267873363&bsts=23b162f63b1f6840363\"");
        cookieMap.put("58tj_uuid", "e7018049-7970-41bd-a4d6-9c276f226f65");
        cookieMap.put("new_session", "0");
        cookieMap.put("init_refer", "");
        cookieMap.put("new_uv", "77");
        return cookieMap;
    }
}

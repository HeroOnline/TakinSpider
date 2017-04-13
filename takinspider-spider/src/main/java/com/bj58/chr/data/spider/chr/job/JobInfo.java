package com.bj58.chr.data.spider.chr.job;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * Created by liyan23 on 2016/9/12.
 */
@TargetUrl("http://www.chinahr.com/job/\\d+.html")
public class JobInfo {

    @ExtractBy("/html/body/div[2]/div[2]/div[1]/div[1]/div[1]/h1/span")
    private String jobName;

    @ExtractBy("/html/body/div[2]/div[1]/div[1]/div[1]/div[2]/span[1]")
    private String price;

    @ExtractBy("/html/body/div[2]/div[2]/div[2]/div[3]/div")
    private String desc;

    @ExtractByUrl("http://www.chinahr.com/job/\\d+.html")
    private String joburl;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDesc() {
        //        if (StringUtils.isNotBlank(desc)) {
        //            desc = desc.replaceAll("<div .*?>", "");
        //            desc = desc.replaceAll("<!--.*?-->", "");
        //            desc = desc.replaceAll("<.*?p.*?>", "");
        //            desc = desc.replaceAll("<br />", "");
        //            desc = desc.replaceAll("</div>", "");
        //            desc = desc.replaceAll("\\n", "");
        //            desc = desc.replaceAll("<.*?h2.*?>", "");
        //            desc = desc.replaceAll("<.*?a.*?>", "");
        //            desc = desc.replaceAll("<.*?b.*?>", "");
        //        }
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getJoburl() {
        return joburl;
    }

    public void setJoburl(String joburl) {
        this.joburl = joburl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

package com.bj58.chr.data.spider.zhilian.demo;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("http://jobs.zhaopin.com/\\d+.htm")
@HelpUrl("http://sou.zhaopin.com/jobs/searchresult.ashx?.*")
public class ZLJobInfo {

    @ExtractBy("//div[@class='inner-left fl']/h1[1]/text()")
    private String jobname;

    @ExtractByUrl("http://jobs.zhaopin.com/\\d+.htm")
    private String joburl;

    @ExtractBy("//div[@class='inner-left fl']/h2[1]/a/text()")
    private String company;

    @ExtractBy("//ul[@class='terminal-ul clearfix']/li[1]/strong/text()")
    private String salary;

    @ExtractBy("//ul[@class='terminal-ul clearfix']/li[3]/strong/span/text()")
    private String postdate;

    @ExtractBy("//ul[@class='terminal-ul clearfix']/li[2]/strong/a/text()|//ul[@class='terminal-ul clearfix']/li[2]/strong/text()")
    private String local;

    @ExtractBy("//ul[@class='terminal-ul clearfix']/li[4]/strong/text()")
    private String worktype;

    @ExtractBy("//ul[@class='terminal-ul clearfix']/li[5]/strong/text()")
    private String workexp;

    @ExtractBy("//ul[@class='terminal-ul clearfix']/li[6]/strong/text()")
    private String degree;

    @ExtractBy("//ul[@class='terminal-ul clearfix']/li[7]/strong/text()")
    private String recuitnum;

    @ExtractBy("//ul[@class='terminal-ul clearfix']/li[8]/strong/*/text()")
    private String jobcate;

    @ExtractBy("//div[@class='welfare-tab-box']/span//text()")
    private String welfare;

    @ExtractBy("//div[@class='tab-inner-cont'][1]/*//text()|//div[@class='tab-inner-cont'][1]/div//text()")
    private String desc;

    @ExtractBy("//div[@class='tab-inner-cont'][1]/h2/text()")
    private String localdetail;

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

    public String getWorkexp() {
        return workexp;
    }

    public void setWorkexp(String workexp) {
        this.workexp = workexp;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getRecuitnum() {
        return recuitnum;
    }

    public void setRecuitnum(String recuitnum) {
        this.recuitnum = recuitnum;
    }

    public String getJobcate() {
        return jobcate;
    }

    public void setJobcate(String jobcate) {
        this.jobcate = jobcate;
    }

    public String getJoburl() {
        return joburl;
    }

    public void setJoburl(String joburl) {
        this.joburl = joburl;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocaldetail() {
        return localdetail;
    }

    public void setLocaldetail(String localdetail) {
        this.localdetail = localdetail;
    }

}

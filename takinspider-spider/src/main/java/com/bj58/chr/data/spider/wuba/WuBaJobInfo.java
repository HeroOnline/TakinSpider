package com.bj58.chr.data.spider.wuba;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

//@TargetUrl("http://jobs.51job.com/.*.html\\?")
@TargetUrl("http://bj.58.com/\\w+/\\d+x.shtml")
//@HelpUrl("http://search.51job.com/list/.*")
public class WuBaJobInfo {

    @ExtractBy("/html/body[@class='wbp-job-detail']/div[@class='wb-main']/div[@class='wb-content clearfix']/div[@class='wb-sidebar-left']/div[@class='wrap']/div[@class='posCont']/div[@class='headCon']/div[@class='headConLeft']/h1")
    private String jobname;

    @ExtractBy("/html/body[@class='wbp-job-detail']/div[@class='wb-main']/div[@class='wb-content clearfix']/div[@class='wb-sidebar-left']/div[@class='wrap']/div[@class='posCont']/div[@class='posSum']/div[@class='posSumLeft']/div[@class='company']/a[@class='companyName']")
    private String company;

    @ExtractBy("/html/body[@class='wbp-job-detail']/div[@class='wb-main']/div[@class='wb-content clearfix']/div[@class='wb-sidebar-left']/div[@class='wrap']/div[@class='posCont']/div[@class='posinfo']/div[@class='xq']/ul/li[@class='condition'][1]/div[@class='w380']/span[@class='salaNum']/strong")
    private String salary;

    @ExtractBy("/html/body[@class='wbp-job-detail']/div[@class='wb-main']/div[@class='wb-content clearfix']/div[@class='wb-sidebar-left']/div[@class='wrap']/div[@class='posCont']/div[@class='headCon']/div[@class='headConLeft']/ul[@class='headTag']/li[1]/span")
    private String postdate;

    @ExtractBy("/html/body[@class='wbp-job-detail']/div[@class='wb-main']/div[@class='wb-content clearfix']/div[@class='wb-sidebar-left']/div[@class='wrap']/div[@class='posCont']/div[@class='posinfo']/div[@class='xq']/ul/li[@class='condition'][3]/span[2]")
    private String local;

    //    @ExtractBy("//ul[@class='terminal-ul clearfix']/li[4]/strong/text()")
    //    private String worktype;

    @ExtractBy("/html/body[@class='wbp-job-detail']/div[@class='wb-main']/div[@class='wb-content clearfix']/div[@class='wb-sidebar-left']/div[@class='wrap']/div[@class='posCont']/div[@class='posinfo']/div[@class='xq']/ul/li[@class='condition'][2]/div[@class='fl']")
    private String workexp;

    @ExtractBy("/html/body[@class='wbp-job-detail']/div[@class='wb-main']/div[@class='wb-content clearfix']/div[@class='wb-sidebar-left']/div[@class='wrap']/div[@class='posCont']/div[@class='posinfo']/div[@class='xq']/ul/li[@class='condition'][1]/div[@class='fl']")
    private String degree;

    @ExtractBy("/html/body[@class='wbp-job-detail']/div[@class='wb-main']/div[@class='wb-content clearfix']/div[@class='wb-sidebar-left']/div[@class='wrap']/div[@class='posCont']/div[@class='posinfo']/div[@class='xq']/ul/li[@class='condition'][2]/div[@class='w380']")
    private String recuitnum;

    @ExtractBy("/html/body[@class='wbp-job-detail']/div[@class='wb-main']/div[@class='wb-content clearfix']/div[@class='wb-sidebar-left']/div[@class='wrap']/div[@class='posCont']/div[@class='posSum']/div[@class='posSumLeft']/div[@class='compMsg clearfix']/ul/li[1]/a")
    private String jobcate;

    @ExtractBy("/html/body[@class='wbp-job-detail']/div[@class='wb-main']/div[@class='wb-content clearfix']/div[@class='wb-sidebar-left']/div[@class='wrap']/div[@class='posCont']")
    private String desc;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}

package com.bj58.chr.data.spider.lagou;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("http://www.lagou.com/jobs/.*.html")
//@HelpUrl("http://search.51job.com/list/.*")
public class LaGouJobInfo {

    @ExtractBy("/html/body/div[@id='container']/div[@class='content_l fl']/dl[@id='job_detail']/dt[@class='clearfix join_tc_icon']/h1")
    private String jobname;

    @ExtractBy("/html/body/div[@id='container']/div[@class='content_l fl']/dl[@id='job_detail']/dt[@class='clearfix join_tc_icon']/h1/div")
    private String company;

    @ExtractBy("/html/body/div[@id='container']/div[@class='content_l fl']/dl[@id='job_detail']/dd[@class='job_request']/p[1]/span[@class='red']")
    private String salary;

    @ExtractBy("/html/body/div[@id='container']/div[@class='content_l fl']/dl[@id='job_detail']/dd[@class='job_request']/p[@class='publish_time']")
    private String postdate;

    @ExtractBy("/html/body/div[@id='container']/div[@class='content_l fl']/dl[@id='job_detail']/dd[@class='job_request']/p[1]/span[2]")
    private String local;

    //    @ExtractBy("//ul[@class='terminal-ul clearfix']/li[4]/strong/text()")
    //    private String worktype;

    @ExtractBy("/html/body/div[@id='container']/div[@class='content_l fl']/dl[@id='job_detail']/dd[@class='job_request']/p[1]/span[3]")
    private String workexp;

    @ExtractBy("/html/body/div[@id='container']/div[@class='content_l fl']/dl[@id='job_detail']/dd[@class='job_request']/p[1]/span[4]")
    private String degree;

    @ExtractBy("/html/body/div[@id='container']/div[@class='content_r']/dl[@class='job_company']/dd/ul[@class='c_feature'][1]/li[1]")
    private String jobcate;

    @ExtractBy("/html/body/div[@id='container']/div[@class='content_l fl']/dl[@id='job_detail']/dd[@class='job_request']/p[2]")
    private String welfare;

    @ExtractBy("/html/body/div[@id='container']/div[@class='content_l fl']/dl[@id='job_detail']/dd[@class='job_bt']")
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

    public String getJobcate() {
        return jobcate;
    }

    public void setJobcate(String jobcate) {
        this.jobcate = jobcate;
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

}

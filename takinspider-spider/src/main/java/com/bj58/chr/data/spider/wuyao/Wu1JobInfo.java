package com.bj58.chr.data.spider.wuyao;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

//@TargetUrl("http://jobs.51job.com/.*.html\\?")
@TargetUrl("http://jobs.51job.com/.*.html")
//@HelpUrl("http://search.51job.com/list/.*")
public class Wu1JobInfo {

    @ExtractBy("/html/body/div[@class='tCompanyPage']/div[@class='tCompany_center clearfix']/div[@class='tHeader tHjob']/div[@class='in']/div[@class='cn']/h1")
    private String jobname;

    @ExtractBy("/html/body/div[@class='tCompanyPage']/div[@class='tCompany_center clearfix']/div[@class='tHeader tHjob']/div[@class='in']/div[@class='cn']/p[@class='cname']/a")
    private String company;

    @ExtractBy("/html/body/div[@class='tCompanyPage']/div[@class='tCompany_center clearfix']/div[@class='tHeader tHjob']/div[@class='in']/div[@class='cn']/strong")
    private String salary;

    @ExtractBy("/html/body/div[@class='tCompanyPage']/div[@class='tCompany_center clearfix']/div[@class='tCompany_main']/div[@class='tBorderTop_box bt']/div[@class='jtag inbox']/div[@class='t1']/span[@class='sp4'][4]")
    private String postdate;

    @ExtractBy("/html/body/div[@class='tCompanyPage']/div[@class='tCompany_center clearfix']/div[@class='tHeader tHjob']/div[@class='in']/div[@class='cn']/span[@class='lname']")
    private String local;

    //    @ExtractBy("//ul[@class='terminal-ul clearfix']/li[4]/strong/text()")
    //    private String worktype;

    @ExtractBy("/html/body/div[@class='tCompanyPage']/div[@class='tCompany_center clearfix']/div[@class='tCompany_main']/div[@class='tBorderTop_box bt']/div[@class='jtag inbox']/div[@class='t1']/span[@class='sp4'][1]")
    private String workexp;

    @ExtractBy("/html/body/div[@class='tCompanyPage']/div[@class='tCompany_center clearfix']/div[@class='tCompany_main']/div[@class='tBorderTop_box bt']/div[@class='jtag inbox']/div[@class='t1']/span[@class='sp4'][2]")
    private String degree;

    @ExtractBy("/html/body/div[@class='tCompanyPage']/div[@class='tCompany_center clearfix']/div[@class='tCompany_main']/div[@class='tBorderTop_box bt']/div[@class='jtag inbox']/div[@class='t1']/span[@class='sp4'][3]")
    private String recuitnum;

    @ExtractBy("/html/body/div[@class='tCompanyPage']/div[@class='tCompany_center clearfix']/div[@class='tHeader tHjob']/div[@class='in']/div[@class='cn']/p[@class='msg ltype']")
    private String jobcate;

    @ExtractBy("/html/body/div[@class='tCompanyPage']/div[@class='tCompany_center clearfix']/div[@class='tCompany_main']/div[@class='tBorderTop_box bt']/div[@class='jtag inbox']/p[@class='t2']")
    private String welfare;

    @ExtractBy("/html/body/div[@class='tCompanyPage']/div[@class='tCompany_center clearfix']/div[@class='tCompany_main']/div[@class='tBorderTop_box'][1]/div[@class='bmsg job_msg inbox']")
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

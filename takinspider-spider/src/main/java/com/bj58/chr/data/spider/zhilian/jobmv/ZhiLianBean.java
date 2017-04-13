package com.bj58.chr.data.spider.zhilian.jobmv;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("http://jobs.zhaopin.com/\\d+.htm")
@HelpUrl("http://sou.zhaopin.com/jobs/searchresult.ashx?.*")
public class ZhiLianBean {
    //企业
    private String cuuid;
    private String qdComId;
    
    @ExtractBy("/html/body/div[@class='top-fixed-box']/div[@class='fixed-inner-box']/div[@class='fl']/h2/a/text()")
    private String cname;

    @ExtractBy("/html/body/div[@class='terminalpage clearfix']/div[@class='terminalpage-right']/div[@class='company-box']/ul[@class='terminal-ul clearfix terminal-company mt20']/li[1]/strong/text()")
    private String size;

    @ExtractBy("/html/body/div[@class='terminalpage clearfix']/div[@class='terminalpage-right']/div[@class='company-box']/ul[@class='terminal-ul clearfix terminal-company mt20']/li[2]/strong/text()")
    private String nature;

    @ExtractBy("/html/body/div[@class='terminalpage clearfix']/div[@class='terminalpage-right']/div[@class='company-box']/ul[@class='terminal-ul clearfix terminal-company mt20']/li[3]/strong/a/text()")
    private String industry;

    @ExtractBy("/html/body/div[@class='terminalpage clearfix']/div[@class='terminalpage-right']/div[@class='company-box']/ul[@class='terminal-ul clearfix terminal-company mt20']/li[4]/strong/a/@href")
    private String website;

    @ExtractBy("/html/body/div[@class='terminalpage clearfix']/div[@class='terminalpage-right']/div[@class='company-box']/ul[@class='terminal-ul clearfix terminal-company mt20']/li[4]/strong/text()")
    private String address;

    //    @ExtractBy("/html/body/div[@class='terminalpage clearfix']/div[@class='terminalpage-left']/div[@class='terminalpage-main clearfix']/div[@class='tab-cont-box']/div[@class='tab-inner-cont'][2]/div[2]")
    private String introduce;

    @ExtractBy("/html/body/div[@class='top-fixed-box']/div[@class='fixed-inner-box']/div[@class='fl']/h2/a/@href")
    private String comUrl;

    //职位
    private String juuid;
    private String qdJobId;

    @ExtractBy("/html/body/div[@class='top-fixed-box']/div[@class='fixed-inner-box']/div[@class='inner-left fl']/h1/text()")
    private String jname;
    private String companyname;

    @ExtractBy("/html/body/div[@class='terminalpage clearfix']/div[@class='terminalpage-left']/ul[@class='terminal-ul clearfix']/li[1]/strong/text()")
    private String salary;

    @ExtractBy("/html/body/div[@class='terminalpage clearfix']/div[@class='terminalpage-left']/ul[@class='terminal-ul clearfix']/li[2]/strong/text()")
    private String workplace;

    @ExtractBy("/html/body/div[@class='terminalpage clearfix']/div[@class='terminalpage-left']/ul[@class='terminal-ul clearfix']/li[3]/strong/span[@id='span4freshdate']")
    private String publishdate;

    @ExtractBy("/html/body/div[@class='terminalpage clearfix']/div[@class='terminalpage-left']/ul[@class='terminal-ul clearfix']/li[4]/strong/text()")
    private String workproperty;//工作性质

    @ExtractBy("/html/body/div[@class='terminalpage clearfix']/div[@class='terminalpage-left']/ul[@class='terminal-ul clearfix']/li[5]/strong/text()")
    private String experience;

    @ExtractBy("/html/body/div[@class='terminalpage clearfix']/div[@class='terminalpage-left']/ul[@class='terminal-ul clearfix']/li[6]/strong/text()")
    private String education;

    @ExtractBy("/html/body/div[@class='terminalpage clearfix']/div[@class='terminalpage-left']/ul[@class='terminal-ul clearfix']/li[7]/strong/text()")
    private String qty;//招聘人数

    @ExtractBy("/html/body/div[@class='terminalpage clearfix']/div[@class='terminalpage-left']/ul[@class='terminal-ul clearfix']/li[8]/strong/a/text()")
    private String category;
    //    @ExtractBy("/html/body/div[@class='terminalpage clearfix']/div[@class='terminalpage-left']/div[@class='terminalpage-main clearfix']/div[@class='tab-cont-box']/div[@class='tab-inner-cont'][1]/div/p")
    private String descrip;

    @ExtractBy("/html/body/div[@class='top-fixed-box'][1]/div[@class='fixed-inner-box']/div[@class='inner-left fl']/div[@class='welfare-tab-box']/span")
    private String welfare;

    private String age;
    private String languge;

    @ExtractByUrl("http://jobs.zhaopin.com/\\d+.htm")
    private String jobUrl;

    //其它
    private String department;
    private String professional;
    private String reportto;
    private String member;
    private String source = "1";

    public String getCuuid() {
        return cuuid;
    }

    public void setCuuid(String cuuid) {
        this.cuuid = cuuid;
    }

    public String getQdComId() {
        return qdComId;
    }

    public void setQdComId(String qdComId) {
        this.qdComId = qdComId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getComUrl() {
        return comUrl;
    }

    public void setComUrl(String comUrl) {
        this.comUrl = comUrl;
    }

    public String getJuuid() {
        return juuid;
    }

    public void setJuuid(String juuid) {
        this.juuid = juuid;
    }

    public String getQdJobId() {
        return qdJobId;
    }

    public void setQdJobId(String qdJobId) {
        this.qdJobId = qdJobId;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    public String getWorkproperty() {
        return workproperty;
    }

    public void setWorkproperty(String workproperty) {
        this.workproperty = workproperty;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLanguge() {
        return languge;
    }

    public void setLanguge(String languge) {
        this.languge = languge;
    }

    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getReportto() {
        return reportto;
    }

    public void setReportto(String reportto) {
        this.reportto = reportto;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}

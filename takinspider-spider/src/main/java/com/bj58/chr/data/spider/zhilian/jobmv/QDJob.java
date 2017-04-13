package com.bj58.chr.data.spider.zhilian.jobmv;

public class QDJob {
    private String uuid;
    private String qdJobId;
    private String name;
    private String companyname;
    private String salary;
    private String workplace;
    private String publishdate;
    private String workproperty;
    private String experience;
    private String education;
    private String qty;
    private String category;
    private String descrip;
    private String welfare;
    private String age;
    private String languge;
    private String jobUrl;

    @Override
    public String toString() {
        return "QDJob [qdJobId=" + qdJobId + ", name=" + name + ", companyname=" + companyname + ", salary=" + salary + ", workplace=" + workplace + ", publishdate=" + publishdate + ", workproperty=" + workproperty + ", experience=" + experience + ", education=" + education + ", qty=" + qty + ", category=" + category + ", welfare=" + welfare + ", age=" + age + ", languge=" + languge + ", jobUrl=" + jobUrl + "]";
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getQdJobId() {
        return qdJobId;
    }

    public void setQdJobId(String qdJobId) {
        this.qdJobId = qdJobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}

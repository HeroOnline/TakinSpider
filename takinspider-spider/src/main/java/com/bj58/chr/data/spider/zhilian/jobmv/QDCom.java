package com.bj58.chr.data.spider.zhilian.jobmv;

public class QDCom {

    private String uuid;
    private String qdComId;
    private String name;
    private String size;
    private String nature;
    private String industry;
    private String website;
    private String address;
    private String introduce;
    private String comUrl;

    @Override
    public String toString() {
        return "QDCom [uuid=" + uuid + ", qdComId=" + qdComId + ", name=" + name + ", size=" + size + ", nature=" + nature + ", industry=" + industry + ", website=" + website + ", address=" + address + ", comUrl=" + comUrl + "]";
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getQdComId() {
        return qdComId;
    }

    public void setQdComId(String qdComId) {
        this.qdComId = qdComId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}

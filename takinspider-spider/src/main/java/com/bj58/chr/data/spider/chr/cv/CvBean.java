package com.bj58.chr.data.spider.chr.cv;

import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * Created by liyan23 on 2016/9/12.
 */
@TargetUrl("http://qy.chinahr.com/cvm/preview\\?cvid=*.*")
public class CvBean {

    @ExtractBy("/html/body/div[1]/div[2]/div[1]/div[2]/div[2]/h3")
    private String cvName;

    @ExtractBy("/html/body/div[1]/div[1]/div[2]")
    private String cvid;

    @ExtractBy("/html/body/div[1]/div[2]/div[3]/div[2]")
    private String infowork;

    @ExtractBy("/html/body/div[1]/div[2]/div[2]/div/div[1]/ul/li[1]/div/p[1]/em[1]")
    private String sex;
    @ExtractBy("/html/body/div[1]/div[2]/div[2]/div/div[1]/ul/li[1]/div/p[1]/em[2]")
    private String age;

    public String getCvName() {
        if (StringUtils.isNoneBlank(cvName)) {
            cvName = cvName.replaceAll("<h3>", "");
            cvName = cvName.replaceAll("</h3>", "");
        }
        return cvName;
    }

    public void setCvName(String cvName) {
        this.cvName = cvName;
    }

    public String getCvid() {
        if (StringUtils.isNoneBlank(cvid)) {
            cvid = cvid.replaceAll("<div class=\\\"*.*\\\">\\n", "");
            cvid = cvid.replaceAll("\\n</div>", "");
        }
        return cvid;
    }

    public void setCvid(String cvid) {
        this.cvid = cvid;
    }

    public String getInfowork() {
        if (StringUtils.isNoneBlank(infowork)) {
            infowork = infowork.replaceAll("<div class=\\\"*.*\\\">", "");
            infowork = infowork.replaceAll("</span>", "");
            infowork = infowork.replaceAll("</div>", "");
            infowork = infowork.replaceAll("\\n", "");
            infowork = infowork.replaceAll("</*>", "");
            infowork = infowork.replaceAll("<*>", "");
            infowork = infowork.replaceAll("<i class=\\\"*.*\\\">", "");
            infowork = infowork.replaceAll("<i class=\\\"m-icon i-minCir\\\"</i", "");
            infowork = infowork.replaceAll("<h3", "");
            infowork = infowork.replaceAll("</h3", "");
        }
        return infowork;
    }

    public void setInfowork(String infowork) {
        this.infowork = infowork;
    }

    public String getSex() {
        if (StringUtils.isNoneBlank(sex)) {
            sex = sex.replaceAll("<em>", "");
            sex = sex.replaceAll("</em>", "");
        }
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        if (StringUtils.isNoneBlank(age)) {
            age = age.replaceAll("<em>", "");
            age = age.replaceAll("</em>", "");
        }
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

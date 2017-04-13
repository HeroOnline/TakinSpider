//package com.chr.data.spider.test.csdn;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.alibaba.fastjson.JSON;
//
//import us.codecraft.chr.Edu;
//import us.codecraft.chr.Exp;
//import us.codecraft.chr.UserBean;
//
//public class CSDNWebdriver {
//
//    //chrome获取cookie
//    @Test
//    public void chromelogin() {
//        try {
//            System.getProperties().setProperty("webdriver.chrome.driver", "D:\\spider\\chromedriver_x64.exe");
//            WebDriver driver = new ChromeDriver(); //调用火狐浏览器
//            driver.get("https://passport.csdn.net/"); //打开url
//            //            driver.findElement(By.id("username")).clear(); //获取id值 
//            //            driver.findElement(By.id("username")).sendKeys("asivy"); //写入用户名
//            //            driver.findElement(By.id("password")).clear();
//            //            driver.findElement(By.id("password")).sendKeys("asia555");
//            //            driver.findElement(By.className("logging")).click();
//            opennewwindow(driver, "jiangqq781931404");
//            //            opennewwindow(driver, "asivy");
//            //            opennewwindow(driver, "mindfloating");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void opennewwindow(WebDriver driver, String name) {
//        try {
//            driver.findElement(By.xpath("//body")).sendKeys(Keys.CONTROL + "t");
//            String current = driver.getWindowHandle();
//            String handle = "";
//            for (String handles : driver.getWindowHandles()) {
//                if (handles.equals(current))
//                    continue;
//                handle = handles;
//            }
//            driver.switchTo().window(handle);
//            driverone(driver, name);
//            driver.switchTo().window(current);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void driverone(final WebDriver driver, String name) {
//        try {
//            driver.get("http://my.csdn.net/" + name);
//            Thread.sleep(10000);
//            UserBean user = new UserBean();
//            WebElement username = meBy(driver, By.xpath("//dt[@class='person-nick-name']"));
//            user.setUsername(username.getText());
//            user.setHomepage("http://my.csdn.net/" + name);
//            WebElement detail = meBy(driver, By.xpath("//dd[@class='person-detail']"));
//            System.out.println(detail.getText());
//            String[] details = detail.getText().split("\\|");
//            user.setUsername(details[2]);
//            user.setLocal(details[3]);
//            user.setSex(details[4]);
//            user.setBirthday(details[5]);
//
//            WebElement sign = meBy(driver, By.xpath("//dd[@class='person-sign']"));
//            user.setSign(sign.getText());
//            WebElement email = meBy(driver, By.xpath("//span[@class='email']"));
//            if (email != null)
//                user.setEmail(email.getText());
//            WebElement mobile = meBy(driver, By.xpath("//span[@class='modile' or @class='mobile']"));
//            if (mobile != null)
//                user.setMobile(mobile.getText());
//            WebElement qq = meBy(driver, By.xpath("//span[@class='qq']"));
//            if (qq != null)
//                user.setQq(qq.getText());
//            WebElement weixin = meBy(driver, By.xpath("//span[@class='weixin']"));
//            if (weixin != null)
//                user.setWechat(weixin.getText());
//            List<WebElement> works = msBy(driver, By.xpath("//div[@class='job_list clearfix first_list ' or @class='job_list clearfix  ']"));
//            if (works != null) {
//                List<Exp> exps = new ArrayList<Exp>();
//                for (WebElement wk : works) {
//                    Exp exp = new Exp();
//                    WebElement timerange = wk.findElement(By.xpath("div[@class='time-range']"));
//                    String[] values = timerange.getText().split("\n");
//                    if (values.length == 2) {
//                        exp.setStartDate(values[0]);
//                        exp.setEndDate(values[1]);
//                    }
//                    WebElement job = wk.findElement(By.xpath("dl/dt/span"));
//                    exp.setJobname(job.getText());
//                    WebElement com = wk.findElement(By.xpath("dl/dd/span"));
//                    exp.setCompany(com.getText());
//                    WebElement duby = wk.findElement(By.xpath("dl/dd[@class='major-detail']"));
//                    exp.setDuty(duby.getText());
//                    exps.add(exp);
//                }
//                user.setWorkexps(exps);
//            }
//            List<WebElement> edus = msBy(driver, By.xpath("//div[@class='education_list clearfix  '  or @class='education_list clearfix first_list ']"));
//            if (edus != null) {
//                List<Edu> edulist = new ArrayList<Edu>();
//                for (WebElement wk : works) {
//                    Edu edu = new Edu();
//                    WebElement timerange = wk.findElement(By.xpath("div[@class='time-range']"));
//                    String[] values = timerange.getText().split("\n");
//                    if (values.length == 2) {
//                        edu.setStartDate(values[0]);
//                        edu.setEndDate(values[1]);
//                    }
//                    WebElement major = wk.findElement(By.xpath("dl/dt/span"));
//                    edu.setMajor(major.getText());
//                    WebElement col = wk.findElement(By.xpath("dl/dd/span"));
//                    edu.setCollage(col.getText());
//                    WebElement degree = wk.findElement(By.xpath("dl/dd/b"));
//                    edu.setDegree(degree.getText());
//                    edulist.add(edu);
//                }
//                user.setEducations(edulist);
//            }
//
//            System.out.println(JSON.toJSONString(user));
//
//            //            driver.close();//关闭此标签页
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("well job");
//    }
//
//    private WebElement meBy(WebDriver driver, By path) {
//        try {
//            WebElement ele = driver.findElement(path);
//            return ele;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private List<WebElement> msBy(WebDriver driver, By path) {
//        try {
//            List<WebElement> eles = driver.findElements(path);
//            return eles;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//}

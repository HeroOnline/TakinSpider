package com.bj58.chr.data.spider.chr.cv;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 带验证码的登录  应该怎么做
 * 
 * 
 * @author wangyazhou
 * @version 1.0
 * @date  2016年2月24日 上午10:53:04
 * @see   
 * @since 
 */
public class ChrLogin {

    public static void main(String[] args) {
        //        new ChrLogin().login();
    }

    private static final String captcha = "D:/spdier/chrlongin.jpeg";

    public void login() {
        try {
            System.getProperties().setProperty("webdriver.chrome.driver", "D:\\spider\\chromedriver_x64.exe");

            WebDriver driver = new ChromeDriver(); //调用火狐浏览器

            driver.get("http://qy.chinahr.com/buser/login"); //打开url

            driver.findElement(By.id("account")).clear(); //获取id值 
            driver.findElement(By.id("account")).sendKeys("zoutest01"); //写入用户名
            driver.findElement(By.id("secretPWD")).clear();
            driver.findElement(By.id("secretPWD")).sendKeys("zoutest01");
            WebElement img = driver.findElement(By.xpath("//img[@class='codeImg']"));
            downloadnewcaptcha(img, captcha);
            String captchavalue = "";//readcaptcha();
            driver.findElement(By.id("com_img")).clear();
            driver.findElement(By.id("com_img")).sendKeys(captchavalue);
            driver.findElement(By.className("normalLogin")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //对图片进行下载，这样会导致浏览器中看到的验证码跟下载的不一样
    public void downloadnewcaptcha(WebElement element, String path) {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            String imgurl = element.getAttribute("src");
            String imgfile = path;

            //这里通过httpclient下载之前抓取到的图片网址，并放在对应的文件中
            HttpGet httpget = new HttpGet(imgurl);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            InputStream in = entity.getContent();

            File file = new File(imgfile);
            if (file.exists()) {
                file.delete();
            }
            try {
                FileOutputStream fout = new FileOutputStream(file);
                int l = -1;
                byte[] tmp = new byte[1024];
                while ((l = in.read(tmp)) != -1) {
                    fout.write(tmp, 0, l);
                }
                fout.flush();
                fout.close();
            } finally {
                in.close();
            }
            httpclient.close();
            System.out.println("down img success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //对图片进行截图
    public static void screenShotForElement(WebDriver driver, WebElement element, String path) throws InterruptedException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Point p = element.getLocation();
            int width = element.getSize().getWidth();
            int height = element.getSize().getHeight();
            Rectangle rect = new Rectangle(width, height);
            BufferedImage img = ImageIO.read(scrFile);
            BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
            ImageIO.write(dest, "png", scrFile);
            Thread.sleep(1000);
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

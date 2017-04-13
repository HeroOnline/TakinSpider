//package com.chr.data.spider.test.csdn;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.httpclient.methods.StringRequestEntity;
//import org.apache.commons.httpclient.params.HttpMethodParams;
//import org.apache.http.HttpStatus;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Cookie;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.google.common.base.Charsets;
//import com.google.common.io.Files;
//
//import us.codecraft.chr.StringUtil;
//
//public class CSDN2 {
//
//    public static final File cookiefile = new File("D:/spider/asivycookie.txt");
//    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ms:ss");
//
//    @Test
//    public void personinfo() {
//        HttpClient client = new HttpClient();
//        PostMethod method = new PostMethod("http://my.csdn.net/service/main/uc");
//        System.out.println("------------------------------------------------------------------");
//        try {
//            List<String> cookies = Files.readLines(cookiefile, Charsets.UTF_8);
//            for (String cies : cookies) {
//                if (StringUtil.isNullOrEmpty(cies)) {
//                    continue;
//                }
//                JSONObject json = JSON.parseObject(cies);
//                org.apache.commons.httpclient.Cookie cook = new org.apache.commons.httpclient.Cookie();
//                cook.setDomain(json.getString("domain"));
//                Date exp = StringUtil.isNotNullOrEmpty(json.getString("expiryDate")) ? new Date(Long.parseLong(json.getString("expiryDate"))) : null;
//                cook.setExpiryDate(exp);
//                cook.setName(json.getString("name"));
//                cook.setPath(json.getString("path"));
//                cook.setValue(json.getString("value"));
//                //                cook.setVersion(json.getInteger("version"));
//                cook.setSecure(json.getBooleanValue("secure"));
//                client.getState().addCookie(cook);
//                System.out.println(String.format("%s=%s;%s;%s;%s;", cook.getName(), cook.getValue(), cook.getExpiryDate() != null ? sdf.format(cook.getExpiryDate()) : "无", cook.getDomain(), cook.getPath()));
//            }
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//        //Accept-Encoding: gzip, deflate
//        method.addRequestHeader("Accept", "application/json, text/javascript, */*; q=0.01");
//        method.addRequestHeader("Accept-Encoding", "gzip, deflate");
//        method.addRequestHeader("Accept-Language", "zh-CN,zh;q=0.8");
//        method.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.157 UBrowser/5.5.10106.5 Safari/537.36");
//        method.addRequestHeader("X-Requested-With", "XMLHttpRequest");
//        method.addRequestHeader("Content-Length", "75");
//        method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//        //        method.addRequestHeader("Referer", "http://my.csdn.net/asivy");
//        method.addRequestHeader("Origin", "http://my.csdn.net");
//        method.addRequestHeader("Connection", "keep-alive");
//        method.addRequestHeader("Host", "my.csdn.net");
//
//        // 
//        String param = "{\"method\":\"getContact\",\"username\":\"asivy\"}";
//        //        method.setRequestBody(param);
//        client.getHttpConnectionManager().getParams().setConnectionTimeout(50000);// 设置连接时间
//        client.getHttpConnectionManager().getParams().setSoTimeout(10000);
//        try {
//            StringRequestEntity requestEntity = new StringRequestEntity(param, "application/json", "UTF-8");
//
//            method.setRequestEntity(requestEntity);
//            String response = "";
//            int status = client.executeMethod(method);
//            System.out.println(method.getResponseBodyAsString());
//
//            if (status == HttpStatus.SC_OK) {
//                InputStream inputStream = method.getResponseBodyAsStream();
//                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//                StringBuffer stringBuffer = new StringBuffer();
//                String str = "";
//                while ((str = br.readLine()) != null) {
//                    stringBuffer.append(str);
//                }
//                response = stringBuffer.toString();
//            } else {
//                response = "fail";
//            }
//            System.out.println(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//    }
//
//    @Test
//    public void ajaxconect() {
//        HttpClient client = new HttpClient();
//        PostMethod method = new PostMethod("http://my.csdn.net/service/main/uc");
//        HttpMethodParams p = new HttpMethodParams();
//        System.out.println("------------------------------------------------------------------");
//
//        try {
//            List<String> cookies = Files.readLines(cookiefile, Charsets.UTF_8);
//            for (String cies : cookies) {
//                if (StringUtil.isNullOrEmpty(cies)) {
//                    continue;
//                }
//                JSONObject json = JSON.parseObject(cies);
//                org.apache.commons.httpclient.Cookie cook = new org.apache.commons.httpclient.Cookie();
//                cook.setDomain(json.getString("domain"));
//                Date exp = StringUtil.isNotNullOrEmpty(json.getString("expiryDate")) ? new Date(Long.parseLong(json.getString("expiryDate"))) : null;
//                cook.setExpiryDate(exp);
//                cook.setName(json.getString("name"));
//                cook.setPath(json.getString("path"));
//                cook.setValue(json.getString("value"));
//                //                cook.setVersion(json.getInteger("version"));
//                cook.setSecure(json.getBooleanValue("secure"));
//                client.getState().addCookie(cook);
//                System.out.println(String.format("%s=%s;%s;%s;%s;", cook.getName(), cook.getValue(), cook.getExpiryDate() != null ? sdf.format(cook.getExpiryDate()) : "无", cook.getDomain(), cook.getPath()));
//            }
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//
//        JSONObject json = new JSONObject();
//        json.put("method", "getWorkExp");
//        json.put("username", "asivy");
//        //        NameValuePair[] param = { new NameValuePair("method", "getWorkExp"), new NameValuePair("username", "asivy") };
//        NameValuePair[] param = { new NameValuePair("params", json.toJSONString()) };
//
//        method.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.82 Safari/537.36");
//        method.addRequestHeader("Connection", "keep-alive");
//        method.addRequestHeader("Content-Encoding", "gzip, deflate");
//        method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//        method.addRequestHeader("Date", new Date().toString());
//        method.addRequestHeader("Host", "my.csdn.net");
//        method.addRequestHeader("Keep-Alive", "timeout=20");
//        method.addRequestHeader("Server", "openresty");
//        //        method.addRequestHeader("Transfer-Encoding", "chunked");
//        method.addRequestHeader("Vary", "Accept-Encoding");
//        method.addRequestHeader("Origin", "http://my.csdn.net");
//        method.addRequestHeader("Accept", "application/json, text/javascript, */*; q=0.01");
//        method.addRequestHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
//        //        method.addRequestHeader("Content-Length", "75");
//        method.setParams(p);
//        method.setRequestBody(param);
//        client.getHttpConnectionManager().getParams().setConnectionTimeout(50000);// 设置连接时间
//        client.getHttpConnectionManager().getParams().setSoTimeout(2000);
//        client.getHttpConnectionManager().getParams().setTcpNoDelay(false);
//        String response = "";
//        try {
//            int status = client.executeMethod(method);
//            System.out.println(method.getResponseBodyAsString());
//            if (status == HttpStatus.SC_OK) {
//                InputStream inputStream = method.getResponseBodyAsStream();
//                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//                StringBuffer stringBuffer = new StringBuffer();
//                String str = "";
//                while ((str = br.readLine()) != null) {
//                    stringBuffer.append(str);
//                }
//                response = stringBuffer.toString();
//            } else {
//                response = "fail";
//            }
//            System.out.println(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//    }
//
//    @Test
//    public void loginchrome() {
//        System.getProperties().setProperty("webdriver.chrome.driver", "D:\\spider\\chromedriver_x64.exe");
//
//        WebDriver driver = new ChromeDriver(); //调用火狐浏览器
//        //        WebDriver driver = new FirefoxDriver(); //调用火狐浏览器
//
//        driver.get("https://passport.csdn.net/"); //打开url
//
//        driver.findElement(By.id("username")).clear(); //获取id值 
//        driver.findElement(By.id("username")).sendKeys("asivy"); //写入用户名
//        driver.findElement(By.id("password")).clear();
//        driver.findElement(By.id("password")).sendKeys("asia555");
//        driver.findElement(By.className("logging")).click();
//
//        //        driver.get("http://my.csdn.net/asivy");
//        WebDriver.Options manager = driver.manage();
//
//        Set<Cookie> cookies = manager.getCookies();
//
//        try {
//            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
//            String handle = driver.getWindowHandle();
//            for (String handles : driver.getWindowHandles()) {
//                if (handles.equals(handle))
//                    continue;
//                driver.switchTo().window(handles);
//                System.out.println("---" + driver.getTitle());
//            }
//
//            driver.get("http://my.csdn.net/asivy");
//
//            Files.write("", cookiefile, Charsets.UTF_8);
//            for (Cookie co : cookies) {
//                org.apache.commons.httpclient.Cookie cook = new org.apache.commons.httpclient.Cookie();
//                if (co.getDomain().contains("csdn")) {
//                    cook.setDomain(co.getDomain());
//                    cook.setExpiryDate(co.getExpiry());
//                    cook.setName(co.getName());
//                    cook.setPath(co.getPath());
//                    cook.setValue(co.getValue());
//                    cook.setSecure(co.isSecure());
//                    Files.append(JSON.toJSONString(cook) + "\n", cookiefile, Charsets.UTF_8);
//                    System.out.println(String.format("%s=%s;%s;%s;%s;", co.getName(), co.getValue(), co.getExpiry() != null ? sdf.format(co.getExpiry()) : "-", co.getDomain(), co.getPath(), co.isSecure()));
//                }
//            }
//            System.out.println("write cookie to file success\n");
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}

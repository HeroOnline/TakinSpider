//package com.chr.data.spider.test.csdn;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.httpclient.params.HttpMethodParams;
//import org.apache.http.HttpStatus;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Cookie;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.google.common.base.Charsets;
//import com.google.common.io.Files;
//
//import us.codecraft.chr.StringUtil;
//
//public class CSDN {
//
//    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ms:ss");
//
//    public static void main(String[] args) {
//        try {
//            CSDN csdn = new CSDN();
//            csdn.phantomlogin();
//            //            csdn.chromelogin();
//            //            for (int i = 0; i < 100; i++) {
//            //                Thread.sleep(1000);
//            //            csdn.getvisited();
//            //            csdn.csdnurl();
//            //            }
//            //            csdn.viewmywithcookie();
//            //            csdn.ajaxconect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void getvisited() {
//        HttpClient client = new HttpClient();
//        PostMethod method = new PostMethod("http://my.csdn.net/service/main/visited");
//        //        PostMethod method = new PostMethod("http://my.csdn.net/service/main/uc");
//        //设置Http Post数据 
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
//                cook.setVersion(json.getInteger("version"));
//                cook.setSecure(json.getBooleanValue("secure"));
//                client.getState().addCookie(cook);
//                //                System.out.println(String.format("%s=%s;%s;%s;%s;", cook.getName(), cook.getValue(), cook.getExpiryDate() != null ? sdf.format(cook.getExpiryDate()) : "无", cook.getDomain(), cook.getPath()));
//            }
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//        //{"method":"getWorkExp","username":"asivy"}
//        NameValuePair[] param = { new NameValuePair("username", "asivy") };
//
//        method.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.82 Safari/537.36");
//        method.addRequestHeader("Connection", "keep-alive");
//        method.addRequestHeader("Content-Encoding", "gzip, deflate");
//        method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//        method.addRequestHeader("Date", new Date().toString());
//        method.addRequestHeader("Host", "my.csdn.net");
//        method.addRequestHeader("Keep-Alive", "timeout=20");
//        method.addRequestHeader("Server", "openresty");
//        method.addRequestHeader("Transfer-Encoding", "chunked");
//        method.addRequestHeader("Vary", "Accept-Encoding");
//        method.addRequestHeader("Origin", "http://my.csdn.net");
//        method.addRequestHeader("Accept", "application/json, text/javascript, */*; q=0.01");
//        method.addRequestHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
//        //        method.addRequestHeader("Content-Length", "75");
//        method.setParams(p);
//        method.setRequestBody(param);
//        client.getHttpConnectionManager().getParams().setConnectionTimeout(50000);// 设置连接时间
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
//        } finally {
//            method.releaseConnection();
//        }
//
//    }
//
//    public void ajaxconect() {
//        HttpClient client = new HttpClient();
//        PostMethod method = new PostMethod("http://my.csdn.net/service/main/uc");
//        //        PostMethod method = new PostMethod("http://my.csdn.net/service/main/uc");
//        //设置Http Post数据 
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
//                cook.setVersion(json.getInteger("version"));
//                cook.setSecure(json.getBooleanValue("secure"));
//                client.getState().addCookie(cook);
//                //                System.out.println(String.format("%s=%s;%s;%s;%s;", cook.getName(), cook.getValue(), cook.getExpiryDate() != null ? sdf.format(cook.getExpiryDate()) : "无", cook.getDomain(), cook.getPath()));
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
//        method.addRequestHeader("Transfer-Encoding", "chunked");
//        method.addRequestHeader("Vary", "Accept-Encoding");
//        method.addRequestHeader("Origin", "http://my.csdn.net");
//        method.addRequestHeader("Accept", "application/json, text/javascript, */*; q=0.01");
//        method.addRequestHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
//        //        method.addRequestHeader("Content-Length", "75");
//        method.setParams(p);
//        method.setRequestBody(param);
//        client.getHttpConnectionManager().getParams().setConnectionTimeout(50000);// 设置连接时间
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
//        } finally {
//            method.releaseConnection();
//        }
//    }
//
//    public void viewmywithcookie() {
//        //设置Http Post数据 
//        HttpMethodParams p = new HttpMethodParams();
//        System.out.println("------------------------------------------------------------------");
//
//        try {
//            List<String> cookies = Files.readLines(cookiefile, Charsets.UTF_8);
//            System.getProperties().setProperty("webdriver.chrome.driver", "D:\\spider\\chromedriver_x64.exe");
//            WebDriver driver = new ChromeDriver(); //调用火狐浏览器
//
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
//                cook.setVersion(json.getInteger("version"));
//                cook.setSecure(json.getBooleanValue("secure"));
//                //                System.out.println(String.format("%s=%s;%s;%s;%s;", cook.getName(), cook.getValue(), cook.getExpiryDate() != null ? sdf.format(cook.getExpiryDate()) : "无", cook.getDomain(), cook.getPath()));
//                driver.manage().addCookie(new Cookie(cook.getName(), cook.getValue(), cook.getDomain(), cook.getPath(), cook.getExpiryDate(), cook.getSecure()));
//            }
//            driver.get("http://my.csdn.net/asivy");
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//
//    }
//
//    //    public void csdnurl() {
//    //        try {
//    //            String s = "http://my.csdn.net/service/main/uc";
//    //            URL url = new URL(s);
//    //            HttpURLConnection http = (HttpURLConnection) url.openConnection();
//    //            http.setDoOutput(true);
//    //            http.setDoInput(true);
//    //            http.setRequestMethod("POST");
//    //
//    //            http.connect();
//    //            OutputStreamWriter out = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
//    //
//    //            //{"method":"getEduExp","username":"asivy"}
//    //            String input = "method=getEduExp&username=asivy";
//    //
//    //            out.append(input);
//    //            out.flush();
//    //            out.close();
//    //            int length = (int) http.getContentLength();
//    //            System.out.println(length);
//    //            BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
//    //            String line;
//    //            StringBuffer buffer = new StringBuffer();
//    //            while ((line = reader.readLine()) != null) {
//    //                buffer.append(line);
//    //            }
//    //            reader.close();
//    //            http.disconnect();
//    //            System.out.println(buffer.toString());
//    //        } catch (Exception e) {
//    //            e.printStackTrace();
//    //        }
//    //    }
//
//    //phantomjs获取cookie
//    public void phantomlogin() {
//        DesiredCapabilities sCaps = new DesiredCapabilities();
//        sCaps.setJavascriptEnabled(true);
//        sCaps.setCapability("takesScreenshot", false);
//        ArrayList<String> cliArgsCap = new ArrayList<String>();
//        cliArgsCap.add("--web-security=false");
//        cliArgsCap.add("--ssl-protocol=any");
//        cliArgsCap.add("--ignore-ssl-errors=true");
//        sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
//
//        sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS, new String[] { "INFO" });
//
//        sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "D:/tools/phantomjs-2.1.1-windows/bin/phantomjs.exe");
//        WebDriver driver = new PhantomJSDriver(sCaps);
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
//
//        WebDriver.Options manager = driver.manage();
//
//        Set<Cookie> cookies = manager.getCookies();
//        Set<Cookie> result = new HashSet<Cookie>();
//        for (Cookie co : cookies) {
//            if (co.getDomain().contains("passport")) {
//                continue;
//            }
//            System.out.println(String.format("%s=%s;%s;%s;%s;", co.getName(), co.getValue(), co.getExpiry() != null ? sdf.format(co.getExpiry()) : "-", co.getDomain(), co.getPath()));
//            result.add(co);
//        }
//        try {
//            Files.write("", cookiefile, Charsets.UTF_8);
//            for (Cookie ck : cookies) {
//                org.apache.commons.httpclient.Cookie cook = new org.apache.commons.httpclient.Cookie();
//                cook.setDomain(ck.getDomain());
//                cook.setExpiryDate(ck.getExpiry());
//                cook.setName(ck.getName());
//                cook.setPath(ck.getPath());
//                cook.setValue(ck.getValue());
//                Files.append(JSON.toJSONString(cook) + "\n", cookiefile, Charsets.UTF_8);
//            }
//            System.out.println("write cookie to file success\n");
//            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
//
//            String handle = driver.getWindowHandle();
//            for (String handles : driver.getWindowHandles()) {
//                if (handles.equals(handle))
//                    continue;
//                driver.switchTo().window(handles);
//                System.out.println("---" + driver.getTitle());
//            }
//
//            //            driver.get("http://my.csdn.net/asivy");
//            driver.get("http://my.csdn.net/jiangqq781931404");
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(driver.findElement(By.className("email")).getText());
//        System.out.println(driver.findElement(By.className("modile")).getText());
//        System.out.println(driver.findElement(By.className("qq")).getText());
//        System.out.println(driver.findElement(By.className("weixin")).getText());
//
//    }
//
//    //chrome获取cookie
//    public void chromelogin() {
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
//            Files.write("", cookiefile, Charsets.UTF_8);
//            for (Cookie ck : cookies) {
//                org.apache.commons.httpclient.Cookie cook = new org.apache.commons.httpclient.Cookie();
//                cook.setDomain(ck.getDomain());
//                cook.setExpiryDate(ck.getExpiry());
//                cook.setName(ck.getName());
//                cook.setPath(ck.getPath());
//                cook.setValue(ck.getValue());
//                Files.append(JSON.toJSONString(cook) + "\n", cookiefile, Charsets.UTF_8);
//                System.out.println(String.format("%s=%s;%s;%s;%s;", ck.getName(), ck.getValue(), ck.getExpiry() != null ? sdf.format(ck.getExpiry()) : "-", ck.getDomain(), ck.getPath()));
//            }
//            System.out.println("write cookie to file success\n");
//            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
//
//            String handle = driver.getWindowHandle();
//            for (String handles : driver.getWindowHandles()) {
//                if (handles.equals(handle))
//                    continue;
//                driver.switchTo().window(handles);
//                System.out.println("---" + driver.getTitle());
//            }
//
//            //            driver.get("http://my.csdn.net/asivy");
//            driver.get("http://my.csdn.net/jiangqq781931404");
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(driver.findElement(By.className("email")).getText());
//        System.out.println(driver.findElement(By.className("modile")).getText());
//        System.out.println(driver.findElement(By.className("qq")).getText());
//        System.out.println(driver.findElement(By.className("weixin")).getText());
//
//        // 打印出当前页面title,发现我已经把控制权交给了注册页面  
//        //        driver.quit();
//    }
//
//    public static final File cookiefile = new File("D:/spider/cookie.txt");
//
//}

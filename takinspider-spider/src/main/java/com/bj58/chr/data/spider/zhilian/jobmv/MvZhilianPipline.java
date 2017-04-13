package com.bj58.chr.data.spider.zhilian.jobmv;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bj58.chr.data.spider.util.StringUtil;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

public class MvZhilianPipline implements PageModelPipeline<ZhiLianBean> {

    private static final Logger logger = LoggerFactory.getLogger(MvZhilianPipline.class);

    private static final AtomicLong success = new AtomicLong(0);
    public static final AtomicLong submit = new AtomicLong(0);
    public static final AtomicLong queue = new AtomicLong(0);
    public static final AtomicLong duplicate = new AtomicLong(0);

    @Override
    public void process(ZhiLianBean job, Task task) {
        try {
            success.getAndIncrement();
            logger.info(JSON.toJSONString(job));
            QDJob qdjob = new QDJob();
            BeanUtils.copyProperties(qdjob, job);
            qdjob.setName(job.getJname());
            QDCom qdcom = new QDCom();
            BeanUtils.copyProperties(qdcom, job);
            qdcom.setName(job.getCname());

            QDOther qdother = new QDOther();
            BeanUtils.copyProperties(qdother, job);
            logger.info(JSON.toJSONString(qdcom));
            logger.info(JSON.toJSONString(qdjob));
            logger.info(JSON.toJSONString(qdother));

            JSONObject json = new JSONObject();
            json.put("company", qdcom);
            json.put("position", qdjob);
            json.put("other", qdother);
            tomv(json.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tomv(String data) {
        try {
            String uu = "http://localhost:800/bjobmv/jobImport?type=1&data=";
            //            String uu = "http://qy.chinahr.com/bjobmv/jobImport?type=1&data=";
            if (StringUtil.isNotNullOrEmpty(data)) {
                String ss = DesUtil.encrypt(data.trim(), DesUtil.DES_KEY_STRING);
                System.out.println(URLEncoder.encode(ss, "UTF-8"));
                String u = uu + URLEncoder.encode(ss, "UTF-8");
                new HttpRequestor().doPost(u, "");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package com.bj58.chr.data.spider.util;

import java.io.File;
import java.util.concurrent.ConcurrentNavigableMap;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.bj58.chr.data.spider.zhilian.demo.ZLPipline;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.component.DuplicateRemover;

/**
 * 本地缓存  本想用来做存储用的
 *
 * @author WangYazhou
 * @date  2016年7月21日 上午10:56:26
 * @see
 */
public class MapDbDuplicateRemover implements DuplicateRemover {

    private static final DB db = DBMaker.newFileDB(new File("D:/opendata/mapdb/wuyijob")).closeOnJvmShutdown().asyncWriteFlushDelay(1000).asyncWriteEnable().asyncWriteQueueSize(100).make();

    private static final String topic = "spider";

    @Override
    public boolean isDuplicate(Request request, Task task) {
        ConcurrentNavigableMap<String, Long> map = db.getTreeMap(topic);
        boolean first = null == map.put(getUrl(request), System.currentTimeMillis());
        if (first) {
            ZLPipline.queue.getAndIncrement();
        } else {
            ZLPipline.duplicate.getAndIncrement();
        }
        ZLPipline.submit.getAndIncrement();
        return !first;
    }

    protected String getUrl(Request request) {
        return request.getUrl();
    }

    @Override
    public void resetDuplicateCheck(Task task) {
        db.getTreeMap(topic).clear();
    }

    @Override
    public int getTotalRequestsCount(Task task) {
        return db.getTreeMap(topic).size();
    }

    public static void main(String[] args) {
        ConcurrentNavigableMap<String, Long> map = db.getTreeMap(topic);
        System.out.println(null == map.put("ha", 1l));
        System.out.println(map.put("ma", 2l));
        System.out.println(null == map.put("ha", 3l));
    }

}

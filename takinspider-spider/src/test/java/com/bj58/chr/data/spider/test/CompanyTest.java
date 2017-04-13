//package com.bj58.chr.data.spider.test;
//
//import org.junit.Test;
//
//import com.bj58.chr.dataspider.contract.SpiderCompanyService;
//import com.bj58.chr.dataspider.entity.SpiderCompanyBean;
//import com.bj58.spat.scf.client.SCFInit;
//import com.bj58.spat.scf.client.proxy.builder.ProxyFactory;
//
//public class CompanyTest {
//
//    static {
//        try {
//            SCFInit.init("E:/opt/wf/com.bj58.chr.data.spider/scf.config");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    @Test
//    public void into() {
//        try {
//            SpiderCompanyService service = ProxyFactory.create(SpiderCompanyService.class, "tcp://dataspider/SpiderCompanyServiceImpl");
//            SpiderCompanyBean bean = new SpiderCompanyBean();
//            bean.setId("adsads");
//            bean.setName("小试");
//            service.inseart(bean);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}

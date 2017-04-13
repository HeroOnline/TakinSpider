package us.codecraft.webmagic.model.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * 此url会被抓取，但此URL对应的页面不会被转成一个对象
 * 比如常见的列表页
 * Define the 'help' url patterns for class. <br>
 * All urls matching the pattern will be crawled and but not extracted for new objects. <br>
 * 
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface HelpUrl {

    /**
     * The url patterns to crawl. <br>
     * Use regex expression with some changes: <br>
     *      "." stand for literal character "." instead of "any character". <br>
     *      "*" stand for any legal character for url in 0-n length ([^"'#]*) instead of "any length". <br>
     *
     * @return the url patterns for class
     */
    String[] value();

    /**
     * Define the region for url extracting. <br>
     * Only support XPath.<br>
     * When sourceRegion is set, the urls will be extracted only from the region instead of entire content. <br>
     *
     * @return the region for url extracting
     */
    String sourceRegion() default "";
}

package us.codecraft.webmagic.model;

import us.codecraft.webmagic.Page;

/**
 * Interface to be implemented by page models that need to do something after fields are extracted.<br>
 *
 * @author lemon <br>
 * @since 0.2.0
 */
public interface AfterExtractor {

    public void afterProcess(Page page);
}

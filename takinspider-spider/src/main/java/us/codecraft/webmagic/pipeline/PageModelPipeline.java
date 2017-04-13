package us.codecraft.webmagic.pipeline;

import us.codecraft.webmagic.Task;

/**
 * Implements PageModelPipeline to persistent your page model.
 *
 * @author lemon <br>
 * @since 0.2.0
 */
public interface PageModelPipeline<T> {

    public void process(T t, Task task);

}

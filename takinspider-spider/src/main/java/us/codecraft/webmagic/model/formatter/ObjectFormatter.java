package us.codecraft.webmagic.model.formatter;

/**
 * @author lemon
 */
public interface ObjectFormatter<T> {

    T format(String raw) throws Exception;

    Class<T> clazz();

    void initParam(String[] extra);

}

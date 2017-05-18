/**
 * 
 */
package com.thunisoft.vsearch.spider.parse;

/**
 * @author lixiangyang
 *
 */
public interface ContentHandler {

    /**
     * 翻译特殊字符
     * @param target
     * @param data
     */
    public void translate(String target, String data);
    
}

/**
 * 
 */
package com.thunisoft.vsearch.spider.parse;

/**
 * @author lixiangyang
 *
 */
public enum ParserType {

    /** 标题 */
    TITLE(),
    
    /** 文档正文 */
    CONTENT(),
    
    /** 作者 */
    AUTHER(),
    
    /** 链接 */
    URL(),
    
    /** 摘要 */
    ABS(),
    
    CUSTOM()
    
    
}

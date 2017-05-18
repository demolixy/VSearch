/**
 * 
 */
package com.thunisoft.vsearch.spider.parse;

import com.thunisoft.vsearch.spider.crawler.bean.PageInfo;

/**
 * @author lixiangyang
 *
 */
public interface IParse {

    /**
     * 
     * @param input
     * @param context
     */
    void parse(PageInfo info, ParserContext context);
    
}

/**
 * 
 */
package com.thunisoft.vsearch.spider.parse;

import com.thunisoft.vsearch.spider.parse.common.AnalyzerFactory;

/**
 * @author lixiangyang
 *
 */
public abstract class AbsParser {

    protected final static AnalyzerFactory analyzer = AnalyzerFactory.instance;
    
    private String title;
    
    private String content;
    
    /**
     * 解析类型
     * @return
     */
    public abstract ParserType parserType() ;
    
    /**
     * 处理字段
     * @throws Exception
     */
    protected abstract void process() throws Exception ;

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the title
     */
    protected String getTitle() {
        return title;
    }

    /**
     * @return the content
     */
    protected String getContent() {
        return content;
    }
    
}

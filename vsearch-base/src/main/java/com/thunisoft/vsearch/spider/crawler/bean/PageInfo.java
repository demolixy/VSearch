/**
 * 
 */
package com.thunisoft.vsearch.spider.crawler.bean;

/**
 * @author lixiangyang
 *
 */
public abstract class PageInfo {

    private String title;
    
    private String content;
    
    private String url;
    
    private String abs;
    
    private String auther;
    

    protected abstract void process();
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
}

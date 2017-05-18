/**
 * 
 */
package com.thunisoft.vsearch.spider.parse.parser;

import java.io.IOException;
import java.util.Set;

import com.thunisoft.vsearch.spider.parse.AbsParser;

/**
 * @author lixiangyang
 *
 */
public class TitleParser extends AbsParser {

    
    public TitleParser(String title) {
        this.setTitle(title);
    }
    
    
    /* (non-Javadoc)
     * @see com.thunisoft.vsearch.spider.parse.AbsParser#process()
     */
    @Override
    public void process() throws IOException {
        Set<String> title = analyzer.segWord(getTitle());
    }

}

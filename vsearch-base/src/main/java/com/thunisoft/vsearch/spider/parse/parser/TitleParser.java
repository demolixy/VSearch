/**
 * 
 */
package com.thunisoft.vsearch.spider.parse.parser;

import java.io.IOException;
import java.util.Set;

import com.thunisoft.vsearch.spider.parse.AbsParser;
import com.thunisoft.vsearch.spider.parse.ParserType;

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


    /* (non-Javadoc)
     * @see com.thunisoft.vsearch.spider.parse.AbsParser#parserType()
     */
    @Override
    public ParserType parserType() {
        return ParserType.TITLE;
    }

}

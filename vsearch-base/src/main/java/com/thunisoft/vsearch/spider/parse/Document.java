/**
 * 
 */
package com.thunisoft.vsearch.spider.parse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lixiangyang
 * 一整个文档集合
 */
public class Document implements Iterable<AbsParser> {

    private final List<AbsParser> pasers = new ArrayList<AbsParser>();
    
    public Document() {}
    
    /* (non-Javadoc)
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator<AbsParser> iterator() {
        return pasers.iterator();
    }

    public final void add(AbsParser parser) {
        pasers.add(parser);
    }
    
    public final AbsParser[] getParsers(ParserType type) {
        List<AbsParser> parsers = new ArrayList<AbsParser>();
        for(AbsParser parser : pasers) {
            if(parser.parserType().equals(type)) {
                parsers.add(parser);
            }
        }
        return parsers.toArray(new AbsParser[parsers.size()]);
    }
    
    
}

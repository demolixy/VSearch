/**
 * 
 */
package com.thunisoft.vsearch.spider.parse;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lixiangyang
 *
 */
public class ParserContext implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1432482482811171993L;

    private final Map<String, Object> context = new HashMap<String, Object>();
    
    public <T> void set(Class<T> key, T value) {
        if(value != null) {
            context.put(key.getName(), value);
        } else {
            context.remove(key.getName());
        }
    }
    
    
}

/**
 * 
 */
package com.thunisoft.vsearch.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author lixy
 *
 */
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    
    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static Object getBeanByName(String name) {
        return applicationContext.getBean(name);
    }
    
}

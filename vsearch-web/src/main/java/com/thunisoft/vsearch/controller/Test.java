/**
 * 
 */
package com.thunisoft.vsearch.controller;

import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thunisoft.vsearch.utils.ApplicationContextUtils;

/**
 * @author lixiangyang
 *
 */
@RestController
@RequestMapping("/user")
public class Test {

    @RequestMapping("/{id}")
    public String first(@PathVariable("id") String id) {
        
        MongoTemplate mongoTemplate = (MongoTemplate) ApplicationContextUtils.getBeanByName("mongoTemplate");
        mongoTemplate.save("ttttttt");
        LogFactory.getLog(getClass()).error("日志测试");
        return "lixy";
    }
    
}

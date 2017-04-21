/**
 * 
 */
package com.thunisoft.vsearch.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lixiangyang
 *
 */
@RestController
@RequestMapping("/user")
public class Test {

    @RequestMapping("/{id}")
    public String first(@PathVariable("id") String id) {
        return "lixy";
    }
    
}

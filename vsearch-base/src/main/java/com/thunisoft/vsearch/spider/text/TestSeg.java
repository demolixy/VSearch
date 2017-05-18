/**
 * 
 */
package com.thunisoft.vsearch.spider.text;

import java.io.IOException;
import java.io.StringReader;

import com.chenlb.mmseg4j.ComplexSeg;
import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MMSeg;
import com.chenlb.mmseg4j.Seg;
import com.chenlb.mmseg4j.Word;

/**
 * @author lixiangyang
 *
 */
public class TestSeg {

    public static void main(String[] args) throws IOException {
        Dictionary dic = Dictionary.getInstance();
        String txt = "有些人喜欢java，有些人喜欢C++，还有些人喜欢php";
        Seg seg = new ComplexSeg(dic);
        MMSeg mmSeg = new MMSeg(new StringReader(txt), seg);
        Word word = null;
        while((word = mmSeg.next())!=null) {
                if(word != null) { 
                    System.out.print(word + "|"); 
            }
        }
    }
    
    
}

/**
 * 
 */
package com.thunisoft.vsearch.spider.parse.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.chenlb.mmseg4j.ComplexSeg;
import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MMSeg;
import com.chenlb.mmseg4j.Seg;
import com.chenlb.mmseg4j.Word;

/**
 * @author lixiangyang
 *
 */
public enum AnalyzerFactory {

    instance();

    private static final Dictionary dic = Dictionary.getInstance();
    
    private static Seg seg = null;
    
    private AnalyzerFactory() {
        init();
    }
    
    private void init() {
        seg = new ComplexSeg(dic);
    }
    
    /**
     * 
     * @param word
     * @return
     * @throws IOException 
     */
    public Set<String> segWord(String txt) throws IOException {
        MMSeg mmSeg = new MMSeg(new StringReader(txt), seg);
        Word word = null;
        Set<String> wordSet = new HashSet<String>();
        while((word = mmSeg.next()) != null ) {
            wordSet.add(word.getString());
        }
        return wordSet;
    }
    
    /**
     * 
     * @param stream
     * @return
     * @throws IOException 
     */
    public Set<String> segWordByStream(InputStream stream) throws IOException {
        String txt = IOUtils.toString(stream);
        return segWord(txt);
    }
    
    /**
     * 
     * @param file
     * @return
     * @throws IOException
     */
    public Set<String> segWordByFile(File file) throws IOException {
        return segWordByStream(FileUtils.openInputStream(file));
    }
    
    
}

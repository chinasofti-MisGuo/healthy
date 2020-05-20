package com.mongolia.test;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * @author Dong.w
 */
public class UploadTest {

    @Test
    public void test() throws Exception {
        String str = "/xx/xx/upload/originalFilename.jpg";
        String substring = StringUtils.substring(str, str.lastIndexOf("/upload"));
        System.out.println(substring);
    }

}

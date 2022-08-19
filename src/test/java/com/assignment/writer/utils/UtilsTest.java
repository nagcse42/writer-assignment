package com.assignment.writer.utils;

import com.assignment.writer.common.WriterCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilsTest {

    @Test
    public void test_FileUtils() {
        String actual = WriterUtils.processesInput("abc XXX XXX stupid",
                WriterCase.CASE_LOWER,true,true);
        Assertions.assertEquals("abc xxx s!!!!!", actual);

        actual = WriterUtils.processesInput("abc XXX XXX stupid",
                WriterCase.CASE_UPPER,true,true);
        Assertions.assertEquals("ABC XXX S!!!!!", actual);

        actual = WriterUtils.processesInput("abc XXX XXX stupid",
                WriterCase.CASE_LOWER,false,false);
        Assertions.assertEquals("abc xxx xxx stupid", actual);

        actual = WriterUtils.processesInput("abc XXX XXX stupid",
                WriterCase.CASE_UPPER,true,false);
        Assertions.assertEquals("ABC XXX XXX S!!!!!", actual);

        actual = WriterUtils.processesInput("abc XXX XXX stupid",
                WriterCase.CASE_UPPER,false,true);
        Assertions.assertEquals("ABC XXX STUPID", actual);
    }
}

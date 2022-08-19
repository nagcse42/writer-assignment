package com.assignment.writer.service;

import com.assignment.writer.common.WriterCase;
import com.assignment.writer.service.impl.FileWriterImpl;
import com.assignment.writer.service.impl.StringWriterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FileWriterTest {

    @Test
    public void test_StringWriter() {
        FileWriterImpl stringWriter = new FileWriterImpl();
        stringWriter.setWriterCase(WriterCase.CASE_LOWER);
        stringWriter.setRemoveConsctvDuplicate(true);
        stringWriter.setReplaceStupid(true);
        stringWriter.write("abc XXX XXX stupid");
        Assertions.assertEquals("abc xxx s!!!!!", stringWriter.getOutput());
        stringWriter.write("BBC");
        Assertions.assertEquals("abc xxx s!!!!! bbc", stringWriter.getOutput());
        stringWriter.setClosed(true);
        stringWriter.write("AAA");
        Assertions.assertEquals("abc xxx s!!!!! bbc", stringWriter.getOutput());
    }
}

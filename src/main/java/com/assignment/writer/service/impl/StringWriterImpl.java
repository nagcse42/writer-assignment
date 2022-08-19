package com.assignment.writer.service.impl;

import com.assignment.writer.common.WriterCase;
import com.assignment.writer.service.Writer;
import com.assignment.writer.utils.WriterUtils;

public class StringWriterImpl implements Writer {
    private boolean closed;
    private WriterCase writerCase;
    private boolean removeConsctvDuplicate;
    private boolean replaceStupid;
    private StringBuilder writerResult = new StringBuilder();

    public String getOutput() {
        return writerResult.toString();
    }

    @Override
    public void write(String inputString) {
        if(closed){
            return;
        }

        if(null != inputString) {
            inputString = WriterUtils.processesInput(inputString, writerCase, replaceStupid, removeConsctvDuplicate);
            if(writerResult.length() != 0) {
                writerResult.append(" ");
            }
            writerResult.append(inputString);
            System.out.println(writerResult.toString());
        }
    }


    /**
     * **********************
     * Setters and getters
     * *********************
     */

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public WriterCase getWriterCase() {
        return writerCase;
    }

    public void setWriterCase(WriterCase writerCase) {
        this.writerCase = writerCase;
    }

    public boolean isRemoveConsctvDuplicate() {
        return removeConsctvDuplicate;
    }

    public void setRemoveConsctvDuplicate(boolean removeConsctvDuplicate) {
        this.removeConsctvDuplicate = removeConsctvDuplicate;
    }

    public boolean isReplaceStupid() {
        return replaceStupid;
    }

    public void setReplaceStupid(boolean replaceStupid) {
        this.replaceStupid = replaceStupid;
    }
}
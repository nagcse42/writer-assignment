package com.assignment.writer.service.impl;

import com.assignment.writer.common.WriterCase;
import com.assignment.writer.service.Writer;
import com.assignment.writer.utils.WriterUtils;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileWriterImpl implements Writer {
    private boolean closed;
    private WriterCase writerCase;
    private boolean removeConsctvDuplicate;
    private boolean replaceStupid;
    private static final String filePath  ="src/main/resources/writer.dat";

    public static void main(String[] args) {
        FileWriterImpl fileWriter = new FileWriterImpl();
        fileWriter.write("ABC");
    }

    public String getOutput() {
        try {
            return readFromInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Np data fount";
    }

    @Override
    public void write(String inputString) {
        if(closed){
            return;
        }

        if(null != inputString) {
            inputString = WriterUtils.processesInput(inputString, writerCase, replaceStupid, removeConsctvDuplicate);

            try {
                String existingData = readFromInputStream();
                if(existingData.length() != 0) {
                    existingData = existingData + " ";
                }
                existingData = existingData + inputString;
                System.out.println(existingData);
                writeToFile(existingData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String readFromInputStream()
            throws IOException {
        Path path = Paths.get(filePath);
        //BufferedReader reader = Files.newBufferedReader(path);
        List<String> lines = Files.readAllLines(path);
        if(null != lines && !lines.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String line: lines
                 ) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        }


        return "";
    }

    private void writeToFile(String fileContent) {
        try(FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
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
package com.jk.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字符，字节，流的工具包
 */
public class StreamTools {
    /**
     * inputStream转outputStream
     * @param in inputStream
     * @return outputStream
     * @throws Exception
     */
    public static ByteArrayOutputStream parse(InputStream in) throws Exception
    {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        int ch;
        while ((ch = in.read()) != -1) {
            swapStream.write(ch);
        }
        return swapStream;
    }

    /**
     * outputStream转inputStream
     * @param out outputStream
     * @return inputStream
     * @throws Exception
     */
    public static ByteArrayInputStream parse(OutputStream out) throws Exception
    {
        ByteArrayOutputStream baos=(ByteArrayOutputStream) out;
        ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
        return swapStream;
    }

    /**
     * inputStream转String
     * @param in inputStream
     * @return String
     * @throws Exception
     */
    public static String parse_String(InputStream in) throws Exception
    {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        int ch;
        while ((ch = in.read()) != -1) {
            swapStream.write(ch);
        }
        return swapStream.toString();
    }


    /**
     * inputStream转byteArray
     * @param in  inputStream
     * @return byte[]
     * @throws Exception
     */
    public static byte[] parse_byte(InputStream in) throws Exception
    {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while((len = in.read(buffer)) != -1) {
            swapStream.write(buffer,0,len);
        }
        swapStream.close();
        in.close();
        byte[] result=swapStream.toByteArray();
        return result;
    }

    /**
     * outputStream 转String
     * @param out outputStream
     * @return String
     * @throws Exception
     */
    public static String parse_String(OutputStream out)throws Exception
    {
        ByteArrayOutputStream baos=(ByteArrayOutputStream) out;
        ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
        return swapStream.toString();
    }

    /**
     * outputStream 转byteArray
     * @param out outputStream
     * @return byte[]
     * @throws Exception
     */
    public static byte[] parse_byte(OutputStream out)throws Exception
    {
        ByteArrayOutputStream baos=(ByteArrayOutputStream) out;
        return baos.toByteArray();
    }

    /**
     * String转inputStream
     * @param in String
     * @return inputStream
     * @throws Exception
     */
    public static ByteArrayInputStream parse_inputStream(String in)throws Exception
    {
        ByteArrayInputStream input=new ByteArrayInputStream(in.getBytes());
        return input;
    }

    /**
     * String 转outputStream
     * @param in String
     * @return outputStream
     * @throws Exception
     */
    public static ByteArrayOutputStream parse_outputStream(String in)throws Exception
    {
        return parse(parse_inputStream(in));
    }

}

package com.example;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App 
{



    public static void main( String[] args )
    {

        InputStream is = new ByteArrayInputStream(new byte[]{1});
//        is.read();

        System.out.println( "Hello World!" );
    }
}

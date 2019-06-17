package com.transun;

import com.transun.util.ConfUtil;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println(ConfUtil.properties.getProperty("url"));

        System.out.println( "Hello" + args[0] );
    }
}

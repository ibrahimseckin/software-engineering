/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package getServices.util;

/**
 *
 * @author TTISECKIN
 */
public  class Logger {
    
    public static void logIt(String s) {
        System.out.println(">>>>>>>>>>>>>>" + s);
    }
    
    public static void logErr(String s) {
        System.out.println(">>>>>>>>>>>>>>" + s);
    }
    
    public static void logErr(String s, Throwable e) {
        System.out.println(">>>>>>>>>>>>>>" + s);
    }
}

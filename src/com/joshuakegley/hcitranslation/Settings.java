package com.joshuakegley.hcitranslation;

/**
 *Sort of a pointless method, just wanting to test it out
 * @author Josh
 */
public class Settings {
    private static String lang1 = null;
    private static String lang2 = null;

    public static String getLang1() {
        return lang1;
    }

    public static void setLang1(String langLabel, String langCode) {
        Settings.lang1 = langCode;
        MainDriver.one.setPanelInvisible();
        System.out.println("lol");
        if(langCode != null && lang2 != null){
            MainDriver.translate();
        }
    }

    public static String getLang2() {
        return lang2;
    }

    public static void setLang2(String langLabel, String langCode) {
        Settings.lang2 = langCode;
        MainDriver.two.setPanelInvisible();
        if(lang1 != null && langCode != null){
            MainDriver.translate();
        }
    }
    
    
}
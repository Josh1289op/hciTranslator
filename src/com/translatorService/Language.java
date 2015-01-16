package com.translatorService; 
 
import java.util.HashMap;
import java.util.Map;


/**
 * List of all the languages accepted by the Google Translate API and the 
 * respective string used to access the web service.
 * @author Diego
 */
public class Language {
    public Language(){
        createMenuMap();
    }
    public static final String Afrikaans = "af";
    public static final String Albanian = "sq";
    public static final String Arabic = "ar";
    public static final String Azerbaijani = "az";
    public static final String Basque = "eu";
    public static final String Bengali = "bn";
    public static final String Belarusian = "be";
    public static final String Bulgarian = "bg";
    public static final String Catalan = "ca";
    public static final String ChineseSimplified = "zh-CN";
    public static final String ChineseTraditional = "zh-TW";
    public static final String Croatian = "hr";
    public static final String Czech = "cs";
    public static final String Danish = "da";
    public static final String Dutch = "nl";
    public static final String English = "en";
    public static final String Esperanto = "eo";
    public static final String Estonian = "et";
    public static final String Filipino = "tl";
    public static final String Finnish = "fi";
    public static final String French = "fr";
    public static final String Galician = "gl";
    public static final String Georgian = "ka";
    public static final String German = "de";
    public static final String Greek = "el";
    public static final String Gujarati = "gu";
    public static final String HaitianCreole = "ht";
    public static final String Hebrew = "iw";
    public static final String Hindi = "hi";
    public static final String Hungarian = "hu";
    public static final String Icelandic = "is";
    public static final String Indonesian = "id";
    public static final String Irish = "ga";
    public static final String Italian = "it";
    public static final String Japanese = "ja";
    public static final String Kannada = "kn";
    public static final String Korean = "ko";
    public static final String Latin = "la";
    public static final String Latvian = "lv";
    public static final String Lithuanian = "lt";
    public static final String Macedonian = "mk";
    public static final String Malay = "ms";
    public static final String Maltese = "mt";
    public static final String Norwegian = "no";
    public static final String Persian = "fa";
    public static final String Polish = "pl";
    public static final String Portuguese = "pt";
    public static final String Romanian = "ro";
    public static final String Russian = "ru";
    public static final String Serbian = "sr";
    public static final String Slovak = "sk";
    public static final String Slovenian = "sl";
    public static final String Spanish = "es";
    public static final String Swahili = "sw";
    public static final String Swedish = "sv";
    public static final String Tamil = "ta";
    public static final String Telugu = "te";
    public static final String Thai = "th";
    public static final String Turkish = "tr";
    public static final String Ukrainian = "uk";
    public static final String Urdu = "ur";
    public static final String Vietnamese = "vi";
    public static final String Welsh = "cy";
    public static final String Yiddish = "yi";
    
    public String langCode[] = {
        "", Afrikaans, Albanian, Arabic, Azerbaijani,Basque,Bengali,Belarusian,Bulgarian,Catalan,
        ChineseSimplified, ChineseTraditional, Croatian, Czech, Danish, Dutch, English, Esperanto, Estonian, Filipino, 
        Finnish, French, Galician, Georgian, German, Greek, Gujarati, HaitianCreole, Hebrew, Hindi, Hungarian, Icelandic, 
        Indonesian, Irish, Italian, Japanese, Kannada, Korean, Latin, Latvian, Lithuanian, Macedonian, Malay, Maltese, 
        Norwegian, Persian, Polish, Portuguese, Romanian, Russian, Serbian, Slovak, Slovenian, Spanish, Swahili, Swedish, 
        Tamil, Telugu, Thai, Turkish, Ukrainian, Urdu, Vietnamese, Welsh, Yiddish
    };
    public String lang[] = {
        "Select Language", "Afrikaans", "Albanian", "Arabic", "Azerbaijani", "Basque", "Bengali", "Belarusian", "Bulgarian", "Catalan",
        "Chinese Simplified", "Chinese Traditional", "Croatian", "Czech", "Danish", "Dutch", "English", "Esperanto", "Estonian", "Filipino", 
        "Finnish", "French", "Galician", "Georgian", "German", "Greek", "Gujarati", "HaitianCreole", "Hebrew", "Hindi", "Hungarian", "Icelandic", 
        "Indonesian", "Irish", "Italian", "Japanese", "Kannada", "Korean", "Latin", "Latvian", "Lithuanian", "Macedonian", "Malay", "Maltese", 
        "Norwegian", "Persian", "Polish", "Portuguese", "Romanian", "Russian", "Serbian", "Slovak", "Slovenian", "Spanish", "Swahili", "Swedish", 
        "Tamil", "Telugu", "Thai", "Turkish", "Ukrainian", "Urdu", "Vietnamese", "Welsh", "Yiddish"
    };
    
    public static Map<String, String> languageMapping;
    public static Map<String, String> getLanguageMapping(){
        return languageMapping;
    }
    public void createMenuMap(){
        languageMapping = new HashMap<String, String>();
        
        for(int i = 1; i < lang.length; ++i){
            languageMapping.put(langCode[i], lang[i]);
        }

    }
}

package com.survey;


/// file OpenPageInDefaultBrowser.java
public class OpenPageInDefaultBrowser {
   public static void open() {
       try {
   //Set your page url in this string.
         String url = "https://ufl.qualtrics.com/SE/?SID=SV_aXCsq6oCmuQLx9b";
         java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
       }
       catch (java.io.IOException e) {
           System.out.println(e.getMessage());
       }
   }
}
/// End of file       
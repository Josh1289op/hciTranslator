/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshuakegley.hcitranslation;

import com.translatorService.TranslateService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joshua
 */
public class Translate {
    
    
    public static String translate(String text, String src, String target){
        try {
            TranslateService service = new TranslateService();
             
            return service.translate(text, target, src);
        } catch (IOException ex) {
            Logger.getLogger(Translate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error with Translation";
    }
}

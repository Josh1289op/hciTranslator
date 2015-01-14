package com.joshuakegley.hcitranslation;

import java.awt.EventQueue;
import com.joshuakegley.panels.LanguageInterface;
import com.joshuakegley.panels.TranslateInterface;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * MenuScroller.java library credit: Darryl Burke 
 * https://tips4java.wordpress.com/2009/02/01/menu-scroller/
 * 
 * TranslateService.java & Language.java credit: HCI Course
 * 
 * 
 * @author Joshua Kegley
 */
public class HciTranslator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Call the Start up
        /**
        * 1. Open Splash Page
        * 2. Open Settings for User One
        * 3. Open Settings for User Two
        * 4. Open Translator Page
        *
        **/
        
        HciTranslator mainLogic = new HciTranslator();
        mainLogic.mainView = new MainInterface();
        mainLogic.mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainLogic.mainView.setVisible(true);
            }
        });
        mainLogic.setup();    
    }
    public static MainInterface mainView;
    
   

    
    public void setup(){
        LanguageInterface one = new LanguageInterface("One");
        LanguageInterface two = new LanguageInterface("Two");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.out.println("Adding Panel One");
                mainView.addPanel(one);
                
            }
        });
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.out.println("Adding Panel Two");
                mainView.addPanel(two);
                
            }
        });
        
        
        //languageSelect("One");
        //languageSelect("Two");
        //Create instance of language page
        //Request User One Language
        //Request User Two Language
        
    }
    
    public static void translate(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                TranslateInterface translate = new TranslateInterface();
                mainView.addPanel(translate);
            }
        });
    }
    
    
    
    

}

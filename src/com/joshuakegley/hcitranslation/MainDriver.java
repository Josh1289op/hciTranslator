package com.joshuakegley.hcitranslation;

import com.joshuakegley.interfaces.MainInterface;
import java.awt.EventQueue;
import com.joshuakegley.interfaces.LanguageInterface;
import com.joshuakegley.interfaces.TranslateInterface;
import javax.swing.JFrame;
/**
 * MenuScroller.java library credit: Darryl Burke 
 * https://tips4java.wordpress.com/2009/02/01/menu-scroller/
 * 
 * TranslateService.java & Language.java credit: HCI Course
 * 
 * 
 * @author Joshua Kegley
 */
public class MainDriver {

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
        
        MainDriver mainLogic = new MainDriver();
        mainLogic.mainView = new MainInterface();
        mainLogic.mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainLogic.mainView.setVisible(true);
            }
        });
        mainLogic.setup(one);    
    }
    public static MainInterface mainView;
    public static LanguageInterface one = new LanguageInterface("One");;
    public static LanguageInterface two = new LanguageInterface("Two");;
    public static TranslateInterface translate = new TranslateInterface();;


    
    public static void setup(LanguageInterface panel){
        
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.out.println("Adding Panel " + panel.getName());
                mainView.addPanel(panel);
                
            }
        });
        
        /*
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                System.out.println("Adding Panel Two");
                if(!one.isVisible() && Settings.getLang1() == null){
                    mainView.addPanel(one);
                }
                mainView.addPanel(two);


            }
        });
                */
        //languageSelect("One");
        //languageSelect("Two");
        //Create instance of language page
        //Request User One Language
        //Request User Two Language
        
    }
    
    public static void translate(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainView.addPanel(translate);
            }
        });
    }
    
    
    
    

}

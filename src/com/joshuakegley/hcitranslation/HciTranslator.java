package com.joshuakegley.hcitranslation;

import java.awt.EventQueue;
import com.joshuakegley.panels.LanguageInterface;
import javax.swing.GroupLayout;
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
        mainLogic.translate();
    
    }
    MainInterface mainView;
    
   

    
    public void setup(){
        
        languageSelect("One");
        
        languageSelect("Two");
        //Create instance of language page
        //Request User One Language
        //Request User Two Language
        
    }
    
    public void translate(){
        
        //open translation page
        //begin translations
    }
    
    public void languageSelect(String user){
        LanguageInterface select = new LanguageInterface(user);
        
        GroupLayout layout = new javax.swing.GroupLayout(mainView.getContentPane());
        mainView.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        
    }
    
    
}

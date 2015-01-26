/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshuakegley.interfaces;

import com.translatorService.Language;
import com.darrylburke.MenuScroller;
import com.joshuakegley.hcitranslation.Settings;
import static com.joshuakegley.hcitranslation.MainDriver.mainView;
import com.survey.OpenPageInDefaultBrowser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.GroupLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author Josh
 */
public class MainInterface extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form mainInterface
     */
    public MainInterface() {
        initComponents();
        //CENTER WINDOW
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //SET COLOR
        this.getContentPane().setBackground(new Color(54,57,59));
        
        //Create Menus for selecting languages
        this.createMenuMap();
        this.populateJMenu(this.createMenuItems(), u1Langs);
        this.populateJMenu(this.createMenuItems(), u2Langs);
        
        
        //File Exit Action Listener
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        

        
        
    }

        private Map<String, Integer> langMap;
    public Language lang = new Language();
    //Create HashMap for later lookups // IM SURE THERE IS A BETTER WAY!
    public void createMenuMap(){
        
        String[] languages = lang.lang;
        int i = 0;
        langMap = new HashMap<String, Integer>();
        for( String language : languages ) {
            if( i == 0 ){}
            else{
                langMap.put(language, i);
                
            }
            ++i;
         }
    }
    
    //Create a list of JMenuItems of all of the Languages
    public ArrayList<JMenuItem> createMenuItems(){
        String[] languages = lang.lang;
        int i = 0;
        ArrayList<JMenuItem> langMap = new ArrayList<JMenuItem>();
        for( String language : languages ) {
            if( i == 0 ){}
            else{
                JMenuItem temp = new JMenuItem(language);
                //COLOR OF IN MENU!
                //temp.setBackground(new Color(255,205,87));
                temp.addActionListener(this);
                langMap.add(temp);
                
            }
            ++i;
         }
        return langMap;
    }
    
    public void populateJMenu(ArrayList<JMenuItem> list, JMenu menu){
        //using the ArrayList of JMenuItems, populate chosen menu
        for (JMenuItem item : list) {
            menu.add(item);
        }
        MenuScroller.setScrollerFor(menu, 8, 125, 0, 0);  
    }
    
    public void updateUserSettings(int user, String languageLabel, String language){
        if(user == 1){
            if(Settings.getLang2() == null ? language == null : Settings.getLang2().equals(language)){
                System.out.println("Can't have the same language");
                return;
            }  
            Settings.setLang1(languageLabel, language);
            TranslateInterface.setLang1(languageLabel, language);
        }else{
            if(Settings.getLang1() == null ? language == null : Settings.getLang1().equals(language)){
                System.out.println("Can't have the same language");
                return;
            }  
            Settings.setLang2(languageLabel, language);
            TranslateInterface.setLang2(languageLabel, language);
        }        
    }
    
    
    public static void addPanel(JPanel panel){
        //LanguageInterface select = new LanguageInterface(user);
        
        GroupLayout layout = new javax.swing.GroupLayout(mainView.getContentPane());
        mainView.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Get the action clicked which is mapped to a number, map that number to langCode Array stored in Languages
        String languageCode = lang.langCode[langMap.get(e.getActionCommand())];
        String languageLabel = e.getActionCommand();
        //Detecting which user language is to be changed
        JPopupMenu menu = (JPopupMenu)((JMenuItem) e.getSource()).getParent();
        JMenu theMenu = (JMenu) menu.getInvoker();
        int userCode = Integer.parseInt(theMenu.getName());
        updateUserSettings(userCode, languageLabel, languageCode);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        UserOneLang = new javax.swing.JMenu();
        u1Langs = new javax.swing.JMenu();
        UserTwoLang1 = new javax.swing.JMenu();
        u2Langs = new javax.swing.JMenu();
        viewSurveyLink = new javax.swing.JMenu();
        surveyLink = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(149, 164, 166));
        setForeground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(675, 660));
        setResizable(false);

        menuBar.setBackground(new java.awt.Color(232, 221, 203));
        menuBar.setForeground(new java.awt.Color(3, 54, 73));
        menuBar.setBorderPainted(false);
        menuBar.setPreferredSize(new java.awt.Dimension(318, 40));

        fileMenu.setForeground(new java.awt.Color(3, 54, 73));
        fileMenu.setText("File");

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setActionCommand("Exit");
        exitMenuItem.setLabel("Exit");
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        UserOneLang.setBackground(new java.awt.Color(255, 205, 87));
        UserOneLang.setForeground(new java.awt.Color(3, 54, 73));
        UserOneLang.setText("User One");
        UserOneLang.setName("1"); // NOI18N

        u1Langs.setText("Language");
        u1Langs.setName("1"); // NOI18N
        UserOneLang.add(u1Langs);

        menuBar.add(UserOneLang);

        UserTwoLang1.setForeground(new java.awt.Color(3, 54, 73));
        UserTwoLang1.setText("User Two");
        UserTwoLang1.setName("2"); // NOI18N

        u2Langs.setText("Language");
        u2Langs.setName("2"); // NOI18N
        UserTwoLang1.add(u2Langs);

        menuBar.add(UserTwoLang1);

        viewSurveyLink.setForeground(new java.awt.Color(3, 54, 73));
        viewSurveyLink.setText("Complete Interaction");

        surveyLink.setText("Open Survey");
        surveyLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surveyLinkActionPerformed(evt);
            }
        });
        viewSurveyLink.add(surveyLink);

        menuBar.add(viewSurveyLink);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void surveyLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surveyLinkActionPerformed
        OpenPageInDefaultBrowser.open();
    }//GEN-LAST:event_surveyLinkActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu UserOneLang;
    private javax.swing.JMenu UserTwoLang1;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem surveyLink;
    private javax.swing.JMenu u1Langs;
    private javax.swing.JMenu u2Langs;
    private javax.swing.JMenu viewSurveyLink;
    // End of variables declaration//GEN-END:variables
}

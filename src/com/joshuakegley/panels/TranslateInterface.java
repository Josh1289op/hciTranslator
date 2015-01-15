/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshuakegley.panels;

import com.joshuakegley.hcitranslation.MainDriver;
import com.joshuakegley.hcitranslation.Settings;
import com.joshuakegley.hcitranslation.Translate;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Joshua
 */
public class TranslateInterface extends javax.swing.JPanel {

    /**
     * Creates new form TranslateInterface
     */
    public TranslateInterface() {

        initComponents();
        
        lang1TranslateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionListnerTranslate(evt);
            }
        });
        lang2TranslateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionListnerTranslate(evt);
            }
        });
        
    }

    public static void setLang1(String langLabel, String langCode){
            //lang1Label.setText(langLabel);
            if(langCode == "en"){
                lang1TranslateBtn.setText("Translate");
                lang1ResetBtn.setText("Reset");
            }else{
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                  
                        lang1TranslateBtn.setText(Translate.translate("Translate", "en", langCode));
                        lang1ResetBtn.setText(Translate.translate("Reset", "en", langCode));
                    }
                });
            }
    }
    
    public static void setLang2(String langLabel, String langCode){
        //lang2Label.setText(langLabel);
        if(langCode == "en"){
            lang2TranslateBtn.setText("Translate");
            lang2ResetBtn.setText("Reset");
            return;
        }else{
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    lang2TranslateBtn.setText(Translate.translate("Translate", "en", langCode));
                    lang2ResetBtn.setText(Translate.translate("Reset", "en", langCode));
                }
            });
        }
    }    
    
    private void actionListnerTranslate(java.awt.event.ActionEvent evt) {                                             
        int user = Integer.parseInt(((JButton)evt.getSource()).getName());
        
        if (user == 1){
            String message = lang1Text.getText();
            String result = Translate.translate(message, Settings.getLang1(), Settings.getLang2());
            result = result.replaceAll("&#39;","\'");
            displayPane.append("\n" + result);            
            
        }else {
            String message = lang2Text.getText();
            String result = Translate.translate(message, Settings.getLang2(), Settings.getLang1());
            result = result.replaceAll("&#39;","\'");
            displayPane.append("\n" + result);
        }
        
        
    } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        displayPane = new javax.swing.JTextArea();
        lang1TranslateBox = new javax.swing.JScrollPane();
        lang1Text = new javax.swing.JTextArea();
        lang2TranslateBox = new javax.swing.JScrollPane();
        lang2Text = new javax.swing.JTextArea();
        lang2TranslateBtn = new javax.swing.JButton();
        lang1TranslateBtn = new javax.swing.JButton();
        lang1ResetBtn = new javax.swing.JButton();
        lang2ResetBtn = new javax.swing.JButton();
        choice1 = new java.awt.Choice();
        choice2 = new java.awt.Choice();

        setPreferredSize(new java.awt.Dimension(586, 469));

        displayPane.setEditable(false);
        displayPane.setBackground(new java.awt.Color(222, 220, 220));
        displayPane.setColumns(20);
        displayPane.setLineWrap(true);
        displayPane.setRows(5);
        displayPane.setWrapStyleWord(true);
        jScrollPane1.setViewportView(displayPane);

        lang1Text.setBackground(new java.awt.Color(255, 204, 204));
        lang1Text.setColumns(20);
        lang1Text.setLineWrap(true);
        lang1Text.setRows(5);
        lang1TranslateBox.setViewportView(lang1Text);

        lang2Text.setBackground(new java.awt.Color(204, 204, 255));
        lang2Text.setColumns(20);
        lang2Text.setLineWrap(true);
        lang2Text.setRows(5);
        lang2Text.setWrapStyleWord(true);
        lang2TranslateBox.setViewportView(lang2Text);

        lang2TranslateBtn.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        lang2TranslateBtn.setText("Translate");
        lang2TranslateBtn.setName("2"); // NOI18N

        lang1TranslateBtn.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        lang1TranslateBtn.setText("Translate");
        lang1TranslateBtn.setName("1"); // NOI18N

        lang1ResetBtn.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        lang1ResetBtn.setText("Reset");

        lang2ResetBtn.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        lang2ResetBtn.setText("Reset");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lang1TranslateBox)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lang1TranslateBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lang1ResetBtn))
                            .addComponent(choice2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lang2TranslateBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lang2ResetBtn))
                            .addComponent(lang2TranslateBox)
                            .addComponent(choice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(choice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(choice2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lang1TranslateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lang1TranslateBtn)
                            .addComponent(lang1ResetBtn)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lang2TranslateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lang2TranslateBtn)
                            .addComponent(lang2ResetBtn))))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choice1;
    private java.awt.Choice choice2;
    private javax.swing.JTextArea displayPane;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JButton lang1ResetBtn;
    private javax.swing.JTextArea lang1Text;
    private javax.swing.JScrollPane lang1TranslateBox;
    private static javax.swing.JButton lang1TranslateBtn;
    private static javax.swing.JButton lang2ResetBtn;
    private javax.swing.JTextArea lang2Text;
    private javax.swing.JScrollPane lang2TranslateBox;
    private static javax.swing.JButton lang2TranslateBtn;
    // End of variables declaration//GEN-END:variables
}

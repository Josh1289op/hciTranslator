package com.joshuakegley.interfaces;

import com.batsov.ContextMenuMouseListener;
import com.joshuakegley.hcitranslation.Settings;
import com.joshuakegley.hcitranslation.Translate;
import com.translatorService.Language;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

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
        
        
        user1ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user1ComboBoxAction(evt);   
            }
        });
        
        user2ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user2ComboBoxAction(evt);   
            }
        });
        user1ComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setBackground(new Color(232,221,203));
                setForeground(new Color(3,54,73));
                super.paint(g);
            }
        });
        
        user2ComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setBackground(new Color(232,221,203));
                setForeground(new Color(3,54,73));
                super.paint(g);
            }
        });
        lang1Text.addMouseListener(new ContextMenuMouseListener());
        lang2Text.addMouseListener(new ContextMenuMouseListener());
        displayPane.addMouseListener(new ContextMenuMouseListener());
        

        ((JLabel)user2ComboBox.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
        user2ComboBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    
    }
    
    
    private static Language languages = new Language();
    public boolean firstTime1 = true;
    public boolean firstTime2 = true;
    
    public static void setLang1(String langLabel, String langCode){
            if(langCode == "en"){
                user1ComboBox.setSelectedIndex(16);
                lang1TranslateBtn.setText("Translate");
                lang1ResetBtn.setText("Reset");
            }else{
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        user1ComboBox.setSelectedIndex(Arrays.asList(languages.langCode).indexOf(langCode));
                        lang1TranslateBtn.setText(Translate.translate("Translate", "en", langCode));
                        lang1ResetBtn.setText(Translate.translate("Reset", "en", langCode));
                    }
                });
            }
    }
    
    public static void setLang2(String langLabel, String langCode){
        if(langCode == "en"){
            user2ComboBox.setSelectedIndex(16);
            lang2TranslateBtn.setText("Translate");
            lang2ResetBtn.setText("Reset");
            return;
        }else{
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    user2ComboBox.setSelectedIndex(Arrays.asList(languages.langCode).indexOf(langCode));
                    lang2TranslateBtn.setText(Translate.translate("Translate", "en", langCode));
                    lang2ResetBtn.setText(Translate.translate("Reset", "en", langCode));
                }
            });
        }
    }    
    
    private void actionListnerTranslate(java.awt.event.ActionEvent evt) {                                             
        int user = Integer.parseInt(((JButton)evt.getSource()).getName());
        String user1Result, user2Result, message;

        if (user == 1){
            message = lang1Text.getText();
            user1Result = Translate.translate(message, Settings.getLang1(), Settings.getLang2());
            user1Result = user1Result.replaceAll("&#39;","\'") + "\n";

            StyledDocument sdoc = displayPane.getStyledDocument();
            SimpleAttributeSet leftAlign = new SimpleAttributeSet();
            StyleConstants.setAlignment(leftAlign, StyleConstants.ALIGN_LEFT);
            int length = sdoc.getLength();
            
            try {
                sdoc.insertString(length, message + "\n" + user1Result, null);
                sdoc.setParagraphAttributes(length+1, 1, leftAlign, false);
            } catch (BadLocationException ex) {
                Logger.getLogger(TranslateInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            lang1Text.setText("");
        }else {
            message = lang2Text.getText();
            user2Result = Translate.translate(message, Settings.getLang2(), Settings.getLang1());
            user2Result = user2Result.replaceAll("&#39;","\'");
            
            StyledDocument sdoc = displayPane.getStyledDocument();
            SimpleAttributeSet rightAlign = new SimpleAttributeSet();            
            StyleConstants.setAlignment(rightAlign, StyleConstants.ALIGN_RIGHT);
            int length = sdoc.getLength();
            
            try {
                sdoc.insertString(length, user2Result + "\n" + message + "\n", null);
                sdoc.setParagraphAttributes(length+1, 1, rightAlign, false);
                sdoc.setParagraphAttributes(length + user2Result.length()+1, 1, rightAlign, false);
            } catch (BadLocationException ex) {
                Logger.getLogger(TranslateInterface.class.getName()).log(Level.SEVERE, null, ex);
            };
            lang2Text.setText("");
        }
        
        displayPane.setCaretPosition(displayPane.getDocument().getLength());
    } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lang1TranslateBox = new javax.swing.JScrollPane();
        lang1Text = new javax.swing.JTextArea();
        lang2TranslateBox = new javax.swing.JScrollPane();
        lang2Text = new javax.swing.JTextArea();
        lang2TranslateBtn = new javax.swing.JButton();
        lang1TranslateBtn = new javax.swing.JButton();
        lang1ResetBtn = new javax.swing.JButton();
        lang2ResetBtn = new javax.swing.JButton();
        user1ComboBox = new javax.swing.JComboBox();
        user2ComboBox = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayPane = new javax.swing.JTextPane();

        setBackground(new java.awt.Color(54, 57, 59));
        setPreferredSize(new java.awt.Dimension(586, 469));

        lang1TranslateBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(3, 101, 100), 2, true));
        lang1TranslateBox.setOpaque(false);

        lang1Text.setBackground(new java.awt.Color(188, 189, 172));
        lang1Text.setColumns(20);
        lang1Text.setLineWrap(true);
        lang1Text.setRows(5);
        lang1Text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lang1TextMouseClicked(evt);
            }
        });
        lang1TranslateBox.setViewportView(lang1Text);

        lang2TranslateBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(3, 101, 100), 2, true));
        lang2TranslateBox.setOpaque(false);

        lang2Text.setBackground(new java.awt.Color(188, 189, 172));
        lang2Text.setColumns(20);
        lang2Text.setLineWrap(true);
        lang2Text.setRows(5);
        lang2Text.setWrapStyleWord(true);
        lang2Text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lang2TextMouseClicked(evt);
            }
        });
        lang2TranslateBox.setViewportView(lang2Text);

        lang2TranslateBtn.setBackground(new java.awt.Color(232, 221, 203));
        lang2TranslateBtn.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        lang2TranslateBtn.setForeground(new java.awt.Color(3, 54, 73));
        lang2TranslateBtn.setText("Translate");
        lang2TranslateBtn.setName("2"); // NOI18N

        lang1TranslateBtn.setBackground(new java.awt.Color(232, 221, 203));
        lang1TranslateBtn.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        lang1TranslateBtn.setForeground(new java.awt.Color(3, 54, 73));
        lang1TranslateBtn.setText("Translate");
        lang1TranslateBtn.setName("1"); // NOI18N

        lang1ResetBtn.setBackground(new java.awt.Color(232, 221, 203));
        lang1ResetBtn.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        lang1ResetBtn.setForeground(new java.awt.Color(3, 54, 73));
        lang1ResetBtn.setText("Reset");
        lang1ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lang1ResetBtnActionPerformed(evt);
            }
        });

        lang2ResetBtn.setBackground(new java.awt.Color(232, 221, 203));
        lang2ResetBtn.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        lang2ResetBtn.setForeground(new java.awt.Color(3, 54, 73));
        lang2ResetBtn.setText("Reset");
        lang2ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lang2ResetBtnActionPerformed(evt);
            }
        });

        user1ComboBox.setModel(new javax.swing.DefaultComboBoxModel(languages.lang));
        user1ComboBox.setBorder(null);

        user2ComboBox.setModel(new javax.swing.DefaultComboBoxModel(languages.lang));

        jScrollPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(3, 101, 100), 2, true));
        jScrollPane2.setOpaque(false);

        displayPane.setBackground(new java.awt.Color(188, 189, 172));
        displayPane.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jScrollPane2.setViewportView(displayPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lang1TranslateBox)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lang1TranslateBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lang1ResetBtn))
                            .addComponent(user1ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lang2TranslateBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(lang2ResetBtn))
                            .addComponent(user2ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lang2TranslateBox, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(user1ComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(user2ComboBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lang1ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lang1ResetBtnActionPerformed
        lang1Text.setText("");
    }//GEN-LAST:event_lang1ResetBtnActionPerformed

    private void lang2ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lang2ResetBtnActionPerformed
        lang2Text.setText("");
    }//GEN-LAST:event_lang2ResetBtnActionPerformed

    private void lang1TextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lang1TextMouseClicked
        if(firstTime1){
            lang1Text.setText("");
        }
        firstTime1 = false;
    }//GEN-LAST:event_lang1TextMouseClicked

    private void lang2TextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lang2TextMouseClicked
        if(firstTime2){
            lang2Text.setText("");
        }
        firstTime2 = false;
    }//GEN-LAST:event_lang2TextMouseClicked

    private void user1ComboBoxAction(ActionEvent evt){
        int selected = ((JComboBox)evt.getSource()).getSelectedIndex();
        
        if(languages.langCode[selected] == "en"){
            lang1TranslateBtn.setText("Translate");
            lang1ResetBtn.setText("Reset");
            lang1Text.setText("What would you like to translate?");
        }else{
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    lang1TranslateBtn.setText(Translate.translate("Translate", "en", languages.langCode[selected]));
                    lang1ResetBtn.setText(Translate.translate("Reset", "en", languages.langCode[selected]));
                    lang1Text.setText(Translate.translate("What would you like to translate?", "en", languages.langCode[selected]));

                }
            });
        }
        firstTime1 = true;
        System.out.println("User 1 Language updated to: " + languages.lang[selected]);
        Settings.setLang1(languages.lang[selected], languages.langCode[selected]);
    }
    
    private void user2ComboBoxAction(ActionEvent evt){
        int selected = ((JComboBox)evt.getSource()).getSelectedIndex();
        

        if(languages.langCode[selected] == "en"){
            lang2TranslateBtn.setText("Translate");
            lang2ResetBtn.setText("Reset");
            lang2Text.setText("What would you like to translate?");
        }else{
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    lang2TranslateBtn.setText(Translate.translate("Translate", "en", languages.langCode[selected]));
                    lang2ResetBtn.setText(Translate.translate("Reset", "en", languages.langCode[selected]));
                    lang2Text.setText(Translate.translate("What would you like to translate?", "en", languages.langCode[selected]));
                }
            });
        }
        firstTime2 = true;
        System.out.println("User 2 Language updated to: " + languages.lang[selected]);
        Settings.setLang2(languages.lang[selected], languages.langCode[selected]);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane displayPane;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JButton lang1ResetBtn;
    private javax.swing.JTextArea lang1Text;
    private javax.swing.JScrollPane lang1TranslateBox;
    private static javax.swing.JButton lang1TranslateBtn;
    private static javax.swing.JButton lang2ResetBtn;
    private javax.swing.JTextArea lang2Text;
    private javax.swing.JScrollPane lang2TranslateBox;
    private static javax.swing.JButton lang2TranslateBtn;
    private static javax.swing.JComboBox user1ComboBox;
    private static javax.swing.JComboBox user2ComboBox;
    // End of variables declaration//GEN-END:variables
}

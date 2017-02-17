
package agenda;

import java.awt.Dimension;
import java.awt.Toolkit;
import Menu.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class JAdministrador extends javax.swing.JFrame {

    public JAdministrador() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JB_voltar = new javax.swing.JButton();
        JL_title = new javax.swing.JLabel();
        JB_voltar1 = new javax.swing.JButton();
        JB_visualiza1 = new javax.swing.JButton();
        JB_alter = new javax.swing.JButton();
        JB_del = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JT_quant = new javax.swing.JTextPane();
        JB_user = new javax.swing.JButton();
        JB_events = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        JB_voltar.setText("Voltar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JL_title.setFont(new java.awt.Font("Traditional Arabic", 2, 36)); // NOI18N
        JL_title.setForeground(new java.awt.Color(204, 0, 51));
        JL_title.setText("Administrador");

        JB_voltar1.setText("Sair");
        JB_voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_voltar1ActionPerformed(evt);
            }
        });

        JB_visualiza1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JB_visualiza1.setText("Vizualizar Log");
        JB_visualiza1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_visualiza1ActionPerformed(evt);
            }
        });

        JB_alter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JB_alter.setText("Alterar Pessoa ou Conta");
        JB_alter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_alterActionPerformed(evt);
            }
        });

        JB_del.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JB_del.setText("Deletar Pessoa ou Conta");
        JB_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_delActionPerformed(evt);
            }
        });

        JT_quant.setEditable(false);
        jScrollPane1.setViewportView(JT_quant);

        JB_user.setText("Usuarios");
        JB_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_userActionPerformed(evt);
            }
        });

        JB_events.setText("Eventos");
        JB_events.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_eventsActionPerformed(evt);
            }
        });

        jLabel3.setText("Ver quantidades:");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Compor Eventos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(JB_alter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JB_del))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JB_voltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JL_title, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JB_visualiza1)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JB_user)
                            .addComponent(jLabel3)
                            .addComponent(JB_events))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JB_alter, JB_del});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_title)
                    .addComponent(JB_visualiza1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_alter, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_del, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(JB_user)
                        .addGap(18, 18, 18)
                        .addComponent(JB_events))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(JB_voltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {JB_alter, JB_del, JB_visualiza1});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_voltar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_JB_voltar1ActionPerformed

    private void JB_visualiza1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_visualiza1ActionPerformed
         Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        
          JVerLog jvl = new JVerLog();        
             jvl.setLocation((tela.width - jvl.getSize().width)/2,(tela.height - jvl.getSize().height)/2);
             jvl.show();
             this.dispose();
    }//GEN-LAST:event_JB_visualiza1ActionPerformed

    private void JB_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_delActionPerformed
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        
          JAdmDeletar jad = new JAdmDeletar();        
             jad.setLocation((tela.width - jad.getSize().width)/2,(tela.height - jad.getSize().height)/2);
             jad.show();
             this.dispose();
             Comandos cd = new Comandos();
             cd.quantidadeUsuarios();
    }//GEN-LAST:event_JB_delActionPerformed

    private void JB_alterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_alterActionPerformed
         Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        
          JAdmAlterar jaa = new JAdmAlterar();        
             jaa.setLocation((tela.width - jaa.getSize().width)/2,(tela.height - jaa.getSize().height)/2);
             jaa.show();
             this.dispose();
    }//GEN-LAST:event_JB_alterActionPerformed

    private void JB_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_userActionPerformed
         StyledDocument doc = JT_quant.getStyledDocument();
         Comandos cd = new Comandos();
         String quant = cd.quantidadeUsuarios();
         
        try {
                        doc.remove(0, doc.getLength());
			doc.insertString(doc.getLength(), quant, null);
        }
        catch (BadLocationException ex) {
            Logger.getLogger(JBuscaEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JB_userActionPerformed

    private void JB_eventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_eventsActionPerformed
        StyledDocument doc = JT_quant.getStyledDocument();
         Comandos cd = new Comandos();
         String quant = cd.quantidadeEventos();
         
        try {
                        doc.remove(0, doc.getLength());
			doc.insertString(doc.getLength(), quant, null);
        }
        catch (BadLocationException ex) {
            Logger.getLogger(JBuscaEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JB_eventsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         JComporEvento jce = new JComporEvento();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        jce.setLocation((tela.width - jce.getSize().width)/2,(tela.height - jce.getSize().height)/2);
        jce.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JAdministrador().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_alter;
    private javax.swing.JButton JB_del;
    private javax.swing.JButton JB_events;
    private javax.swing.JButton JB_user;
    private javax.swing.JButton JB_visualiza1;
    private javax.swing.JButton JB_voltar;
    private javax.swing.JButton JB_voltar1;
    private javax.swing.JLabel JL_title;
    private javax.swing.JTextPane JT_quant;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

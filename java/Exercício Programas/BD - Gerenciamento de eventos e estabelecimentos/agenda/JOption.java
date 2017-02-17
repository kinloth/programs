package agenda;

import java.awt.Dimension;
import java.awt.Toolkit;

public class JOption extends javax.swing.JFrame {

  
    public JOption() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_title = new javax.swing.JLabel();
        JL_acesso = new javax.swing.JLabel();
        JB_alter = new javax.swing.JButton();
        JB_senha = new javax.swing.JButton();
        JB_voltar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JL_title.setFont(new java.awt.Font("Traditional Arabic", 2, 36)); // NOI18N
        JL_title.setForeground(new java.awt.Color(204, 0, 51));
        JL_title.setText("Opções");

        JL_acesso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_acesso.setText("Ultimo acesso:");

        JB_alter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JB_alter.setText("Alterar Dados");
        JB_alter.setToolTipText("");
        JB_alter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_alterActionPerformed(evt);
            }
        });

        JB_senha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JB_senha.setText("Alterar Senha");
        JB_senha.setToolTipText("");
        JB_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_senhaActionPerformed(evt);
            }
        });

        JB_voltar.setText("Voltar");
        JB_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_voltarActionPerformed(evt);
            }
        });

        jTextField1.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JB_voltar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(JL_acesso))
                        .addComponent(JL_title, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(JB_alter)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(JB_senha)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_acesso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_alter, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(JB_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_senhaActionPerformed
       JAlterSenha jas = new JAlterSenha();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        jas.setLocation((tela.width - jas.getSize().width)/2,(tela.height - jas.getSize().height)/2);
        jas.show();
        this.dispose();
    }//GEN-LAST:event_JB_senhaActionPerformed

    private void JB_alterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_alterActionPerformed
       JAlterDados jad= new JAlterDados();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        jad.setLocation((tela.width - jad.getSize().width)/2,(tela.height - jad.getSize().height)/2);
        jad.show();
        this.dispose();
    }//GEN-LAST:event_JB_alterActionPerformed

    private void JB_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_voltarActionPerformed
        JPrincipal jp = new JPrincipal();
            Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
            jp.setLocation((tela.width - jp.getSize().width)/2,(tela.height - jp.getSize().height)/2);
            jp.show();
            this.dispose();
    }//GEN-LAST:event_JB_voltarActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JOption().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_alter;
    private javax.swing.JButton JB_senha;
    private javax.swing.JButton JB_voltar;
    private javax.swing.JLabel JL_acesso;
    private javax.swing.JLabel JL_title;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

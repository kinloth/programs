package agenda;

import java.awt.Dimension;
import java.awt.Toolkit;

public class JMensagem extends javax.swing.JFrame {

    public JMensagem() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_title = new javax.swing.JLabel();
        JB_visualizar = new javax.swing.JButton();
        JB_escrever = new javax.swing.JButton();
        JB_voltar = new javax.swing.JButton();
        JL_acesso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JL_title.setFont(new java.awt.Font("Traditional Arabic", 2, 36)); // NOI18N
        JL_title.setForeground(new java.awt.Color(204, 0, 51));
        JL_title.setText("Mensagens");

        JB_visualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JB_visualizar.setText("Visualizar");
        JB_visualizar.setToolTipText("");
        JB_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_visualizarActionPerformed(evt);
            }
        });

        JB_escrever.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JB_escrever.setText("Escrever");
        JB_escrever.setToolTipText("");
        JB_escrever.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_escreverActionPerformed(evt);
            }
        });

        JB_voltar.setText("Voltar");
        JB_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_voltarActionPerformed(evt);
            }
        });

        JL_acesso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_acesso.setText("Novas Mensagens:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JB_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_title, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JB_escrever, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(JB_visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JL_acesso, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JB_escrever, JB_visualizar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JL_acesso, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_escrever, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(JB_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {JB_escrever, JB_visualizar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_voltarActionPerformed
        JPrincipal jp = new JPrincipal();
            Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
            jp.setLocation((tela.width - jp.getSize().width)/2,(tela.height - jp.getSize().height)/2);
            jp.show();
            this.dispose();
    }//GEN-LAST:event_JB_voltarActionPerformed

    private void JB_escreverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_escreverActionPerformed
       JComporMensagem jcm = new JComporMensagem();
            Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
            jcm.setLocation((tela.width - jcm.getSize().width)/2,(tela.height - jcm.getSize().height)/2);
            jcm.show();
            this.dispose();
    }//GEN-LAST:event_JB_escreverActionPerformed

    private void JB_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_visualizarActionPerformed
        JVerMensagem jvm = new JVerMensagem();
            Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
            jvm.setLocation((tela.width - jvm.getSize().width)/2,(tela.height - jvm.getSize().height)/2);
            jvm.show();
            this.dispose();
    }//GEN-LAST:event_JB_visualizarActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JMensagem().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_escrever;
    private javax.swing.JButton JB_visualizar;
    private javax.swing.JButton JB_voltar;
    private javax.swing.JLabel JL_acesso;
    private javax.swing.JLabel JL_title;
    // End of variables declaration//GEN-END:variables
}

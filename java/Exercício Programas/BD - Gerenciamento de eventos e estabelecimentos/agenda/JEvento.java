package agenda;

import java.awt.Dimension;
import java.awt.Toolkit;

public class JEvento extends javax.swing.JFrame {

    public JEvento() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_title = new javax.swing.JLabel();
        JB_escrever = new javax.swing.JButton();
        JB_visualizar = new javax.swing.JButton();
        JB_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JL_title.setFont(new java.awt.Font("Traditional Arabic", 2, 36)); // NOI18N
        JL_title.setForeground(new java.awt.Color(204, 0, 51));
        JL_title.setText("Eventos");

        JB_escrever.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JB_escrever.setText("Procura/Agenda");
        JB_escrever.setToolTipText("");
        JB_escrever.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_escreverActionPerformed(evt);
            }
        });

        JB_visualizar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JB_visualizar.setText("Visualizar");
        JB_visualizar.setToolTipText("");
        JB_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_visualizarActionPerformed(evt);
            }
        });

        JB_voltar.setText("Voltar");
        JB_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_voltarActionPerformed(evt);
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
                        .addComponent(JB_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_title, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JB_escrever, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JB_visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_title)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_escrever, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(JB_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

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
         JProcAgendaEvento jpae = new JProcAgendaEvento();
            Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
            jpae.setLocation((tela.width - jpae.getSize().width)/2,(tela.height - jpae.getSize().height)/2);
            jpae.show();
            this.dispose();
    }//GEN-LAST:event_JB_escreverActionPerformed

    private void JB_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_visualizarActionPerformed
        JVerEvento jve = new JVerEvento();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        jve.setLocation((tela.width - jve.getSize().width)/2,(tela.height - jve.getSize().height)/2);
        jve.show();
        this.dispose();
    }//GEN-LAST:event_JB_visualizarActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JEvento().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_escrever;
    private javax.swing.JButton JB_visualizar;
    private javax.swing.JButton JB_voltar;
    private javax.swing.JLabel JL_title;
    // End of variables declaration//GEN-END:variables
}

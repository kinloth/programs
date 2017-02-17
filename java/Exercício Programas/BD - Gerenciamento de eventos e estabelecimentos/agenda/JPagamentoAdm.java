
package agenda;

import java.awt.Dimension;
import java.awt.Toolkit;

public class JPagamentoAdm extends javax.swing.JFrame {

   
    public JPagamentoAdm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_title = new javax.swing.JLabel();
        CB_usuarios = new javax.swing.JComboBox();
        JL_usuarios = new javax.swing.JLabel();
        JB_voltar = new javax.swing.JButton();
        JB_autoriza = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JL_title.setFont(new java.awt.Font("Traditional Arabic", 2, 36)); // NOI18N
        JL_title.setForeground(new java.awt.Color(204, 0, 51));
        JL_title.setText("Pagamento");

        CB_usuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JL_usuarios.setText("Conta:");

        JB_voltar.setText("Voltar");
        JB_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_voltarActionPerformed(evt);
            }
        });

        JB_autoriza.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JB_autoriza.setText("Autorizar");
        JB_autoriza.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_title, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_usuarios)
                        .addGap(25, 25, 25)
                        .addComponent(CB_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(JB_autoriza, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(JB_voltar)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_title)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_usuarios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JB_voltar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JB_autoriza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_voltarActionPerformed
         JPagamentoAdm jpa = new JPagamentoAdm();
            Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
            jpa.setLocation((tela.width - jpa.getSize().width)/2,(tela.height - jpa.getSize().height)/2);
            jpa.show();
            this.dispose();
    }//GEN-LAST:event_JB_voltarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPagamentoAdm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CB_usuarios;
    private javax.swing.JButton JB_autoriza;
    private javax.swing.JButton JB_voltar;
    private javax.swing.JLabel JL_title;
    private javax.swing.JLabel JL_usuarios;
    // End of variables declaration//GEN-END:variables
}

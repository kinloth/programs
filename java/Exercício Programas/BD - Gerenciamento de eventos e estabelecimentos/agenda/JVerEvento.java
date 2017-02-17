package agenda;

import java.awt.Dimension;
import java.awt.Toolkit;

public class JVerEvento extends javax.swing.JFrame {

    public JVerEvento() {
        initComponents();
    }

 private int tipo_busca = 1; //1 = cod; 2 = bairro, 3 = cidade;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG_busca = new javax.swing.ButtonGroup();
        JL_title = new javax.swing.JLabel();
        JB_filtrar = new javax.swing.JButton();
        JB_voltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        JL_filtro = new javax.swing.JLabel();
        JR_cod = new javax.swing.JRadioButton();
        JR_cid = new javax.swing.JRadioButton();
        JR_bairro = new javax.swing.JRadioButton();
        JT_campo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        BG_busca.add(JR_cod);
        BG_busca.add(JR_cid);
        BG_busca.add(JR_bairro);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JL_title.setFont(new java.awt.Font("Traditional Arabic", 2, 36)); // NOI18N
        JL_title.setForeground(new java.awt.Color(204, 0, 51));
        JL_title.setText("Eventos");

        JB_filtrar.setText("Buscar");
        JB_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_filtrarActionPerformed(evt);
            }
        });

        JB_voltar.setText("Voltar");
        JB_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_voltarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane1);

        JL_filtro.setText("Buscar por:");

        JR_cod.setSelected(true);
        JR_cod.setText("Codigo");
        JR_cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JR_codActionPerformed(evt);
            }
        });

        JR_cid.setText("Cidade");
        JR_cid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JR_cidActionPerformed(evt);
            }
        });

        JR_bairro.setText("Bairro");
        JR_bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JR_bairroActionPerformed(evt);
            }
        });

        jLabel1.setText("Resultados:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_title, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JT_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JB_filtrar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JR_cod)
                                .addGap(18, 18, 18)
                                .addComponent(JR_bairro)
                                .addGap(18, 18, 18)
                                .addComponent(JR_cid))
                            .addComponent(JL_filtro)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JB_voltar))))
                .addGap(333, 333, 333))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_title, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JL_filtro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JR_cod)
                    .addComponent(JR_cid)
                    .addComponent(JR_bairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JB_filtrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JT_campo))
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JB_voltar, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 349, 466);
    }// </editor-fold>//GEN-END:initComponents

    private void JR_cidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JR_cidActionPerformed
        tipo_busca = 3;
    }//GEN-LAST:event_JR_cidActionPerformed

    private void JB_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_voltarActionPerformed
        JEvento je = new JEvento();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        je.setLocation((tela.width - je.getSize().width)/2,(tela.height - je.getSize().height)/2);
        je.show();
       
        this.dispose();
    }//GEN-LAST:event_JB_voltarActionPerformed

    private void JB_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_filtrarActionPerformed
        //adicionar a busca
    }//GEN-LAST:event_JB_filtrarActionPerformed

    private void JR_codActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JR_codActionPerformed
        tipo_busca = 1;
    }//GEN-LAST:event_JR_codActionPerformed

    private void JR_bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JR_bairroActionPerformed
        tipo_busca = 2;
    }//GEN-LAST:event_JR_bairroActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JVerEvento().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BG_busca;
    private javax.swing.JButton JB_filtrar;
    private javax.swing.JButton JB_voltar;
    private javax.swing.JLabel JL_filtro;
    private javax.swing.JLabel JL_title;
    private javax.swing.JRadioButton JR_bairro;
    private javax.swing.JRadioButton JR_cid;
    private javax.swing.JRadioButton JR_cod;
    private javax.swing.JTextField JT_campo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}

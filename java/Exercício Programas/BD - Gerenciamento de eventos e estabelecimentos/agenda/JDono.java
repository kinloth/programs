package agenda;

import java.awt.Dimension;
import java.awt.Toolkit;

public class JDono extends javax.swing.JFrame {
    private String[] args;
	
    public JDono() {
        initComponents();
    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_title = new javax.swing.JLabel();
        JB_alter = new javax.swing.JButton();
        JB_visualiza = new javax.swing.JButton();
        JB_cadastrar = new javax.swing.JButton();
        JB_voltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JB_senha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JL_title.setFont(new java.awt.Font("Traditional Arabic", 2, 36)); // NOI18N
        JL_title.setForeground(new java.awt.Color(204, 0, 51));
        JL_title.setText("Dono");

        JB_alter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JB_alter.setText("Alterar Dados");
        JB_alter.setToolTipText("");
        JB_alter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_alterActionPerformed(evt);
            }
        });

        JB_visualiza.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JB_visualiza.setText("Visualizar");
        JB_visualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_visualizaActionPerformed(evt);
            }
        });

        JB_cadastrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JB_cadastrar.setText("Cadastrar");
        JB_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_cadastrarActionPerformed(evt);
            }
        });

        JB_voltar.setText("Voltar");
        JB_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_voltarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Estabelecimentos:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Dados Pessoais:");

        JB_senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JB_senha.setText("Alterar Senha");
        JB_senha.setToolTipText("");
        JB_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_senhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_title, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JB_alter, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JB_senha))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JB_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JB_visualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JB_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JB_cadastrar, JB_visualiza});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JB_alter, JB_senha});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(JL_title)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JB_visualiza, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_alter, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(JB_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {JB_cadastrar, JB_visualiza});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {JB_alter, JB_senha});

        setBounds(0, 0, 308, 391);
    }// </editor-fold>//GEN-END:initComponents

    private void JB_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_voltarActionPerformed
        Menu.Agenda ag = new Menu.Agenda();
        ag.main(args);
        this.dispose();
    }//GEN-LAST:event_JB_voltarActionPerformed

    private void JB_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_cadastrarActionPerformed
      JCadEstabelecimento jbe = new JCadEstabelecimento();
       Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        jbe.setLocation((tela.width - jbe.getSize().width)/2,(tela.height - jbe.getSize().height)/2);
        jbe.show();
        this.dispose();
    }//GEN-LAST:event_JB_cadastrarActionPerformed

    private void JB_visualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_visualizaActionPerformed
       JEstabelecimento je = new JEstabelecimento();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        je.setLocation((tela.width - je.getSize().width)/2,(tela.height - je.getSize().height)/2);
        je.show();
        this.dispose();      
    }//GEN-LAST:event_JB_visualizaActionPerformed

    private void JB_alterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_alterActionPerformed
        JAlterDados jad= new JAlterDados();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        jad.setLocation((tela.width - jad.getSize().width)/2,(tela.height - jad.getSize().height)/2);
        jad.show();
        this.dispose();
    }//GEN-LAST:event_JB_alterActionPerformed

    private void JB_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_senhaActionPerformed
        JAlterSenha jas = new JAlterSenha();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        jas.setLocation((tela.width - jas.getSize().width)/2,(tela.height - jas.getSize().height)/2);
        jas.show();
        this.dispose();
    }//GEN-LAST:event_JB_senhaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JDono().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_alter;
    private javax.swing.JButton JB_cadastrar;
    private javax.swing.JButton JB_senha;
    private javax.swing.JButton JB_visualiza;
    private javax.swing.JButton JB_voltar;
    private javax.swing.JLabel JL_title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

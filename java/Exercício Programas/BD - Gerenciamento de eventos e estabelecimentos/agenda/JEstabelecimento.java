package agenda;

import java.awt.Dimension;
import java.awt.Toolkit;
import Menu.*;

public class JEstabelecimento extends javax.swing.JFrame {

    public JEstabelecimento() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

		Comandos cd = new Comandos();
		String resultadoBusca[] = cd.buscaEstabelecimento(UsuarioAtual.getInstace().ID);
		
		/* 
		0 = CNPJ
		1 = Nome
		2 = Descricao
		3 = Tipo
		4 = Rua
		5 = Cidade
		6 = UF
		7 = Bairro
		8 = Numero_casa
		*/
		
		if(resultadoBusca[0] == null) System.out.println("nada");
		
        JF_cnpj = new javax.swing.JTextField(resultadoBusca[0]);
        JF_nome = new javax.swing.JTextField(resultadoBusca[1]);
        JA_desc = new javax.swing.JTextArea(resultadoBusca[2]);
        JC_tipo = new javax.swing.JComboBox();
        JT_rua = new javax.swing.JTextField(resultadoBusca[4]);
        JT_cidade = new javax.swing.JTextField(resultadoBusca[5]);
        JC_UF = new javax.swing.JComboBox();
        JT_bairro = new javax.swing.JTextField(resultadoBusca[7]);
        JT_num = new javax.swing.JTextField(resultadoBusca[8]);
        JL_title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JB_voltar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel5 = new javax.swing.JLabel();
        JL_desc = new javax.swing.JLabel();
        JL_tipo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JL_nome = new javax.swing.JLabel();
        JL_cnpj = new javax.swing.JLabel();
		
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JL_title.setFont(new java.awt.Font("Traditional Arabic", 2, 36)); // NOI18N
        JL_title.setForeground(new java.awt.Color(204, 0, 51));
        JL_title.setText("Estabelecimento");

        JT_rua.setEnabled(false);

        JC_UF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		JC_UF.setSelectedItem(resultadoBusca[6]);
		
        jLabel1.setText("Rua:");

        JB_voltar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JB_voltar1.setText("Voltar");
        JB_voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_voltar1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Cidade:");

        JT_bairro.setEnabled(false);
        JT_bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_bairroActionPerformed(evt);
            }
        });

        JA_desc.setEditable(false);
        JA_desc.setColumns(20);
        JA_desc.setRows(5);
        JA_desc.setEnabled(false);
        jScrollPane1.setViewportView(JA_desc);

        jLabel5.setText("UF:");

        JL_desc.setText("Descrição:");

        JT_cidade.setEnabled(false);
        JT_cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_cidadeActionPerformed(evt);
            }
        });

        JL_tipo.setText("Tipo:");

        jLabel3.setText("Bairro:");

        jLabel2.setText("Numero:");

        JC_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alimentação", "Lazer e Turismo", "Hospedagem" }));
		JC_tipo.setSelectedItem(resultadoBusca[3]);
		
        JL_nome.setText("Nome:");

        JT_num.setEnabled(false);

        JF_nome.setEnabled(false);

        JL_cnpj.setText("CNPJ:");
        JL_cnpj.setToolTipText("");

        JF_cnpj.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_nome)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(JL_cnpj))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(JT_num, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3))
                                    .addComponent(JT_cidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JC_UF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))
                                    .addComponent(JT_bairro)))
                            .addComponent(JF_nome)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(JF_cnpj)
                                .addGap(35, 35, 35)
                                .addComponent(JL_tipo)
                                .addGap(18, 18, 18)
                                .addComponent(JC_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JT_rua, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JB_voltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JL_desc)
                            .addComponent(JL_title, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_title)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_nome)
                    .addComponent(JF_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JF_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_cnpj)
                    .addComponent(JL_tipo)
                    .addComponent(JC_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JT_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JT_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(JT_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JT_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(JC_UF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(JL_desc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(JB_voltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_voltar1ActionPerformed
        JDono jd = new JDono();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        jd.setLocation((tela.width - jd.getSize().width)/2,(tela.height - jd.getSize().height)/2);
        jd.show();

        this.dispose();
    }//GEN-LAST:event_JB_voltar1ActionPerformed

    private void JT_bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_bairroActionPerformed

    private void JT_cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_cidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_cidadeActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JEstabelecimento().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JA_desc;
    private javax.swing.JButton JB_voltar1;
    private javax.swing.JComboBox JC_UF;
    private javax.swing.JComboBox JC_tipo;
    private javax.swing.JTextField JF_cnpj;
    private javax.swing.JTextField JF_nome;
    private javax.swing.JLabel JL_cnpj;
    private javax.swing.JLabel JL_desc;
    private javax.swing.JLabel JL_nome;
    private javax.swing.JLabel JL_tipo;
    private javax.swing.JLabel JL_title;
    private javax.swing.JTextField JT_bairro;
    private javax.swing.JTextField JT_cidade;
    private javax.swing.JTextField JT_num;
    private javax.swing.JTextField JT_rua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

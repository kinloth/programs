package agenda;

import Menu.*;
import java.text.*;  
import java.util.*;  
import javax.swing.JOptionPane;


public class JCadDados extends javax.swing.JFrame {
    private String[] args;

    private int TipoConta = 1;//pode ser Usuario = 1, Dono = 2, Administrador = 3.

    public JCadDados() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG_tipo = new javax.swing.ButtonGroup();
        JL_title = new javax.swing.JLabel();
        LB_nome = new javax.swing.JLabel();
        LB_nasc = new javax.swing.JLabel();
        JL_rg = new javax.swing.JLabel();
        JL_cpf = new javax.swing.JLabel();
        JL_rua = new javax.swing.JLabel();
        JL_cidade = new javax.swing.JLabel();
        cb_uf = new javax.swing.JComboBox();
        JB_cadastrar = new javax.swing.JButton();
        JB_voltar = new javax.swing.JButton();
        JF_nome = new javax.swing.JTextField();
        JF_nasc = new javax.swing.JTextField();
        JF_rg = new javax.swing.JTextField();
        JF_cpf = new javax.swing.JTextField();
        JF_rua = new javax.swing.JTextField();
        JF_cidade = new javax.swing.JTextField();
        JL_pais = new javax.swing.JLabel();
        JF_pais = new javax.swing.JTextField();
        JL_uf = new javax.swing.JLabel();
        JL_title1 = new javax.swing.JLabel();
        RB_dono = new javax.swing.JRadioButton();
        RB_user = new javax.swing.JRadioButton();
        JR_adm = new javax.swing.JRadioButton();
        TF_nome = new javax.swing.JTextField();
        JL_nome = new javax.swing.JLabel();
        JF_pass = new javax.swing.JLabel();
        JP_pass = new javax.swing.JPasswordField();
        JF_passv = new javax.swing.JLabel();
        JP_passv = new javax.swing.JPasswordField();
        JL_bairro = new javax.swing.JLabel();
        JF_bairro = new javax.swing.JTextField();
        JL_numero = new javax.swing.JLabel();
        JF_numero = new javax.swing.JTextField();
        JL_adicional = new javax.swing.JLabel();
        JF_adicionais = new javax.swing.JTextField();

        BG_tipo.add(RB_dono);
        BG_tipo.add(RB_user);
        BG_tipo.add(JR_adm);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JL_title.setFont(new java.awt.Font("Traditional Arabic", 2, 36)); // NOI18N
        JL_title.setForeground(new java.awt.Color(204, 0, 51));
        JL_title.setText("Cadastro");

        LB_nome.setText("Nome:");

        LB_nasc.setText("Data Nascimento:");

        JL_rg.setText("RG:");

        JL_cpf.setText("CPF:");

        JL_rua.setText("Rua");

        JL_cidade.setText("Cidade:");

        cb_uf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL ", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cb_uf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ufActionPerformed(evt);
            }
        });

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

        JL_pais.setText("Pais:");

        JL_uf.setText("UF");

        JL_title1.setText("Tipo de Conta");

        RB_dono.setText("Dono");
        RB_dono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_donoActionPerformed(evt);
            }
        });

        RB_user.setSelected(true);
        RB_user.setText("Usuário");
        RB_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_userActionPerformed(evt);
            }
        });

        JR_adm.setText("Administrador");
        JR_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JR_admActionPerformed(evt);
            }
        });

        JL_nome.setText("Usuario:");

        JF_pass.setText("Senha:");

        JF_passv.setText("Senha Novamente:");

        JL_bairro.setText("Bairro:");

        JF_bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JF_bairroActionPerformed(evt);
            }
        });

        JL_numero.setText("Numero:");

        JL_adicional.setText("Adicionais:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(LB_nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JF_nome))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JL_pais)
                                    .addComponent(JL_cidade)
                                    .addComponent(JL_numero))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(JF_rua, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(JF_pais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(JF_cidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(27, 27, 27)
                                                .addComponent(JL_uf)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(JL_bairro)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(JF_bairro))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(JF_rg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JF_cpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JF_nasc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JF_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JL_adicional)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JF_adicionais))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JL_title, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(JL_rg)
                                            .addComponent(LB_nasc)
                                            .addComponent(JL_cpf)
                                            .addComponent(JL_rua)
                                            .addComponent(JL_title1))
                                        .addGap(30, 30, 30)
                                        .addComponent(RB_user)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JF_pass)
                    .addComponent(JL_nome)
                    .addComponent(JF_passv)
                    .addComponent(JB_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JP_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TF_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JP_passv, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(RB_dono)
                                .addGap(18, 18, 18)
                                .addComponent(JR_adm)))
                        .addContainerGap(83, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JB_cadastrar)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JL_title)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_nome)
                    .addComponent(JF_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_nasc)
                    .addComponent(JF_nasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_rg)
                    .addComponent(JF_rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_cpf)
                    .addComponent(JF_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_rua)
                    .addComponent(JF_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_bairro)
                    .addComponent(JF_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JF_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_numero)
                    .addComponent(JL_adicional)
                    .addComponent(JF_adicionais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JL_cidade)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JF_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JL_uf)
                        .addComponent(cb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_pais)
                    .addComponent(JF_pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_title1)
                    .addComponent(RB_user)
                    .addComponent(RB_dono)
                    .addComponent(JR_adm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_nome)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TF_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JP_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JF_pass))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JP_passv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JF_passv))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_voltar)
                    .addComponent(JB_cadastrar))
                .addGap(20, 20, 20))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {JP_pass, JP_passv, TF_nome});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_voltarActionPerformed
        Agenda.main(args);
        this.dispose();
    }//GEN-LAST:event_JB_voltarActionPerformed

    private void JB_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_cadastrarActionPerformed
        Comandos cd = new Comandos();
        if(!cd.confere(JF_nome.getText(), "seu nome"))                    return;
        if(!cd.confere(JF_nasc.getText(), "a data de seu nascimento"))    return;
        if(!cd.confere(JF_rg.getText(), "seu RG"))                        return;
        if(!cd.confere(JF_rua.getText(), "sua rua"))                      return;
        if(!cd.confere(JF_numero.getText(), "seu numero"))                return;
        if(!cd.confere(JF_bairro.getText(), "seu bairro"))                return;
        if(!cd.confere(JF_cidade.getText(), "sua cidade"))                return;
        if(!cd.confere(JF_pais.getText(), "seu pais de origem"))          return;
        
        if (!cd.confere(JF_cpf.getText(), "o CPF"))                       return;
        
        if (!cd.confere(TF_nome.getText(), "o nome do usuário"))          return;      
        if (!cd.confere(JP_pass.getText(), "uma senha"))                  return;
        if (!JP_pass.getText().equals(JP_passv.getText()))
                  JOptionPane.showMessageDialog(null, "As senhas estão diferentes!\n");
   
            cd.inserirPessoa( Integer.parseInt(JF_cpf.getText()), JF_nome.getText(), null, Integer.parseInt(JF_rg.getText())
                     ,JF_rua.getText(), JF_cidade.getText(), cb_uf.getName(), JF_pais.getText(),JF_bairro.getText()
                    ,Integer.parseInt(JF_numero.getText()), JF_adicionais.getText() );
            
            cd.inserirConta(Integer.parseInt(JF_cpf.getText()), JP_pass.getText(), TF_nome.getText(), TipoConta);
			
			Date dataAtual = new Date();  
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			formatador.format(dataAtual);  
			if(TipoConta == 2) cd.inserirProprietario(TF_nome.getText(), new java.sql.Date(dataAtual.getTime()), null);
       
    }//GEN-LAST:event_JB_cadastrarActionPerformed

    private void RB_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_userActionPerformed
        TipoConta = 1;
    }//GEN-LAST:event_RB_userActionPerformed

    private void RB_donoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_donoActionPerformed
        TipoConta = 2;
    }//GEN-LAST:event_RB_donoActionPerformed

    private void JR_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JR_admActionPerformed
        TipoConta = 3;
    }//GEN-LAST:event_JR_admActionPerformed

    private void JF_bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JF_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JF_bairroActionPerformed

    private void cb_ufActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ufActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_ufActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCadDados().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BG_tipo;
    private javax.swing.JButton JB_cadastrar;
    private javax.swing.JButton JB_voltar;
    private javax.swing.JTextField JF_adicionais;
    private javax.swing.JTextField JF_bairro;
    private javax.swing.JTextField JF_cidade;
    private javax.swing.JTextField JF_cpf;
    private javax.swing.JTextField JF_nasc;
    private javax.swing.JTextField JF_nome;
    private javax.swing.JTextField JF_numero;
    private javax.swing.JTextField JF_pais;
    private javax.swing.JLabel JF_pass;
    private javax.swing.JLabel JF_passv;
    private javax.swing.JTextField JF_rg;
    private javax.swing.JTextField JF_rua;
    private javax.swing.JLabel JL_adicional;
    private javax.swing.JLabel JL_bairro;
    private javax.swing.JLabel JL_cidade;
    private javax.swing.JLabel JL_cpf;
    private javax.swing.JLabel JL_nome;
    private javax.swing.JLabel JL_numero;
    private javax.swing.JLabel JL_pais;
    private javax.swing.JLabel JL_rg;
    private javax.swing.JLabel JL_rua;
    private javax.swing.JLabel JL_title;
    private javax.swing.JLabel JL_title1;
    private javax.swing.JLabel JL_uf;
    private javax.swing.JPasswordField JP_pass;
    private javax.swing.JPasswordField JP_passv;
    private javax.swing.JRadioButton JR_adm;
    private javax.swing.JLabel LB_nasc;
    private javax.swing.JLabel LB_nome;
    private javax.swing.JRadioButton RB_dono;
    private javax.swing.JRadioButton RB_user;
    private javax.swing.JTextField TF_nome;
    private javax.swing.JComboBox cb_uf;
    // End of variables declaration//GEN-END:variables
}

package agenda;

import Menu.Comandos;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class JLogin extends javax.swing.JFrame {

    public JLogin() {
            initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TF_user = new javax.swing.JTextField();
        JF_user = new javax.swing.JLabel();
        JF_pass = new javax.swing.JLabel();
        login = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        JP_pass = new javax.swing.JPasswordField();
        JB_cadastrar = new javax.swing.JButton();
        bottom = new javax.swing.JLabel();
        JL_title = new javax.swing.JLabel();
        JL_logo = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bound Times");
        setResizable(false);

        JF_user.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        JF_user.setText("Usuário:");

        JF_pass.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        JF_pass.setText("Senha:");

        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/login.png"))); // NOI18N

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JB_cadastrar.setText("Cadastrar");
        JB_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_cadastrarActionPerformed(evt);
            }
        });

        bottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/login.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bottom))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                            .addComponent(JB_cadastrar))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JF_user)
                                .addComponent(JF_pass))
                            .addGap(21, 21, 21)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TF_user, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                .addComponent(JP_pass)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_user, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JF_user))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JF_pass)
                    .addComponent(JP_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(JB_cadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(login)
                    .addComponent(bottom))
                .addGap(35, 35, 35))
        );

        JL_title.setFont(new java.awt.Font("Traditional Arabic", 0, 36)); // NOI18N
        JL_title.setForeground(new java.awt.Color(204, 0, 51));
        JL_title.setText("Bound Times");

        JL_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/logo.png"))); // NOI18N

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_logo)
                            .addComponent(logo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JL_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JL_logo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JL_title)
                        .addComponent(logo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_cadastrarActionPerformed
       JCadDados cadastro = new JCadDados();
       Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	cadastro.setLocation((tela.width - cadastro.getSize().width)/2,(tela.height - cadastro.getSize().height)/2);
       cadastro.show();
       this.setVisible(false);
    }//GEN-LAST:event_JB_cadastrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Comandos cd = new Comandos();
      int tipo = cd.validaSenha(TF_user.getText(), JP_pass.getText());
        if(tipo == -1){
            JOptionPane.showMessageDialog(null, "Usuário ou senha inválido!\n");
        }else if(tipo == 3){ // adm
            
            JAdministrador jad = new JAdministrador();
			new UsuarioAtual(TF_user.getText(), 3);
                        
                        cd.session(UsuarioAtual.getInstace().ID);
                        
            Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
            jad.setLocation((tela.width - jad.getSize().width)/2,(tela.height - jad.getSize().height)/2);
            jad.show();
            this.dispose();
        }else if(tipo == 2){ //dono
            JDono jd = new JDono();
			new UsuarioAtual(TF_user.getText(), 2);
            Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
            jd.setLocation((tela.width - jd.getSize().width)/2,(tela.height - jd.getSize().height)/2);
            jd.show();
            this.dispose();
        }else if(tipo == 1){//usuário
            JPrincipal jp = new JPrincipal();
			new UsuarioAtual(TF_user.getText(), 1);
            Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
            jp.setLocation((tela.width - jp.getSize().width)/2,(tela.height - jp.getSize().height)/2);
            jp.show();
            this.dispose();
        }else 
            JOptionPane.showMessageDialog(null, "Tipo inválido, verifique o banco!\n");
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        
            
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new JLogin().setVisible(true);
            }
        });
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_cadastrar;
    private javax.swing.JLabel JF_pass;
    private javax.swing.JLabel JF_user;
    private javax.swing.JLabel JL_logo;
    private javax.swing.JLabel JL_title;
    private javax.swing.JPasswordField JP_pass;
    private javax.swing.JTextField TF_user;
    private javax.swing.JLabel bottom;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel login;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}

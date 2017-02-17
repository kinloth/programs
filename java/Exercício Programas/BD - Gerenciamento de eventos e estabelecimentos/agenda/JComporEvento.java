package agenda;

import Menu.Comandos;
import java.awt.Dimension;
import java.awt.Toolkit;

public class JComporEvento extends javax.swing.JFrame {

    public JComporEvento() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_title = new javax.swing.JLabel();
        JL_endereco = new javax.swing.JLabel();
        JF_horaini = new javax.swing.JTextField();
        JL_horaini = new javax.swing.JLabel();
        cb_uf = new javax.swing.JComboBox();
        JF_cidade = new javax.swing.JTextField();
        JL_cidade = new javax.swing.JLabel();
        JF_rua = new javax.swing.JTextField();
        JL_horafim = new javax.swing.JLabel();
        JF_horafim = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JA_desc = new javax.swing.JTextArea();
        JB_cadastrar = new javax.swing.JButton();
        JB_voltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JL_title.setFont(new java.awt.Font("Traditional Arabic", 2, 36)); // NOI18N
        JL_title.setForeground(new java.awt.Color(204, 0, 51));
        JL_title.setText("Eventos");

        JL_endereco.setText("Rua:");

        JL_horaini.setText("Horario Inicio:");

        cb_uf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL ", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        JL_cidade.setText("Cidade:");

        JL_horafim.setText("Horario Final:");

        JA_desc.setColumns(20);
        JA_desc.setRows(5);
        jScrollPane1.setViewportView(JA_desc);

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

        jLabel1.setText("UF:");

        jLabel2.setText("Descriçao:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(JB_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JB_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JL_horaini)
                                .addComponent(JL_endereco)
                                .addComponent(JL_cidade))
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(JF_horaini, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JF_cidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(cb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(JL_horafim)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(JF_horafim, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addComponent(JF_rua)))
                        .addComponent(JL_title, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1))
                    .addComponent(jLabel2))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_endereco)
                    .addComponent(JF_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_cidade)
                    .addComponent(JF_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_horaini)
                    .addComponent(JF_horaini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_horafim)
                    .addComponent(JF_horafim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JB_cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(JB_voltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_voltarActionPerformed
        JAdministrador ja = new JAdministrador(); 
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        ja.setLocation((tela.width - ja.getSize().width)/2,(tela.height - ja.getSize().height)/2);
        ja.show();       
        this.dispose();
    }//GEN-LAST:event_JB_voltarActionPerformed

    private void JB_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_cadastrarActionPerformed
       Comandos cd = new Comandos();
       cd.inserirEvento(JF_rua.getText(), JF_cidade.getText(), cb_uf.getSelectedItem().toString(), JF_horaini.getText(), 
               JF_horafim.getText() , JA_desc.getText());
    }//GEN-LAST:event_JB_cadastrarActionPerformed

    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JComporEvento().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JA_desc;
    private javax.swing.JButton JB_cadastrar;
    private javax.swing.JButton JB_voltar;
    private javax.swing.JTextField JF_cidade;
    private javax.swing.JTextField JF_horafim;
    private javax.swing.JTextField JF_horaini;
    private javax.swing.JTextField JF_rua;
    private javax.swing.JLabel JL_cidade;
    private javax.swing.JLabel JL_endereco;
    private javax.swing.JLabel JL_horafim;
    private javax.swing.JLabel JL_horaini;
    private javax.swing.JLabel JL_title;
    private javax.swing.JComboBox cb_uf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

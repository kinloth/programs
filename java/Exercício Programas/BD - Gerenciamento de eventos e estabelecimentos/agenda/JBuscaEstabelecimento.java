package agenda;

import Menu.Comandos;
import agenda.JDono;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class JBuscaEstabelecimento extends javax.swing.JFrame {

    public JBuscaEstabelecimento() {
        initComponents();
    }

 private int tipoBusca = 1;//pode ser 1 = Nome, 2 = tipo, 3 = Cidade, 4 = Bairro.
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG_busca = new javax.swing.ButtonGroup();
        JL_title = new javax.swing.JLabel();
        JL_filtro = new javax.swing.JLabel();
        JB_filtrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JT_busca = new javax.swing.JTextPane();
        JB_voltar = new javax.swing.JButton();
        JR_tipo = new javax.swing.JRadioButton();
        JR_cidade = new javax.swing.JRadioButton();
        JR_bairro = new javax.swing.JRadioButton();
        JR_nome = new javax.swing.JRadioButton();
        JT_cmpbusca = new javax.swing.JTextField();
        JL_result = new javax.swing.JLabel();

        BG_busca.add(JR_tipo);
        BG_busca.add(JR_cidade);
        BG_busca.add(JR_nome);
        BG_busca.add(JR_bairro);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JL_title.setFont(new java.awt.Font("Traditional Arabic", 2, 36)); // NOI18N
        JL_title.setForeground(new java.awt.Color(204, 0, 51));
        JL_title.setText("Estabelecimento");

        JL_filtro.setText("Busca por:");

        JB_filtrar.setText("Buscar");
        JB_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_filtrarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(JT_busca);

        JB_voltar.setText("Voltar");
        JB_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_voltarActionPerformed(evt);
            }
        });

        JR_tipo.setText("Tipo");
        JR_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JR_tipoActionPerformed(evt);
            }
        });

        JR_cidade.setText("Cidade");
        JR_cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JR_cidadeActionPerformed(evt);
            }
        });

        JR_bairro.setText("Bairro");
        JR_bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JR_bairroActionPerformed(evt);
            }
        });

        JR_nome.setSelected(true);
        JR_nome.setText("Nome");
        JR_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JR_nomeActionPerformed(evt);
            }
        });

        JL_result.setText("Resultado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_title, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JB_voltar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JT_cmpbusca)
                                        .addComponent(JL_filtro)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(JR_nome)
                                            .addGap(18, 18, 18)
                                            .addComponent(JR_tipo)
                                            .addGap(18, 18, 18)
                                            .addComponent(JR_cidade)
                                            .addGap(18, 18, 18)
                                            .addComponent(JR_bairro)))
                                    .addGap(103, 103, 103)
                                    .addComponent(JB_filtrar))
                                .addComponent(JL_result)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_filtro)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JR_cidade)
                    .addComponent(JR_bairro)
                    .addComponent(JR_nome)
                    .addComponent(JR_tipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JT_cmpbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_filtrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JL_result)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(JB_voltar)
                .addContainerGap())
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

    private void JR_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JR_tipoActionPerformed
        tipoBusca = 2;
    }//GEN-LAST:event_JR_tipoActionPerformed

    private void JR_cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JR_cidadeActionPerformed
        tipoBusca = 3;
    }//GEN-LAST:event_JR_cidadeActionPerformed

    private void JR_bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JR_bairroActionPerformed
        tipoBusca = 4;
    }//GEN-LAST:event_JR_bairroActionPerformed

    private void JR_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JR_nomeActionPerformed
       tipoBusca = 1;
    }//GEN-LAST:event_JR_nomeActionPerformed

    private void JB_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_filtrarActionPerformed
        Comandos cd = new Comandos();
        
        if(!cd.confere(JT_cmpbusca.getText(), "o respectivo conteudo da busca"))     return;
        
        String busca = "";
		if (tipoBusca == 1) busca = cd.buscaEstabelecimentoNome(JT_cmpbusca.getText());
		else if (tipoBusca == 2) busca = cd.buscaEstabelecimentoTipo(JT_cmpbusca.getText());                
		else if (tipoBusca == 3) busca = cd.buscaEstabelecimentoCidade(JT_cmpbusca.getText());
		else if (tipoBusca == 4) busca = cd.buscaEstabelecimentoBairro(JT_cmpbusca.getText());
        StyledDocument doc = JT_busca.getStyledDocument();
        try {
			doc.insertString(doc.getLength(), (busca), null);
        }
        catch (BadLocationException ex) {
            Logger.getLogger(JBuscaEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
        }
   

    }//GEN-LAST:event_JB_filtrarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JBuscaEstabelecimento().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BG_busca;
    private javax.swing.JButton JB_filtrar;
    private javax.swing.JButton JB_voltar;
    private javax.swing.JLabel JL_filtro;
    private javax.swing.JLabel JL_result;
    private javax.swing.JLabel JL_title;
    private javax.swing.JRadioButton JR_bairro;
    private javax.swing.JRadioButton JR_cidade;
    private javax.swing.JRadioButton JR_nome;
    private javax.swing.JRadioButton JR_tipo;
    private javax.swing.JTextPane JT_busca;
    private javax.swing.JTextField JT_cmpbusca;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

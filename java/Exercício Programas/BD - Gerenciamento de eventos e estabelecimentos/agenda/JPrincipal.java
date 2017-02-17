
package agenda;

import java.awt.Dimension;
import java.awt.Toolkit;

public class JPrincipal extends javax.swing.JFrame {
    private String[] args;

    public JPrincipal() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_logo = new javax.swing.JLabel();
        JL_title = new javax.swing.JLabel();
        JB_msg = new javax.swing.JButton();
        JB_estabelecimento = new javax.swing.JButton();
        JB_eventos = new javax.swing.JButton();
        JB_config = new javax.swing.JButton();
        JB_off = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");

        JL_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/logo.png"))); // NOI18N

        JL_title.setFont(new java.awt.Font("Traditional Arabic", 0, 36)); // NOI18N
        JL_title.setForeground(new java.awt.Color(204, 0, 51));
        JL_title.setText("Bound Times");

        JB_msg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JB_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/word.png"))); // NOI18N
        JB_msg.setText("Mensagens");
        JB_msg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_msgActionPerformed(evt);
            }
        });

        JB_estabelecimento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JB_estabelecimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/pedidos.png"))); // NOI18N
        JB_estabelecimento.setText("Estabelecimentos");
        JB_estabelecimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_estabelecimentoActionPerformed(evt);
            }
        });

        JB_eventos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JB_eventos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/scan.png"))); // NOI18N
        JB_eventos.setText("Eventos");
        JB_eventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_eventosActionPerformed(evt);
            }
        });

        JB_config.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JB_config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/config.png"))); // NOI18N
        JB_config.setText("Configurações");
        JB_config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_configActionPerformed(evt);
            }
        });

        JB_off.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        JB_off.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/off.png"))); // NOI18N
        JB_off.setText("Log off");
        JB_off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_offActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(JL_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(267, 267, 267))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JB_estabelecimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JB_msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JB_config, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JB_eventos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(JB_off)))
                .addGap(20, 20, 20))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JB_config, JB_estabelecimento, JB_eventos, JB_msg});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JB_off, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JL_title))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(JL_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_eventos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_estabelecimento)
                    .addComponent(JB_config, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {JB_config, JB_estabelecimento, JB_eventos, JB_msg});

        setBounds(0, 0, 642, 493);
    }// </editor-fold>//GEN-END:initComponents

    private void JB_msgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_msgActionPerformed
       JMensagem jm = new JMensagem();
       Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        jm.setLocation((tela.width - jm.getSize().width)/2,(tela.height - jm.getSize().height)/2);
        jm.show();
       
        this.dispose();
    }//GEN-LAST:event_JB_msgActionPerformed

    private void JB_eventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_eventosActionPerformed
        JEvento je = new JEvento();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        je.setLocation((tela.width - je.getSize().width)/2,(tela.height - je.getSize().height)/2);
        je.show();
       
        this.dispose();
    }//GEN-LAST:event_JB_eventosActionPerformed

    private void JB_estabelecimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_estabelecimentoActionPerformed
       JBuscaEstabelecimento jbe = new JBuscaEstabelecimento();
       Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        jbe.setLocation((tela.width - jbe.getSize().width)/2,(tela.height - jbe.getSize().height)/2);
        jbe.show();
        this.dispose();
    }//GEN-LAST:event_JB_estabelecimentoActionPerformed

    private void JB_configActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_configActionPerformed
        JOption jo = new JOption();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        jo.setLocation((tela.width - jo.getSize().width)/2,(tela.height - jo.getSize().height)/2);
        jo.show();
        this.dispose();
    }//GEN-LAST:event_JB_configActionPerformed

    private void JB_offActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_offActionPerformed
       Menu.Agenda.main(args);
       this.dispose();
    }//GEN-LAST:event_JB_offActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_config;
    private javax.swing.JButton JB_estabelecimento;
    private javax.swing.JButton JB_eventos;
    private javax.swing.JButton JB_msg;
    private javax.swing.JButton JB_off;
    private javax.swing.JLabel JL_logo;
    private javax.swing.JLabel JL_title;
    // End of variables declaration//GEN-END:variables
}

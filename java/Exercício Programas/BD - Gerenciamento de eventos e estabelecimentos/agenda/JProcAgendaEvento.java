package agenda;

import Menu.Comandos;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class JProcAgendaEvento extends javax.swing.JFrame {

    public JProcAgendaEvento() {
        initComponents();
    }
    private int cod_evento = 1;
    Comandos cd = new Comandos();

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_title = new javax.swing.JLabel();
        CB_eventos = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JT_desc = new javax.swing.JTextPane();
        JF_hoini = new javax.swing.JTextField();
        JT_horfim = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JB_agenda = new javax.swing.JButton();
        JB_voltar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JT_pane = new javax.swing.JTextPane();
        JB_Listar = new javax.swing.JButton();
        JB_event = new javax.swing.JButton();
        JB_evdia = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        JF_rua = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JF_cid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JF_uf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JL_title.setFont(new java.awt.Font("Traditional Arabic", 2, 36)); // NOI18N
        JL_title.setForeground(new java.awt.Color(204, 0, 51));
        JL_title.setText("Procura e Agenda Eventos");

        CB_eventos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CB_eventosPropertyChange(evt);
            }
        });

        jLabel1.setText("Eventos:");

        JT_desc.setEditable(false);
        jScrollPane1.setViewportView(JT_desc);

        JF_hoini.setEditable(false);

        JT_horfim.setEditable(false);

        jLabel2.setText("Horario Inicio:");

        jLabel3.setText("Horario Fim:");

        JB_agenda.setText("Agendar");
        JB_agenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_agendaActionPerformed(evt);
            }
        });

        JB_voltar.setText("Voltar");
        JB_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_voltarActionPerformed(evt);
            }
        });

        jLabel4.setText("Descriçao:");

        jScrollPane2.setViewportView(JT_pane);

        JB_Listar.setText("Listar Todos");
        JB_Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ListarActionPerformed(evt);
            }
        });

        JB_event.setText("Somente Eventos");
        JB_event.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_eventActionPerformed(evt);
            }
        });

        JB_evdia.setText("Eventos Diarios");
        JB_evdia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_evdiaActionPerformed(evt);
            }
        });

        jLabel5.setText("Rua:");

        JF_rua.setEditable(false);

        jLabel6.setText("Cidade:");

        JF_cid.setEditable(false);

        jLabel7.setText("UF:");

        JF_uf.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(JB_Listar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JB_event, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JB_evdia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JB_agenda))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_title, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JB_voltar)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(CB_eventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JF_cid, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JF_uf, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(JF_rua)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JF_hoini, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JT_horfim, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JF_hoini, JT_horfim});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(JL_title)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_eventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(JF_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JF_cid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(JF_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JF_hoini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(JT_horfim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JB_agenda)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JB_Listar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JB_event)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JB_evdia))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JB_voltar)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {JF_hoini, JT_horfim});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CB_eventosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CB_eventosPropertyChange
      //  cod_evento = Integer.parseInt(CB_eventos.getSelectedItem().toString());
    }//GEN-LAST:event_CB_eventosPropertyChange

    private void JB_agendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_agendaActionPerformed
       Comandos cd = new Comandos();
       if(!CB_eventos.getSelectedItem().toString().equals(""))
            cd.AgendaEventos(UsuarioAtual.getInstace().ID, cod_evento, JF_hoini.getText());
       
    }//GEN-LAST:event_JB_agendaActionPerformed

    private void JB_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_voltarActionPerformed
       JEvento je = new JEvento();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        je.setLocation((tela.width - je.getSize().width)/2,(tela.height - je.getSize().height)/2);
        je.show();
       
        this.dispose();
    }//GEN-LAST:event_JB_voltarActionPerformed

    private void JB_ListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ListarActionPerformed
         StyledDocument doc = JT_pane.getStyledDocument();
         Comandos cd = new Comandos();
         String quant = cd.eventosUEstabelecimentos();
         
        try {
                        doc.remove(0, doc.getLength());
			doc.insertString(doc.getLength(), quant, null);
        }
        catch (BadLocationException ex) {
            Logger.getLogger(JBuscaEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JB_ListarActionPerformed

    private void JB_eventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_eventActionPerformed
         StyledDocument doc = JT_pane.getStyledDocument();
         Comandos cd = new Comandos();
         String quant = cd.eventosNoEstabelecimento();
         
        try {
                        doc.remove(0, doc.getLength());
			doc.insertString(doc.getLength(), quant, null);
        }
        catch (BadLocationException ex) {
            Logger.getLogger(JBuscaEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JB_eventActionPerformed

    private void JB_evdiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_evdiaActionPerformed
         StyledDocument doc = JT_pane.getStyledDocument();
         Comandos cd = new Comandos();
         String quant = cd.sugereEvento();
         
        try {
                        doc.remove(0, doc.getLength());
			doc.insertString(doc.getLength(), quant, null);
        }
        catch (BadLocationException ex) {
            Logger.getLogger(JBuscaEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JB_evdiaActionPerformed

    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JProcAgendaEvento().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CB_eventos;
    private javax.swing.JButton JB_Listar;
    private javax.swing.JButton JB_agenda;
    private javax.swing.JButton JB_evdia;
    private javax.swing.JButton JB_event;
    private javax.swing.JButton JB_voltar;
    private javax.swing.JTextField JF_cid;
    private javax.swing.JTextField JF_hoini;
    private javax.swing.JTextField JF_rua;
    private javax.swing.JTextField JF_uf;
    private javax.swing.JLabel JL_title;
    private javax.swing.JTextPane JT_desc;
    private javax.swing.JTextField JT_horfim;
    private javax.swing.JTextPane JT_pane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

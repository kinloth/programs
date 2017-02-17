import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import net.miginfocom.*;
import net.miginfocom.swing.MigLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;


@SuppressWarnings("serial")
public class Grafica extends JFrame {
	private JTextField textoArquivoDeEntrada;
	private JTextField textoArquivoDeSaida;
	private JRadioButton escolhaLogCompleto;
	private final ButtonGroup GrupoArquivo = new ButtonGroup();
	private final ButtonGroup GrupoEscalonador = new ButtonGroup();
	private JRadioButton escolhaFCFS;
	private JRadioButton escolhaApenasResultados;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafica frame = new Grafica();
					frame.setVisible(true);
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	boolean abreArquivo = true;
	private JSpinner spinnerFrame;
	private final ButtonGroup GrupoCM = new ButtonGroup();
	public Grafica() {
		setResizable(false);
		setTitle("SO Simulator");
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setBounds(100, 100, 724, 558);
		
		JPanel Arquivos = new JPanel();
		
		JPanel Escalonadores = new JPanel();
		
		textoArquivoDeEntrada = new JTextField();
		textoArquivoDeEntrada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Arquivo.entrada = new File(textoArquivoDeEntrada.getText());
			}
			
		});
		
		textoArquivoDeEntrada.setColumns(10);
		
		JLabel LarquivoDeEntrada = new JLabel("Arquivo de Entrada");
		
		JLabel LarquivoDeSaida = new JLabel("Arquivo de Sa\u00EDda");
		
		textoArquivoDeSaida = new JTextField();
	
		textoArquivoDeSaida.addKeyListener(new KeyAdapter() {
				
			public void keyReleased(KeyEvent e) {
				Arquivo.saida = new File(textoArquivoDeSaida.getText());
			}
		});
	
		
		textoArquivoDeSaida.setToolTipText("Digite o carminho do arquivo de saida.");
		textoArquivoDeSaida.setColumns(10);
		escolhaLogCompleto = new JRadioButton("Log completo");
		escolhaLogCompleto.setSelected(true);
		escolhaLogCompleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estrutura.logTotal = true;
			}
		});
		
		escolhaLogCompleto.setToolTipText("Lista todos os eventos de todos os processos.");
		GrupoArquivo.add(escolhaLogCompleto);
		escolhaLogCompleto.setVerticalAlignment(SwingConstants.TOP);
		
		escolhaApenasResultados = new JRadioButton("Apenas Resultados");
		escolhaApenasResultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estrutura.logTotal = false;
			}
		});
		
		escolhaApenasResultados.setToolTipText("Escreve no arquivo apenas os resultados do escalonamento.");
		GrupoArquivo.add(escolhaApenasResultados);
		
		JLabel Larquivos = new JLabel("Arquivos");
		Larquivos.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		
		JCheckBox checkBoxAbrirNoFim = new JCheckBox("Abrir arquivo ap\u00F3s gerado.");
		checkBoxAbrirNoFim.setSelected(true);
		checkBoxAbrirNoFim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(abreArquivo) 	abreArquivo = false;
				else				abreArquivo = true;
			}
		});
		checkBoxAbrirNoFim.setToolTipText("Abrir\u00E1 o arquivo de sa\u00EDda no fim da execu\u00E7\u00E3o do programa.");
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(127, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(Escalonadores, GroupLayout.PREFERRED_SIZE, 686, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE)
								.addComponent(Arquivos, GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Arquivos, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(Escalonadores, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(169))
		);
		
		JLabel lblMemriaCentral = new JLabel("Mem\u00F3ria Central");
		lblMemriaCentral.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		
		JLabel lblQuantidadeDeMemria = new JLabel("Quantidade de Mem\u00F3ria");
		
		JLabel LB_frame = new JLabel("Frame");
		
		spinnerFrame = new JSpinner();
		spinnerFrame.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Memoria.frame = (int) spinnerFrame.getModel().getValue();
				
			}
		});
		spinnerFrame.setModel(new SpinnerNumberModel(8, 0, 999, 2));
		spinnerFrame.setToolTipText("Intervalo de tempo para o Round Robin.");
		
		JLabel LB_kbs = new JLabel("KBs");
		
		JLabel LB_kbss = new JLabel("KBs");
		
		final JSpinner spinnerMemo = new JSpinner();
		spinnerMemo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Memoria.memoTotal = (int) spinnerMemo.getValue();
			}
		});
		spinnerMemo.setModel(new SpinnerNumberModel(new Integer(36), new Integer(1), null, new Integer(4)));
		spinnerMemo.setToolTipText("Espa\u00E7o da memoria central");
		
		JRadioButton rdbtnPaginacao = new JRadioButton("Pagina\u00E7\u00E3o");
		rdbtnPaginacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Memoria.tipo = 1;
			}
		});
		rdbtnPaginacao.setSelected(true);
		GrupoCM.add(rdbtnPaginacao);
		
		JRadioButton rdbtnSegmentaoBestfit = new JRadioButton("Segmenta\u00E7\u00E3o - Best-fit");
		rdbtnSegmentaoBestfit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Memoria.tipo = 0;
			}
		});
		GrupoCM.add(rdbtnSegmentaoBestfit);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblQuantidadeDeMemria)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinnerMemo, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LB_kbs)
							.addGap(63)
							.addComponent(rdbtnPaginacao)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(LB_frame)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinnerFrame, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LB_kbss)
							.addGap(18)
							.addComponent(rdbtnSegmentaoBestfit))
						.addComponent(lblMemriaCentral, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(116, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblMemriaCentral, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantidadeDeMemria)
						.addComponent(LB_frame)
						.addComponent(spinnerFrame, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerMemo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnPaginacao)
						.addComponent(LB_kbs)
						.addComponent(LB_kbss)
						.addComponent(rdbtnSegmentaoBestfit))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel Ltitulo = new JLabel("SO Simulador");
		Ltitulo.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sobre.main(arg0);
				Grafica.this.setVisible(false);
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(209)
					.addComponent(Ltitulo)
					.addGap(199)
					.addComponent(btnSobre)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSobre)
						.addComponent(Ltitulo))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		Arquivos.setLayout(new MigLayout("", "[102px][117px][18px][258.00px][62.00px][][]", "[23.00px][23px,center][25.00px,center][38.00px]"));
		Arquivos.add(Larquivos, "cell 0 0,alignx left,growy");
		Arquivos.add(LarquivoDeEntrada, "cell 0 1,alignx left,growy");
		Arquivos.add(textoArquivoDeEntrada, "cell 1 1 5 1,grow");
		
		JButton botaoEscolherEntrada = new JButton("Buscar");
		botaoEscolherEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int returnVal1 = chooser.showOpenDialog(rootPane);
			    if(returnVal1 == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " +
			            chooser.getSelectedFile().getName());
			          
			            if(chooser.getSelectedFile().canRead() && chooser.getSelectedFile().getName().contains(".txt")){
			            	Arquivo.entrada = chooser.getSelectedFile();		
			            	textoArquivoDeEntrada.setText(chooser.getSelectedFile().getName());
			            	
			            }else{
			            	JOptionPane.showMessageDialog( rootPane, "Escolha um arquivo .txt por favor", "Atencao!", returnVal1);
			            }
			            	
			             
			    }}} 
		);
		Arquivos.add(botaoEscolherEntrada, "cell 6 1,grow");
		Arquivos.add(LarquivoDeSaida, "cell 0 2,alignx left,growy");
		Arquivos.add(textoArquivoDeSaida, "cell 1 2 5 1,grow");
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int returnVal1 = chooser.showOpenDialog(rootPane);
			    if(returnVal1 == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " +
			            chooser.getSelectedFile().getName());
			          
			            if(chooser.getSelectedFile().canRead() && chooser.getSelectedFile().getName().contains(".txt")){
			            	Arquivo.saida = chooser.getSelectedFile();		
			            	textoArquivoDeSaida.setText(chooser.getSelectedFile().getName());
			            	
			            }else{
			            	JOptionPane.showMessageDialog( rootPane, "Escolha um arquivo .txt por favor", "Atencao!", returnVal1);
			            }
			            	
			             
			    }}
			}
		);
		Arquivos.add(btnNewButton, "cell 6 2,grow");
		Arquivos.add(escolhaLogCompleto, "cell 0 3,alignx left,aligny bottom");
		Arquivos.add(escolhaApenasResultados, "cell 1 3,alignx left,aligny bottom");
		Arquivos.add(checkBoxAbrirNoFim, "cell 3 3,alignx right,aligny bottom");
		GridBagLayout gbl_Escalonadores = new GridBagLayout();
		gbl_Escalonadores.columnWidths = new int[]{219, 77, 79, 40, 20, 0, 0, 0, 0, 0, 0, 0};
		gbl_Escalonadores.rowHeights = new int[]{41, 23, 23, 20, 45, 0};
		gbl_Escalonadores.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Escalonadores.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		Escalonadores.setLayout(gbl_Escalonadores);
		
		escolhaFCFS = new JRadioButton("First Come First Served(FCFS)");
		escolhaFCFS.setSelected(true);
		escolhaFCFS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Estrutura.escalonador = 1;
			}
		});
		
		JLabel Lescalonadores = new JLabel("Escalonador");
		Lescalonadores.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		GridBagConstraints gbc_Lescalonadores = new GridBagConstraints();
		gbc_Lescalonadores.fill = GridBagConstraints.HORIZONTAL;
		gbc_Lescalonadores.anchor = GridBagConstraints.NORTH;
		gbc_Lescalonadores.insets = new Insets(0, 0, 5, 5);
		gbc_Lescalonadores.gridx = 0;
		gbc_Lescalonadores.gridy = 0;
		Escalonadores.add(Lescalonadores, gbc_Lescalonadores);
		escolhaFCFS.setToolTipText("Algoritmo que prioriza a chegada do evento.");
		GrupoEscalonador.add(escolhaFCFS);
		GridBagConstraints gbc_escolhaFCFS = new GridBagConstraints();
		gbc_escolhaFCFS.fill = GridBagConstraints.HORIZONTAL;
		gbc_escolhaFCFS.anchor = GridBagConstraints.NORTH;
		gbc_escolhaFCFS.insets = new Insets(0, 0, 5, 5);
		gbc_escolhaFCFS.gridx = 0;
		gbc_escolhaFCFS.gridy = 1;
		Escalonadores.add(escolhaFCFS, gbc_escolhaFCFS);
		
		JRadioButton escolhaSFFn = new JRadioButton("Shorted Job First(SJF) - Nao Preemptivo");
		escolhaSFFn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Estrutura.escalonador = 2;
			}
		});
		
		JRadioButton escolhaRR = new JRadioButton("Round Robin(RR)");
		escolhaRR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estrutura.escalonador = 4;
			}
		});
		escolhaRR.setToolTipText("Algoritmo que distribui o uso da CPU em partes iguais para todos os processos.");
		GrupoEscalonador.add(escolhaRR);
		GridBagConstraints gbc_escolhaRR = new GridBagConstraints();
		gbc_escolhaRR.anchor = GridBagConstraints.NORTHWEST;
		gbc_escolhaRR.insets = new Insets(0, 0, 5, 5);
		gbc_escolhaRR.gridx = 1;
		gbc_escolhaRR.gridy = 1;
		Escalonadores.add(escolhaRR, gbc_escolhaRR);
		
		JLabel LQuantum = new JLabel("Quantum");
		GridBagConstraints gbc_LQuantum = new GridBagConstraints();
		gbc_LQuantum.anchor = GridBagConstraints.EAST;
		gbc_LQuantum.fill = GridBagConstraints.VERTICAL;
		gbc_LQuantum.insets = new Insets(0, 0, 5, 5);
		gbc_LQuantum.gridx = 2;
		gbc_LQuantum.gridy = 1;
		Escalonadores.add(LQuantum, gbc_LQuantum);
		
		final JSpinner SpinnerQuantum = new JSpinner();
		SpinnerQuantum.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Estrutura.quantum = (int) SpinnerQuantum.getModel().getValue();
			}
		});
		SpinnerQuantum.setToolTipText("Intervalo de tempo para o Round Robin.");
		SpinnerQuantum.setModel(new SpinnerNumberModel(new Integer(8), new Integer(1), null, new Integer(1)));
		GridBagConstraints gbc_SpinnerQuantum = new GridBagConstraints();
		gbc_SpinnerQuantum.fill = GridBagConstraints.BOTH;
		gbc_SpinnerQuantum.insets = new Insets(0, 0, 5, 5);
		gbc_SpinnerQuantum.gridx = 3;
		gbc_SpinnerQuantum.gridy = 1;
		Escalonadores.add(SpinnerQuantum, gbc_SpinnerQuantum);
		escolhaSFFn.setToolTipText("Algoritmo que prioriza o processo de menor custo para a CPU. N\u00E3o Preempta.");
		GrupoEscalonador.add(escolhaSFFn);
		GridBagConstraints gbc_escolhaSFFn = new GridBagConstraints();
		gbc_escolhaSFFn.fill = GridBagConstraints.HORIZONTAL;
		gbc_escolhaSFFn.anchor = GridBagConstraints.NORTH;
		gbc_escolhaSFFn.insets = new Insets(0, 0, 5, 5);
		gbc_escolhaSFFn.gridx = 0;
		gbc_escolhaSFFn.gridy = 2;
		Escalonadores.add(escolhaSFFn, gbc_escolhaSFFn);
		
		JRadioButton escolhaMF = new JRadioButton("M\u00FAltiplas Filas Prioridade");
		escolhaMF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estrutura.escalonador = 5;
			}
		});
		escolhaMF.setToolTipText("Algoritmo que gerencia o uso da CPU por listas ligadas determinadas pelas prioridades.");
		GrupoEscalonador.add(escolhaMF);
		GridBagConstraints gbc_escolhaMF = new GridBagConstraints();
		gbc_escolhaMF.anchor = GridBagConstraints.NORTHWEST;
		gbc_escolhaMF.insets = new Insets(0, 0, 5, 5);
		gbc_escolhaMF.gridx = 1;
		gbc_escolhaMF.gridy = 2;
		Escalonadores.add(escolhaMF, gbc_escolhaMF);
		
		JLabel Lprioridade2 = new JLabel("Prioridade 1");
		GridBagConstraints gbc_Lprioridade2 = new GridBagConstraints();
		gbc_Lprioridade2.fill = GridBagConstraints.VERTICAL;
		gbc_Lprioridade2.anchor = GridBagConstraints.EAST;
		gbc_Lprioridade2.insets = new Insets(0, 0, 5, 5);
		gbc_Lprioridade2.gridx = 2;
		gbc_Lprioridade2.gridy = 2;
		Escalonadores.add(Lprioridade2, gbc_Lprioridade2);
		
		JRadioButton escolhaSJF = new JRadioButton("Shorted Job First(SJF) - Preemptivo");
		escolhaSJF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estrutura.escalonador = 3;
			}
		});
		
		final JSpinner spinnerPrioridade1 = new JSpinner();
		spinnerPrioridade1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Estrutura.prioridade1 = (int) spinnerPrioridade1.getModel().getValue();
			}
		});
		spinnerPrioridade1.setToolTipText("Fila 1 para processos < Priodade 1");
		spinnerPrioridade1.setModel(new SpinnerNumberModel(3, 1, 99, 1));
		GridBagConstraints gbc_spinnerPrioridade1 = new GridBagConstraints();
		gbc_spinnerPrioridade1.fill = GridBagConstraints.VERTICAL;
		gbc_spinnerPrioridade1.anchor = GridBagConstraints.WEST;
		gbc_spinnerPrioridade1.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerPrioridade1.gridx = 3;
		gbc_spinnerPrioridade1.gridy = 2;
		Escalonadores.add(spinnerPrioridade1, gbc_spinnerPrioridade1);
		
		JLabel Lprioridade1 = new JLabel("Prioridade 2");
		GridBagConstraints gbc_Lprioridade1 = new GridBagConstraints();
		gbc_Lprioridade1.fill = GridBagConstraints.VERTICAL;
		gbc_Lprioridade1.anchor = GridBagConstraints.EAST;
		gbc_Lprioridade1.insets = new Insets(0, 0, 5, 5);
		gbc_Lprioridade1.gridx = 4;
		gbc_Lprioridade1.gridy = 2;
		Escalonadores.add(Lprioridade1, gbc_Lprioridade1);
		
		final JSpinner spinnerPrioridade2 = new JSpinner();
		spinnerPrioridade2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Estrutura.prioridade2 = (int) spinnerPrioridade2.getModel().getValue();
			}
		});
		spinnerPrioridade2.setToolTipText("Fila 2 para processos > Priodade1 e <Priodade2. Fila 3 para >Prioridade2.");
		spinnerPrioridade2.setModel(new SpinnerNumberModel(6, 1, 99, 1));
		GridBagConstraints gbc_spinnerPrioridade2 = new GridBagConstraints();
		gbc_spinnerPrioridade2.fill = GridBagConstraints.VERTICAL;
		gbc_spinnerPrioridade2.anchor = GridBagConstraints.WEST;
		gbc_spinnerPrioridade2.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerPrioridade2.gridx = 5;
		gbc_spinnerPrioridade2.gridy = 2;
		Escalonadores.add(spinnerPrioridade2, gbc_spinnerPrioridade2);
		escolhaSJF.setToolTipText("Algoritmo que prioriza o processo de menor custo para a CPU. Preempa.");
		GrupoEscalonador.add(escolhaSJF);
		GridBagConstraints gbc_escolhaSJF = new GridBagConstraints();
		gbc_escolhaSJF.fill = GridBagConstraints.HORIZONTAL;
		gbc_escolhaSJF.anchor = GridBagConstraints.NORTH;
		gbc_escolhaSJF.insets = new Insets(0, 0, 5, 5);
		gbc_escolhaSJF.gridx = 0;
		gbc_escolhaSJF.gridy = 3;
		Escalonadores.add(escolhaSJF, gbc_escolhaSJF);
		
		JRadioButton escolhaMF_F = new JRadioButton("M\u00FAltiplas Filas Reavalia\u00E7\u00E3o");
		escolhaMF_F.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estrutura.escalonador = 6;
			}
		});
		GrupoEscalonador.add(escolhaMF_F);
		GridBagConstraints gbc_escolhaMF_F = new GridBagConstraints();
		gbc_escolhaMF_F.insets = new Insets(0, 0, 5, 5);
		gbc_escolhaMF_F.gridx = 1;
		gbc_escolhaMF_F.gridy = 3;
		Escalonadores.add(escolhaMF_F, gbc_escolhaMF_F);
		
		JLabel LQuantum2 = new JLabel("Quantum 2");
		LQuantum2.setToolTipText("Quantum de tempo dado para os processos da segunda fila.");
		GridBagConstraints gbc_LQuantum2 = new GridBagConstraints();
		gbc_LQuantum2.anchor = GridBagConstraints.EAST;
		gbc_LQuantum2.insets = new Insets(0, 0, 5, 5);
		gbc_LQuantum2.gridx = 2;
		gbc_LQuantum2.gridy = 3;
		Escalonadores.add(LQuantum2, gbc_LQuantum2);
		
		JSpinner spinnerQuantum2 = new JSpinner();
		spinnerQuantum2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Estrutura.quantum2 = (int) SpinnerQuantum.getModel().getValue();
			}
		});
		spinnerQuantum2.setModel(new SpinnerNumberModel(new Integer(16), new Integer(1), null, new Integer(1)));
		spinnerQuantum2.setToolTipText("Quantum de tempo dado para os processos da segunda fila.");
		GridBagConstraints gbc_spinnerQuantum2 = new GridBagConstraints();
		gbc_spinnerQuantum2.fill = GridBagConstraints.BOTH;
		gbc_spinnerQuantum2.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerQuantum2.gridx = 3;
		gbc_spinnerQuantum2.gridy = 3;
		Escalonadores.add(spinnerQuantum2, gbc_spinnerQuantum2);
		
		JButton botaoGerar = new JButton("Gerar");
		GridBagConstraints gbc_botaoGerar = new GridBagConstraints();
		gbc_botaoGerar.anchor = GridBagConstraints.WEST;
		gbc_botaoGerar.insets = new Insets(0, 0, 0, 5);
		gbc_botaoGerar.fill = GridBagConstraints.VERTICAL;
		gbc_botaoGerar.gridwidth = 3;
		gbc_botaoGerar.gridx = 5;
		gbc_botaoGerar.gridy = 4;
		Escalonadores.add(botaoGerar, gbc_botaoGerar);
		botaoGerar.setPreferredSize(new Dimension(67, 35));
		botaoGerar.setAlignmentX(Component.CENTER_ALIGNMENT);
		botaoGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Estrutura.escalonador == 0){
					JOptionPane.showMessageDialog(null, "Por favor, selecione um escalonador.", "Atencao!", getDefaultCloseOperation());
					return;
				}if(Arquivo.saida == null){
					JOptionPane.showMessageDialog(null, "Por favor, digite um nome para o arquivo de saida.", "Atencao!", getDefaultCloseOperation());
					return;
				}if(Arquivo.entrada == null){
					JOptionPane.showMessageDialog(null, "Por favor, digite um nome para o arquivo de entrada.", "Atencao!", getDefaultCloseOperation());
					return;
				}
				System.out.println("Arquivo de entrada = "+Arquivo.entrada);
				System.out.println("Arquivo de saida = "+Arquivo.saida);
				Main.Executa();
				JOptionPane.showMessageDialog(null, "Arquivo de saida foi gerado com sucesso!", "Sucesso.", getDefaultCloseOperation());
				if(abreArquivo)
					try {
						java.awt.Desktop.getDesktop().open( Arquivo.saida);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				System.exit(0);
			}});
		getContentPane().setLayout(groupLayout);

	}
	public JRadioButton getRdbtnLogCompleto() {
		return escolhaLogCompleto;
	}
	public boolean getRdbtnFirstComeFirstSelected() {
		return escolhaFCFS.isSelected();
	}
	public void setRdbtnFirstComeFirstSelected(boolean selected) {
		escolhaFCFS.setSelected(selected);
	}
}

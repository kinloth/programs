import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


@SuppressWarnings("serial")
public class Sobre extends JDialog {
	private JLabel lblExerccioProgramaDa;
	private JLabel lblUniversidadeSoPaulo;
	private JLabel lblV;
	private JLabel lblMarceloGaiosoWerneck;
	private JLabel lblOrientadora;
	private JLabel lblObsTrabalhoDe;
	private JLabel lblParaInformaesSobre;

	/**
	 * Launch the application.
	 */
	public static void main(ActionEvent arg0) {
		try {
			Sobre dialog = new Sobre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
 
  

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 405, 273);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{368, 0};
		gridBagLayout.rowHeights = new int[]{229, 0, 0, 0, 33, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridheight = 5;
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			getContentPane().add(panel, gbc_panel);
			{
				lblExerccioProgramaDa = new JLabel("Exerc\u00EDcio Programa da Disciplina de Sistemas Operacionais");
				lblExerccioProgramaDa.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			{
			}
			{
				lblUniversidadeSoPaulo = new JLabel("Universidade S\u00E3o Paulo");
				lblUniversidadeSoPaulo.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			{
				lblV = new JLabel("v2.2");
			}
			{
				lblMarceloGaiosoWerneck = new JLabel("Marcelo Gaioso Werneck                    N\u00BAUSP 8061963");
			}
			{
				{
					lblOrientadora = new JLabel("Prof. Gisele da Silva Craveiro.");
				}
				{
					lblObsTrabalhoDe = new JLabel("Obs.: Trabalho de gradua\u00E7\u00E3o apenas para fins did\u00E1ticos.");
				}
			}
			{
				lblParaInformaesSobre = new JLabel("Para informa\u00E7\u00F5es sobre a estrutura vide o relat\u00F3rio.");
			}
			JButton btnNewButton = new JButton("Relat\u00F3rio");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					File relatorio = null;
					try {
						relatorio = new File("RelatorioQualidade.pdf");
						java.awt.Desktop.getDesktop().open(relatorio);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			JButton btnNewButton_1 = new JButton("Manual");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					File manual = null;
					try {
						manual = new File("Manual_Compilacao.pdf");
						java.awt.Desktop.getDesktop().open(manual);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(15)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(198)
										.addComponent(btnNewButton)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnNewButton_1))
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblUniversidadeSoPaulo)
											.addGap(43)
											.addComponent(lblV))
										.addComponent(lblExerccioProgramaDa))))
							.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblParaInformaesSobre))
							.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblObsTrabalhoDe))
							.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblOrientadora))
							.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblMarceloGaiosoWerneck)))
						.addContainerGap(30, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(10)
						.addComponent(lblExerccioProgramaDa)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(7)
								.addComponent(lblUniversidadeSoPaulo))
							.addComponent(lblV))
						.addGap(35)
						.addComponent(lblMarceloGaiosoWerneck)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblOrientadora)
						.addGap(20)
						.addComponent(lblObsTrabalhoDe)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblParaInformaesSobre)
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1)
							.addComponent(btnNewButton))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
		}
	}
	

}

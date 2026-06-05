package healthcalc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Font;

public class ViewBSAImpl extends JPanel implements ViewBSA {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbResultado;
	private JTextArea txtArea_warning_alt;
	private JTextArea txtArea_warning_peso;
	private JButton btn_calcular;
	private JTextField text_altura;
	private JTextField text_peso;
	private JTextArea txt_warning_generico;

	/**
	 * Create the panel.
	 */
	public ViewBSAImpl() {
		// Usamos el layout que recomendó el profe en primera instacia: Border
		setLayout(new BorderLayout(0, 0));
		
		/*
		 * ================== PANEL CENTRAL ==========================
		 * */
		// Tenemos que juntar la label a la textbox para que se vea mejor
		JPanel panel_center = new JPanel();
		panel_center.setBorder(new EmptyBorder(20, 20, 20, 20));
		add(panel_center, BorderLayout.CENTER); // Se añade directamente con add()
		GridBagLayout gbl_panel_center = new GridBagLayout();
		gbl_panel_center.columnWidths = new int[]{0, 0, 0};
		// Filas: Altura(0), ErrAlt(1), Peso(2), ErrPeso(3), Botón(4)
		gbl_panel_center.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_center.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_center.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_center.setLayout(gbl_panel_center);
		
		// ---------------------------------------------------------------------
		
		// ------------ Etiqueta ALTURA ----------
		JLabel lblIntroducirAlturacm = new JLabel("Introducir altura (cm):");
		GridBagConstraints gbc_lblIntroducirAlturacm = new GridBagConstraints();
		gbc_lblIntroducirAlturacm.anchor = GridBagConstraints.WEST;
		gbc_lblIntroducirAlturacm.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntroducirAlturacm.gridx = 0;
		gbc_lblIntroducirAlturacm.gridy = 0;
		panel_center.add(lblIntroducirAlturacm, gbc_lblIntroducirAlturacm);
		
		// ------------ Campo ALTURA ----------
		text_altura = new JTextField();
		text_altura.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		text_altura.setColumns(10);
		GridBagConstraints gbc_text_altura = new GridBagConstraints();
		gbc_text_altura.fill = GridBagConstraints.BOTH;
		gbc_text_altura.insets = new Insets(5, 5, 5, 0);
		gbc_text_altura.gridx = 1;
		gbc_text_altura.gridy = 0;
		panel_center.add(text_altura, gbc_text_altura);

		
		// ------------ Text WARNING_ALTURA ----------
		txtArea_warning_alt = new JTextArea(" ");
		txtArea_warning_alt.setEditable(false);
		txtArea_warning_alt.setOpaque(false);
		txtArea_warning_alt.setLineWrap(true);
		txtArea_warning_alt.setWrapStyleWord(true);
		txtArea_warning_alt.setFocusable(false);
		txtArea_warning_alt.setForeground(Color.RED);
		txtArea_warning_alt.setFont(new Font("Arial", Font.ITALIC, 11));
		
		GridBagConstraints gbc_textArea_warningPeso = new GridBagConstraints();
		gbc_textArea_warningPeso.insets = new Insets(0, 5, 5, 0);
		gbc_textArea_warningPeso.fill = GridBagConstraints.BOTH;
		gbc_textArea_warningPeso.gridx = 1;
		gbc_textArea_warningPeso.gridy = 1;
		panel_center.add(txtArea_warning_alt, gbc_textArea_warningPeso);
		
		// ---------------------------------------------------------------------
		
		// ------------ Etiqueta PESO ----------
		JLabel lblIntroducirPesokg = new JLabel("Introducir peso (kg):");
		GridBagConstraints gbc_lblIntroducirPesokg = new GridBagConstraints();
		gbc_lblIntroducirPesokg.anchor = GridBagConstraints.WEST;
		gbc_lblIntroducirPesokg.insets = new Insets(5, 5, 5, 5);
		gbc_lblIntroducirPesokg.gridx = 0;
		gbc_lblIntroducirPesokg.gridy = 2;
		panel_center.add(lblIntroducirPesokg, gbc_lblIntroducirPesokg);
		
		// ------------ Campo PESO ----------
		text_peso = new JTextField();
		text_peso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		text_peso.setColumns(10);
		GridBagConstraints gbc_text_peso = new GridBagConstraints();
		gbc_text_peso.insets = new Insets(5, 5, 5, 0);
		gbc_text_peso.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_peso.gridx = 1;
		gbc_text_peso.gridy = 2;
		panel_center.add(text_peso, gbc_text_peso);
		
		// ------------ Text WANING_PESO ----------
		txtArea_warning_peso = new JTextArea(" ");
		txtArea_warning_peso.setEditable(false);
		txtArea_warning_peso.setOpaque(false);
		txtArea_warning_peso.setLineWrap(true);
		txtArea_warning_peso.setWrapStyleWord(true);
		txtArea_warning_peso.setFocusable(false); // Evita que el cursor entre aquí
		txtArea_warning_peso.setForeground(Color.RED);
		txtArea_warning_peso.setFont(new Font("Arial", Font.ITALIC, 11));

		GridBagConstraints gbc_warningPeso = new GridBagConstraints();
		gbc_warningPeso.insets = new Insets(0, 5, 5, 0);
		gbc_warningPeso.fill = GridBagConstraints.HORIZONTAL; // Cambiado a HORIZONTAL para que el texto fluya
		gbc_warningPeso.gridx = 1;
		gbc_warningPeso.gridy = 3;
		panel_center.add(txtArea_warning_peso, gbc_warningPeso);
		
		
		// Tenemos que adaptar el tamaño del botón
		// ------------ Botón CALCULAR ----------
		btn_calcular = new JButton("Calcular BSA");
		GridBagConstraints gbc_btn_calcular = new GridBagConstraints();
		gbc_btn_calcular.gridwidth  = 2;     						// Para que se vea en el centro
		gbc_btn_calcular.insets     = new Insets(12, 5, 5, 0);		// Para que se vea más grande
		gbc_btn_calcular.gridx = 0;
		gbc_btn_calcular.gridy = 4;
		panel_center.add(btn_calcular, gbc_btn_calcular);

		// ------------ Etiqueta RESULTADO ----------
		lbResultado = new JLabel("Resultado: ");
		lbResultado.setFont(new Font("Arial", Font.BOLD, 18));
		lbResultado.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lbResultado = new GridBagConstraints();
		gbc_lbResultado.gridwidth = 2;
		gbc_lbResultado.insets = new Insets(2, 5, 30, 0);    // Separado del botón
		gbc_lbResultado.anchor = GridBagConstraints.CENTER;
		gbc_lbResultado.gridx = 0;
		gbc_lbResultado.gridy = 5;
		// Así evito que desplace todo mi display
		lbResultado.setPreferredSize(new Dimension(300, 40));  
		lbResultado.setMinimumSize(new Dimension(300, 40));
		panel_center.add(lbResultado, gbc_lbResultado);
		
		/*
		 * ================== PANEL SUR ==========================
		 * */
		JPanel panel_south = new JPanel();
		add(panel_south, BorderLayout.SOUTH);
		
		// ------------ TextArea WARNING_GENERICO ----------
		txt_warning_generico = new JTextArea("");
		txt_warning_generico.setEditable(false);
		txt_warning_generico.setOpaque(false);
		txt_warning_generico.setLineWrap(true);
		txt_warning_generico.setWrapStyleWord(true);
		txt_warning_generico.setFocusable(false);
		txt_warning_generico.setForeground(Color.RED);
		txt_warning_generico.setFont(new Font("Arial", Font.ITALIC, 11));
		txt_warning_generico.setVisible(false);
		panel_south.setLayout(new BorderLayout(0, 0));
		GridBagConstraints gbc_warning_generico = new GridBagConstraints();
		gbc_warning_generico.gridwidth = 2;
		gbc_warning_generico.insets = new Insets(0, 5, 5, 0);
		gbc_warning_generico.fill = GridBagConstraints.HORIZONTAL;
		gbc_warning_generico.anchor = GridBagConstraints.CENTER;
		gbc_warning_generico.gridx = 0;
		gbc_warning_generico.gridy = 6;
		panel_south.add(txt_warning_generico, BorderLayout.CENTER);
	}

	
	// Métodos
	@Override
	public String get_h_bas() {
		// .TRIM() elimina espacios en blanco
		return text_altura.getText().trim();
	}
	
	@Override
	public String get_w_bas() {
		// .TRIM() elimina espacios en blanco
				return text_peso.getText().trim();
	}
	
	@Override
	public void setResult(String res) {
		this.lbResultado.setText(res + " m²");
		lbResultado.setForeground(new Color(0, 100, 0));
		// Ocultar warning si hay éxito
		this.txtArea_warning_alt.setText(" ");
		this.txtArea_warning_peso.setText(" ");
		this.txt_warning_generico.setText(" ");
	    revalidate();
	    repaint();
	}
	
	
	@Override 
	public void setWeightError(String msg) { 
		txtArea_warning_peso.setText(msg);
		txtArea_warning_peso.setVisible(true);
	}
	
    @Override 
    public void setHeightError(String msg) { 
    	txtArea_warning_alt.setText(msg);
    	txtArea_warning_alt.setVisible(true);
    }
	
	@Override
	public void setController(ActionListener ctr) {
		this.btn_calcular.addActionListener(ctr);
		this.btn_calcular.setActionCommand("Calcular");
	}
	
	@Override
	public void setGeneralError(String msg) {
		txt_warning_generico.setVisible(true);
		txt_warning_generico.setText(msg);
	}
	
	
	@Override 
    public void clearErrors() { 
	    txtArea_warning_peso.setText(" "); 
	    txtArea_warning_alt.setText(" "); 
	    txt_warning_generico.setText(" ");
	    txt_warning_generico.setVisible(false);
	    lbResultado.setText("Resultado: "); 
	    lbResultado.setForeground(Color.BLACK);
    }

}
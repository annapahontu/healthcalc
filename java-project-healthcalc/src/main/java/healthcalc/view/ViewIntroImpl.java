package healthcalc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

public class ViewIntroImpl extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel lblBienvenido;

    public ViewIntroImpl() {
        setBorder(new EmptyBorder(20, 20, 20, 20));
     
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{73, 176, 219};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 47, 54, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
                        
                                lblBienvenido = new JLabel("¡Bienvenido a HealthCalc!");
                                lblBienvenido.setFont(new Font("Arial", Font.BOLD, 18));
                                GridBagConstraints gbc_lblBienvenido = new GridBagConstraints();
                                gbc_lblBienvenido.gridwidth = 3;
                                gbc_lblBienvenido.insets = new Insets(0, 0, 5, 0);
                                gbc_lblBienvenido.gridx = 0;
                                gbc_lblBienvenido.gridy = 0;
                                add(lblBienvenido, gbc_lblBienvenido);
                        
                        JTextPane txtpnHealthcalcEsUna_2 = new JTextPane();
                        txtpnHealthcalcEsUna_2.setText("Healthcalc es una herramienta que permite el cálculo de métricas de la salud básicas. ");
                        txtpnHealthcalcEsUna_2.setBackground(new Color(240, 240, 240));
                        txtpnHealthcalcEsUna_2.setEditable(false);
                        GridBagConstraints gbc_txtpnHealthcalcEsUna_2 = new GridBagConstraints();
                        gbc_txtpnHealthcalcEsUna_2.gridwidth = 3;
                        gbc_txtpnHealthcalcEsUna_2.insets = new Insets(0, 0, 5, 0);
                        gbc_txtpnHealthcalcEsUna_2.fill = GridBagConstraints.BOTH;
                        gbc_txtpnHealthcalcEsUna_2.gridx = 0;
                        gbc_txtpnHealthcalcEsUna_2.gridy = 1;
                        add(txtpnHealthcalcEsUna_2, gbc_txtpnHealthcalcEsUna_2);
                        
                        JLabel lblInstrucciones = new JLabel("Instrucciones");
                        lblInstrucciones.setFont(new Font("Arial", Font.BOLD, 18));
                        GridBagConstraints gbc_lblInstrucciones = new GridBagConstraints();
                        gbc_lblInstrucciones.anchor = GridBagConstraints.WEST;
                        gbc_lblInstrucciones.insets = new Insets(0, 0, 5, 5);
                        gbc_lblInstrucciones.gridx = 1;
                        gbc_lblInstrucciones.gridy = 2;
                        add(lblInstrucciones, gbc_lblInstrucciones);
                        
                        JTextPane txtpnHealthcalcEsUna = new JTextPane();
                        txtpnHealthcalcEsUna.setBackground(new Color(240, 240, 240));
                        txtpnHealthcalcEsUna.setText("- A su izquierda puede ver las métricas disponibles, y pinchando en ellas puedes cambiar a \r\nla métrica que quieras calcular.\r\n- Una vez estés en la métrica seleccionada, rellene los datos requeridos por la métrica.\r\n- BMI: Introduzca su altura (cm) y su peso (kg). Si selecciona la casilla, puede ver la clasificación de su resultado.\r\n- IBW: Introduzca su altura (cm) y seleccione su género.\r\n- BSA: Introduzca su altura (cm) y su peso (kg).\r\n- Utilice '.' en lugar de ',' para introducir los decimales.\r\n\r\n");
                        txtpnHealthcalcEsUna.setEditable(false);
                        GridBagConstraints gbc_txtpnHealthcalcEsUna = new GridBagConstraints();
                        gbc_txtpnHealthcalcEsUna.gridheight = 2;
                        gbc_txtpnHealthcalcEsUna.gridwidth = 2;
                        gbc_txtpnHealthcalcEsUna.fill = GridBagConstraints.BOTH;
                        gbc_txtpnHealthcalcEsUna.gridx = 1;
                        gbc_txtpnHealthcalcEsUna.gridy = 3;
                        add(txtpnHealthcalcEsUna, gbc_txtpnHealthcalcEsUna);
    }
}
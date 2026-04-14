package healthcalc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBMI extends JPanel implements ViewBMI {

    private JTextField txtWeight;
    private JTextField txtHeight;
    private JLabel lblWeightError;
    private JLabel lblHeightError;
    private JCheckBox chkClassification;
    private JButton btnCalculate;
    private JLabel lblResult;

    public PanelBMI() {
        // Usamos GridBagLayout porque nos permite poner elementos en modo "cuadrícula"
        // y decirle que una fila (el error) ocupe varias columnas.
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Margen entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- FILA 1: Peso ---
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Introducir peso (kg):"), gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        txtWeight = new JTextField(10);
        add(txtWeight, gbc);

        // --- FILA 2: Error de Peso ---
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2; // Que ocupe las dos columnas
        lblWeightError = new JLabel(" "); // Espacio en blanco por defecto
        lblWeightError.setForeground(Color.RED); // Texto en rojo para errores
        add(lblWeightError, gbc);

        // --- FILA 3: Altura ---
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 1; // Volvemos a 1 columna
        add(new JLabel("Introducir altura (cm):"), gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        txtHeight = new JTextField(10);
        add(txtHeight, gbc);

        // --- FILA 4: Error de Altura ---
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        lblHeightError = new JLabel(" ");
        lblHeightError.setForeground(Color.RED);
        add(lblHeightError, gbc);

        // --- FILA 5: Checkbox Clasificación ---
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        chkClassification = new JCheckBox("Mostrar clasificación de la OMS");
        add(chkClassification, gbc);

        // --- FILA 6: Botón Calcular ---
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        btnCalculate = new JButton("Calcular BMI");
        add(btnCalculate, gbc);

        // --- FILA 7: Resultado ---
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2;
        lblResult = new JLabel("Resultado: ");
        // Ponemos una fuente un poco más grande para el resultado
        lblResult.setFont(lblResult.getFont().deriveFont(14f)); 
        add(lblResult, gbc);
    }

    // --- Implementación de la Interfaz ViewBMI ---

    @Override
    public String getWeightInput() {
        return txtWeight.getText().trim();
    }

    @Override
    public String getHeightInput() {
        return txtHeight.getText().trim();
    }

    @Override
    public boolean wantsClassification() {
        return chkClassification.isSelected();
    }

    @Override
    public void setResult(String result) {
        lblResult.setText(result);
        lblResult.setForeground(new Color(0, 153, 0)); // Verde oscuro para éxito
    }

    @Override
    public void setWeightError(String errorMsg) {
        lblWeightError.setText(errorMsg);
    }

    @Override
    public void setHeightError(String errorMsg) {
        lblHeightError.setText(errorMsg);
    }

    @Override
    public void clearErrors() {
        lblWeightError.setText(" ");
        lblHeightError.setText(" ");
        lblResult.setText("Resultado: ");
        lblResult.setForeground(Color.BLACK);
    }

    @Override
    public void setController(ActionListener ctr) {
        btnCalculate.addActionListener(ctr);
        btnCalculate.setActionCommand("CALCULAR_BMI");
    }
}
package healthcalc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ViewBMIImpl extends JPanel implements ViewBMI {

    private JTextField txtWeight;
    private JTextField txtHeight;
    private JLabel lblWeightError;
    private JLabel lblHeightError;
    private JCheckBox chkClassification;
    private JButton btnCalculate;
    private JLabel lblResult;

    public ViewBMIImpl() {
        this.setLayout(new GridBagLayout());
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- Peso ---
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Introducir peso (kg):"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        txtWeight = new JTextField(10);
        add(txtWeight, gbc);

        // Espacio para error de peso debajo de la caja
        gbc.gridx = 1; gbc.gridy = 1;
        lblWeightError = new JLabel(" ");
        lblWeightError.setForeground(Color.RED);
        lblWeightError.setFont(new Font("Arial", Font.ITALIC, 11));
        add(lblWeightError, gbc);

        // --- Altura ---
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Introducir altura (cm):"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        txtHeight = new JTextField(10);
        add(txtHeight, gbc);

        // Espacio para error de altura debajo de la caja
        gbc.gridx = 1; gbc.gridy = 3;
        lblHeightError = new JLabel(" ");
        lblHeightError.setForeground(Color.RED);
        lblHeightError.setFont(new Font("Arial", Font.ITALIC, 11));
        add(lblHeightError, gbc);

        // --- Clasificación ---
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        chkClassification = new JCheckBox("¿Desea ver la clasificación de la OMS?");
        add(chkClassification, gbc);

        // --- Botón ---
        gbc.gridx = 0; gbc.gridy = 5;
        btnCalculate = new JButton("Calcular BMI");
        add(btnCalculate, gbc);

        // --- Resultado ---
        gbc.gridx = 0; gbc.gridy = 6;
        lblResult = new JLabel("Resultado: ");
        lblResult.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblResult, gbc);
    }

    @Override public String getWeightInput() { return txtWeight.getText().trim(); }
    @Override public String getHeightInput() { return txtHeight.getText().trim(); }
    @Override public boolean wantsClassification() { return chkClassification.isSelected(); }
    @Override public void setResult(String res) { lblResult.setText(res); lblResult.setForeground(new Color(0, 100, 0)); }
    @Override public void setWeightError(String msg) { lblWeightError.setText(msg); }
    @Override public void setHeightError(String msg) { lblHeightError.setText(msg); }
    @Override public void clearErrors() { lblWeightError.setText(" "); lblHeightError.setText(" "); lblResult.setText("Resultado: "); }
    @Override public void setController(ActionListener ctr) { btnCalculate.addActionListener(ctr); }
}
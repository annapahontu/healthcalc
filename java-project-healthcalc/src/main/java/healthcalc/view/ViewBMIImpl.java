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
import javax.swing.SwingConstants; 
import javax.swing.border.EmptyBorder;

public class ViewBMIImpl extends JPanel implements ViewBMI {

    private static final long serialVersionUID = 1L;
    
    private JTextField txtWeight;
    private JTextField txtHeight;
    private JLabel lblWeightError;
    private JLabel lblHeightError;
    private JCheckBox chkClassification;
    private JButton btnCalculate;
    private JLabel lblResult;

    public ViewBMIImpl() {
        setBorder(new EmptyBorder(20, 20, 20, 20));
     
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblAltura = new JLabel("Introducir altura (cm):");
        GridBagConstraints gbc_lblAltura = new GridBagConstraints();
        gbc_lblAltura.anchor = GridBagConstraints.WEST;
        gbc_lblAltura.insets = new Insets(5, 5, 5, 5);
        gbc_lblAltura.gridx = 0;
        gbc_lblAltura.gridy = 0;
        add(lblAltura, gbc_lblAltura);

        txtHeight = new JTextField();
        GridBagConstraints gbc_txtHeight = new GridBagConstraints();
        gbc_txtHeight.insets = new Insets(5, 5, 5, 0);
        gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtHeight.gridx = 1;
        gbc_txtHeight.gridy = 0;
        add(txtHeight, gbc_txtHeight);
        txtHeight.setColumns(10);

        lblHeightError = new JLabel(" ");
        lblHeightError.setForeground(Color.RED);
        lblHeightError.setFont(new Font("Arial", Font.ITALIC, 11));
        GridBagConstraints gbc_lblHeightError = new GridBagConstraints();
        gbc_lblHeightError.anchor = GridBagConstraints.WEST;
        gbc_lblHeightError.insets = new Insets(0, 5, 5, 0);
        gbc_lblHeightError.gridx = 1;
        gbc_lblHeightError.gridy = 1;
        add(lblHeightError, gbc_lblHeightError);

        JLabel lblPeso = new JLabel("Introducir peso (kg):");
        GridBagConstraints gbc_lblPeso = new GridBagConstraints();
        gbc_lblPeso.anchor = GridBagConstraints.WEST;
        gbc_lblPeso.insets = new Insets(5, 5, 5, 5);
        gbc_lblPeso.gridx = 0;
        gbc_lblPeso.gridy = 2;
        add(lblPeso, gbc_lblPeso);

        txtWeight = new JTextField();
        GridBagConstraints gbc_txtWeight = new GridBagConstraints();
        gbc_txtWeight.insets = new Insets(5, 5, 5, 0);
        gbc_txtWeight.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtWeight.gridx = 1;
        gbc_txtWeight.gridy = 2;
        add(txtWeight, gbc_txtWeight);
        txtWeight.setColumns(10);

        lblWeightError = new JLabel(" ");
        lblWeightError.setForeground(Color.RED);
        lblWeightError.setFont(new Font("Arial", Font.ITALIC, 11));
        GridBagConstraints gbc_lblWeightError = new GridBagConstraints();
        gbc_lblWeightError.anchor = GridBagConstraints.WEST;
        gbc_lblWeightError.insets = new Insets(0, 5, 5, 0);
        gbc_lblWeightError.gridx = 1;
        gbc_lblWeightError.gridy = 3;
        add(lblWeightError, gbc_lblWeightError);

        chkClassification = new JCheckBox("Ver Clasificación BMI");
        GridBagConstraints gbc_chkClassification = new GridBagConstraints();
        gbc_chkClassification.anchor = GridBagConstraints.WEST;
        gbc_chkClassification.gridwidth = 2;
        gbc_chkClassification.insets = new Insets(5, 5, 5, 0);
        gbc_chkClassification.gridx = 0;
        gbc_chkClassification.gridy = 4;
        add(chkClassification, gbc_chkClassification);

        btnCalculate = new JButton("Calcular BMI");
        GridBagConstraints gbc_btnCalculate = new GridBagConstraints();
        gbc_btnCalculate.gridwidth = 2;
        gbc_btnCalculate.insets = new Insets(25, 5, 15, 0); 
        gbc_btnCalculate.gridx = 0;
        gbc_btnCalculate.gridy = 5;
        add(btnCalculate, gbc_btnCalculate);
                

        lblResult = new JLabel("Resultado: ");
        lblResult.setHorizontalAlignment(SwingConstants.CENTER); 
        lblResult.setFont(new Font("Arial", Font.BOLD, 20)); 
        GridBagConstraints gbc_lblResult = new GridBagConstraints();
        gbc_lblResult.fill = GridBagConstraints.HORIZONTAL; 
        gbc_lblResult.gridwidth = 3;
        gbc_lblResult.insets = new Insets(60, 0, 5, 0); 
        gbc_lblResult.gridx = 0;
        gbc_lblResult.gridy = 6;
        add(lblResult, gbc_lblResult);
    }
 
    @Override public String getWeightInput() { return txtWeight.getText().trim(); }
    @Override public String getHeightInput() { return txtHeight.getText().trim(); }
    @Override public boolean wantsClassification() { return chkClassification.isSelected(); }
    
    @Override 
    public void setResult(String res) { 
        lblResult.setText(res); 
        lblResult.setForeground(new Color(0, 100, 0));
    }
    
    @Override public void setWeightError(String msg) { lblWeightError.setText(msg); }
    @Override public void setHeightError(String msg) { lblHeightError.setText(msg); }
    
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
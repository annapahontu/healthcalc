package healthcalc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;

public class ViewIBWImpl extends JPanel implements ViewIBW {

    private static final long serialVersionUID = 1L;
    private JTextField txtHeightIBW;
    private JLabel lblHeightError;
    private JButton btnCalculateIBW;
    private JLabel lblResult;
    private JToggleButton tglbtnM;
    private JToggleButton tglbtnH;


    private final ButtonGroup buttonGroup = new ButtonGroup();

    public ViewIBWImpl() {
        setBorder(new EmptyBorder(20, 20, 20, 20));
     
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 140, 140};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
                JLabel lblAltura = new JLabel("Introducir altura (cm):");
                GridBagConstraints gbc_lblAltura = new GridBagConstraints();
                gbc_lblAltura.anchor = GridBagConstraints.WEST;
                gbc_lblAltura.insets = new Insets(5, 5, 5, 5);
                gbc_lblAltura.gridx = 0;
                gbc_lblAltura.gridy = 0;
                add(lblAltura, gbc_lblAltura);
        
                txtHeightIBW = new JTextField();
                GridBagConstraints gbc_txtHeightIBW = new GridBagConstraints();
                gbc_txtHeightIBW.gridwidth = 2;
                gbc_txtHeightIBW.insets = new Insets(5, 5, 5, 0);
                gbc_txtHeightIBW.fill = GridBagConstraints.HORIZONTAL;
                gbc_txtHeightIBW.gridx = 1;
                gbc_txtHeightIBW.gridy = 0;
                add(txtHeightIBW, gbc_txtHeightIBW);
                txtHeightIBW.setColumns(10);
                
                lblHeightError = new JLabel(" ");
                lblHeightError.setForeground(Color.RED);
                lblHeightError.setFont(new Font("Arial", Font.ITALIC, 11));
                GridBagConstraints gbc_lblHeightError = new GridBagConstraints();
                gbc_lblHeightError.anchor = GridBagConstraints.WEST;
                gbc_lblHeightError.insets = new Insets(0, 5, 5, 5);
                gbc_lblHeightError.gridx = 1;
                gbc_lblHeightError.gridy = 1;
                add(lblHeightError, gbc_lblHeightError);
        
                JLabel lblGénero = new JLabel("Introducir género:");
                GridBagConstraints gbc_lblGénero = new GridBagConstraints();
                gbc_lblGénero.anchor = GridBagConstraints.NORTHWEST;
                gbc_lblGénero.insets = new Insets(5, 5, 5, 5);
                gbc_lblGénero.gridx = 0;
                gbc_lblGénero.gridy = 2;
                add(lblGénero, gbc_lblGénero);
        
        tglbtnH = new JToggleButton("H");
        tglbtnH.setSelected(true);
        GridBagConstraints gbc_tglbtnH = new GridBagConstraints();
        gbc_tglbtnH.fill = GridBagConstraints.HORIZONTAL;
        gbc_tglbtnH.insets = new Insets(0, 0, 5, 5);
        gbc_tglbtnH.gridx = 1;
        gbc_tglbtnH.gridy = 2;
        add(tglbtnH, gbc_tglbtnH);
        
        tglbtnM = new JToggleButton("M");
        GridBagConstraints gbc_tglbtnM = new GridBagConstraints();
        gbc_tglbtnM.fill = GridBagConstraints.HORIZONTAL;
        gbc_tglbtnM.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnM.gridx = 2;
        gbc_tglbtnM.gridy = 2;
        add(tglbtnM, gbc_tglbtnM);
        
        buttonGroup.add(tglbtnH);
        buttonGroup.add(tglbtnM);
                        
                                btnCalculateIBW = new JButton("Calcular IBW");
                                GridBagConstraints gbc_btnCalculateIBW = new GridBagConstraints();
                                gbc_btnCalculateIBW.gridwidth = 3;
                                gbc_btnCalculateIBW.insets = new Insets(5, 5, 5, 0);
                                gbc_btnCalculateIBW.gridx = 0;
                                gbc_btnCalculateIBW.gridy = 5;
                                add(btnCalculateIBW, gbc_btnCalculateIBW);
                        
                                lblResult = new JLabel("Resultado: ");
                                lblResult.setFont(new Font("Arial", Font.BOLD, 18));
                                GridBagConstraints gbc_lblResult = new GridBagConstraints();
                                gbc_lblResult.insets = new Insets(0, 0, 5, 0);
                                gbc_lblResult.gridwidth = 3;
                                gbc_lblResult.gridx = 0;
                                gbc_lblResult.gridy = 7;
                                add(lblResult, gbc_lblResult);
    }
 
    @Override public String getHeightInput() { return txtHeightIBW.getText().trim(); }
    
    @Override public boolean isMaleSelected() { return tglbtnH.isSelected(); }
    
    @Override 
    public void setResult(String res) { 
        lblResult.setText(res); 
        lblResult.setForeground(new Color(0, 100, 0));
    }
    
    @Override public void setHeightError(String msg) { lblHeightError.setText(msg); }
    
    @Override 
    public void clearErrors() { 
        lblHeightError.setText(" "); 
        lblResult.setText("Resultado: "); 
        lblResult.setForeground(Color.BLACK);
    }
    
    @Override 
    public void setController(ActionListener ctr) { 
        btnCalculateIBW.addActionListener(ctr);
        btnCalculateIBW.setActionCommand("CALCULAR_IBW"); 
    }
}
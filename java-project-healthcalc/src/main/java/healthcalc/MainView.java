package healthcalc;

import javax.swing.JFrame;

import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import healthcalc.controller.CtrBMI;
import healthcalc.controller.CtrBSA;
import healthcalc.controller.CtrIBW;
import healthcalc.view.ViewBMIImpl;
import healthcalc.view.ViewBSAImpl;
import healthcalc.view.ViewIBWImpl;

public class MainView {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HealthCalc model = new HealthCalcImpl();
            JFrame mainFrame = new JFrame("HealthCalc");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(700, 500);

            JTabbedPane menuVertical = new JTabbedPane(JTabbedPane.LEFT);

         // Panel de BMI
            ViewBMIImpl panelBMI = new ViewBMIImpl();
            CtrBMI controllerBMI = new CtrBMI(model, panelBMI);
            panelBMI.setController(controllerBMI);
            menuVertical.addTab("BMI (Masa Corporal)", panelBMI);
            
            mainFrame.add(menuVertical);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
            
            
        });
    }
}
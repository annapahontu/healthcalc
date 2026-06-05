package healthcalc;

import javax.swing.JFrame;

import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import healthcalc.controller.CtrBMI;
import healthcalc.controller.CtrBSA;
import healthcalc.controller.CtrIBW;
import healthcalc.view.ViewIntroImpl;
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
            
            // --- Bienvenida ---
            ViewIntroImpl panelIntro = new ViewIntroImpl();
            menuVertical.addTab("Inicio", panelIntro);

         // Panel de BMI
            ViewBMIImpl panelBMI = new ViewBMIImpl();
            CtrBMI controllerBMI = new CtrBMI(model, panelBMI);
            panelBMI.setController(controllerBMI);
            menuVertical.addTab("BMI (Masa Corporal)", panelBMI);
            
            mainFrame.add(menuVertical);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);

            // --- Panel de IBW---
            ViewIBWImpl panelIBW = new ViewIBWImpl();
            CtrIBW controllerIBW = new CtrIBW(model, panelIBW);
            panelIBW.setController(controllerIBW);
            menuVertical.addTab("IBW (Peso Ideal)", panelIBW);
         
            mainFrame.add(menuVertical);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);

            // --- Panel de BSA---
            ViewBSAImpl panelBSA = new ViewBSAImpl();
            CtrBSA controllerBSA = new CtrBSA(panelBSA, model);
            panelBSA.setController(controllerBSA);
            menuVertical.addTab("BSA (Masa Corporal)", panelBSA);
            
            
            mainFrame.add(menuVertical);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
        });
    }
}
package healthcalc;

import javax.swing.*;
import healthcalc.controller.CtrBMI;
import healthcalc.view.ViewBMIImpl;

public class MainView {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. Instanciar el modelo (común para todos)
            HealthCalc model = new HealthCalcImpl();

            // 2. Crear el JFrame ÚNICO
            JFrame mainFrame = new JFrame("HealthCalc - Hospital Universitario");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(700, 500);

            // 3. Crear el contenedor de pestañas VERTICAL (LEFT)
            JTabbedPane menuVertical = new JTabbedPane(JTabbedPane.LEFT);

            // --- Panel de Inicio ---
            JPanel pnlInicio = new JPanel();
            pnlInicio.add(new JLabel("Bienvenido. Seleccione una métrica en el menú de la izquierda."));
            menuVertical.addTab("Inicio", pnlInicio);

            // --- Panel de BMI (Tu parte) ---
            ViewBMIImpl panelBMI = new ViewBMIImpl();
            CtrBMI controllerBMI = new CtrBMI(model, panelBMI);
            panelBMI.setController(controllerBMI);
            menuVertical.addTab("BMI (Masa Corporal)", panelBMI);

            // --- ESPACIO PARA COMPAÑEROS (BSA e IBW) ---
            // menuVertical.addTab("BSA (Superficie)", new ViewBSAImpl(...));
            // menuVertical.addTab("IBW (Peso Ideal)", new ViewIBWImpl(...));

            // 4. Mostrar
            mainFrame.add(menuVertical);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
        });
    }
}
package healthcalc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import healthcalc.controller.CtrBMI;
import healthcalc.view.PanelBMI;

public class MainView {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. Instanciamos el Modelo Global
            HealthCalc model = new HealthCalcImpl();

            // 2. Creamos la Ventana Principal
            JFrame frame = new JFrame("Calculadora de Salud - Hospital Universitario");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null); // Centrar en pantalla

            JTabbedPane tabbedPane = new JTabbedPane();

            // 3. Pestaña de Introducción
            JPanel pnlIntro = new JPanel();
            pnlIntro.add(new javax.swing.JLabel("Bienvenido a HealthCalc. Seleccione una métrica en las pestañas."));
            tabbedPane.addTab("Inicio", pnlIntro);

            // 4. Pestaña de BMI (Vista, Controlador y Ensamblaje)
            PanelBMI viewBMI = new PanelBMI();
            CtrBMI ctrBMI = new CtrBMI(model, viewBMI);
            viewBMI.setController(ctrBMI); // Enlazamos
            tabbedPane.addTab("Calculadora BMI", viewBMI);

            // Añadir el panel de pestañas a la ventana
            frame.add(tabbedPane);
            frame.setVisible(true);
        });
    }
}
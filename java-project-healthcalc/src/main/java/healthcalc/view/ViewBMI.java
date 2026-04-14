package healthcalc.view;

import java.awt.event.ActionListener;

public interface ViewBMI {
    // Métodos para obtener datos de la interfaz
    String getWeightInput();
    String getHeightInput();
    boolean wantsClassification(); // Saber si el checkbox está marcado

    // Métodos para mostrar resultados y errores
    void setResult(String result);
    void setWeightError(String errorMsg);
    void setHeightError(String errorMsg);
    void clearErrors(); // Limpiar errores antes de un nuevo cálculo

    // Método para inyectar el controlador al botón
    void setController(ActionListener ctr);
}


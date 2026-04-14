package healthcalc.view;

import java.awt.event.ActionListener;

public interface ViewBMI {
    // Métodos para obtener datos del usuario
    public String getWeightInput();
    public String getHeightInput();
    public boolean wantsClassification();

    // Métodos para mostrar resultados y mensajes de error
    public void setResult(String res);
    public void setWeightError(String msg);
    public void setHeightError(String msg);
    public void clearErrors();

    // Método para conectar el botón con el controlador
    public void setController(ActionListener ctr);
}


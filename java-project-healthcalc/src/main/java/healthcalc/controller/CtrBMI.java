package healthcalc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import healthcalc.HealthCalc;
import healthcalc.exceptions.InvalidHealthDataException;
import healthcalc.view.ViewBMI;

public class CtrBMI implements ActionListener {

    private HealthCalc model;
    private ViewBMI view;

    public CtrBMI(HealthCalc model, ViewBMI view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CALCULAR_BMI")) {
            // 1. Limpiamos errores antiguos en la vista
            view.clearErrors();

            String weightStr = view.getWeightInput();
            String heightStr = view.getHeightInput();
            
            double weight = 0;
            double heightCm = 0;
            boolean validInputs = true;

            // 2. Parseo de datos (Errores de formato)
            try {
                weight = Double.parseDouble(weightStr);
            } catch (NumberFormatException ex) {
                view.setWeightError("Formato incorrecto. Usa números.");
                validInputs = false;
            }

            try {
                heightCm = Double.parseDouble(heightStr);
            } catch (NumberFormatException ex) {
                view.setHeightError("Formato incorrecto. Usa números.");
                validInputs = false;
            }

            if (!validInputs) return; // Si hay letras o está vacío, paramos aquí.

            // 3. Llamada al Modelo (Lógica de negocio y excepciones de salud)
            try {
                // OJO: Tu interfaz pide la altura en metros, pero el usuario la mete en cm.
                // El controlador hace la transformación de UI a Modelo.
                double heightMeters = heightCm / 100.0; 
                
                double bmiValue = model.bmi(weight, heightMeters);
                
                // Formateamos a 2 decimales para que quede bonito
                String resultText = String.format("Resultado: Tu BMI es %.2f", bmiValue);

                // Si el usuario marcó el check, calculamos la clasificación
                if (view.wantsClassification()) {
                    String clasificacion = model.bmiClassification(bmiValue);
                    resultText += " (" + clasificacion + ")";
                }

                // 4. Actualizamos la vista con el éxito
                view.setResult(resultText);

            } catch (InvalidHealthDataException ex) {
                // Aquí capturamos los errores de los "Limites Biológicos" que hiciste en P1/P2
                // Como no sabemos si falló el peso o la altura desde la excepción general,
                // podemos poner el error en el resultado o analizar el mensaje.
                if (ex.getMessage().toLowerCase().contains("weight") || ex.getMessage().toLowerCase().contains("peso")) {
                    view.setWeightError(ex.getMessage());
                } else if (ex.getMessage().toLowerCase().contains("height") || ex.getMessage().toLowerCase().contains("altura")) {
                    view.setHeightError(ex.getMessage());
                } else {
                    view.setResult("Error: " + ex.getMessage());
                }
            }
        }
    }
}
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
        // Limpiamos los mensajes de error antes de empezar
        view.clearErrors();
        
        String weightStr = view.getWeightInput();
        String heightStr = view.getHeightInput();
        
        // Variable bandera: se pondrá a true si encontramos CUALQUIER error
        boolean hayError = false;

        // 1. COMPROBAR SI ESTÁN VACÍOS (Evaluamos los dos a la vez)
        if (weightStr.isEmpty()) {
            view.setWeightError("Error: El campo no puede estar vacío.");
            hayError = true;
        }
        if (heightStr.isEmpty()) {
            view.setHeightError("Error: El campo no puede estar vacío.");
            hayError = true;
        }

        // Si ya hay campos vacíos, paramos aquí para que no salte error de formato al convertir
        if (hayError) return; 

        double weight = 0;
        double heightCm = 0;

        // 2. COMPROBAR FORMATO DE NÚMEROS (Letras o símbolos)
        try {
            weight = Double.parseDouble(weightStr);
        } catch (NumberFormatException ex) {
            view.setWeightError("Error: Introduzca solo números.");
            hayError = true;
        }

        try {
            heightCm = Double.parseDouble(heightStr);
        } catch (NumberFormatException ex) {
            view.setHeightError("Error: Introduzca solo números.");
            hayError = true;
        }

        // Si han metido letras, paramos aquí
        if (hayError) return;

        // 3. COMPROBAR SI SON NEGATIVOS (Evaluamos los dos a la vez)
        if (weight < 0) {
            view.setWeightError("Error: El valor no puede ser negativo.");
            hayError = true;
        }
        if (heightCm < 0) {
            view.setHeightError("Error: El valor no puede ser negativo.");
            hayError = true;
        }

        // Si son negativos, abortamos antes de ir al modelo
        if (hayError) return;

        // 4. LÓGICA DEL MODELO Y LÍMITES BIOLÓGICOS
        try {
            // Llegados a este punto, sabemos seguro que tenemos dos números positivos
            double bmi = model.bmi(weight, heightCm / 100.0);
            String out = String.format("Resultado BMI: %.2f", bmi);

            if (view.wantsClassification()) {
                out += " - " + model.bmiClassification(bmi);
            }
            
            view.setResult(out);

        } catch (InvalidHealthDataException ex) {
            // Si el modelo salta, identificamos si fue el peso o la altura
            String errorMsg = ex.getMessage().toLowerCase();
            
            if (errorMsg.contains("peso") || errorMsg.contains("weight")) {
                view.setWeightError("Error: Fuera de límites biológicos (1-700 kg).");
            } else if (errorMsg.contains("altura") || errorMsg.contains("height")) {
                view.setHeightError("Error: Fuera de límites biológicos (30-300 cm).");
            }
        }
    }
}
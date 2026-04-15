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
        view.clearErrors();
        
        String weightStr = view.getWeightInput();
        String heightStr = view.getHeightInput();
    
        boolean hayError = false;

        if (weightStr.isEmpty()) {
            view.setWeightError("Error: El campo no puede estar vacío.");
            hayError = true;
        }
        if (heightStr.isEmpty()) {
            view.setHeightError("Error: El campo no puede estar vacío.");
            hayError = true;
        }

        if (hayError) return; 

        double weight = 0;
        double heightCm = 0;

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

        if (hayError) return;

        if (weight < 0) {
            view.setWeightError("Error: El valor no puede ser negativo.");
            hayError = true;
        }
        if (heightCm < 0) {
            view.setHeightError("Error: El valor no puede ser negativo.");
            hayError = true;
        }

        if (hayError) return;

        try {
            double bmi = model.bmi(weight, heightCm / 100.0);
            String out = String.format("Resultado BMI: %.2f", bmi);

            if (view.wantsClassification()) {
                out += " - " + model.bmiClassification(bmi);
            }
            
            view.setResult(out);

        } catch (InvalidHealthDataException ex) {
            String errorMsg = ex.getMessage().toLowerCase();
            
            if (errorMsg.contains("peso") || errorMsg.contains("weight")) {
                view.setWeightError("Error: Fuera de límites biológicos (1-700 kg).");
            } else if (errorMsg.contains("altura") || errorMsg.contains("height")) {
                view.setHeightError("Error: Fuera de límites biológicos (30-300 cm).");
            }
        }
    }
}
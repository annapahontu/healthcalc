package healthcalc;
public interface HealthHospital {
    
    //Calcula el BMI devolviendo el valor numérico y la clasificación
    Tuple<Float, String> indiceMasaCorporal(float altura, int peso);
    
    //Calcula el peso ideal devolviendo un número entero
    int pesoCorporalIdeal(char genero, float altura);
}

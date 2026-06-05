package healthcalc;

public class HealthHospitalAdapter implements HealthHospital {

    private HealthCalc calculator;

    public HealthHospitalAdapter() {
        this.calculator = HealthCalcImpl.getInstance();
    }

    @Override
    public Tuple<Float, String> indiceMasaCorporal(float altura, int peso) {
        double pesoKg = peso / 1000.0;
        
        // Pasamos "altura" directamente, ya que viene en metros (ej. 1.83) y bmi() espera metros.
        double bmiResult = calculator.bmi(pesoKg, altura);
        String clasificacion = calculator.bmiClassification(bmiResult);

        return new Tuple<>((float) bmiResult, clasificacion);
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        // 1. Traducimos el género del Hospital (Español) a la Calculadora (Inglés)
        char generoCalculadora;
        char g = Character.toUpperCase(genero);
        
        if (g == 'H') {
            generoCalculadora = 'M'; // Hombre -> Male
        } else if (g == 'M') {
            generoCalculadora = 'F'; // Mujer -> Female
        } else {
            generoCalculadora = genero; // Por si acaso
        }

        // 2. Traducimos la altura a centímetros (esto ya lo teníamos bien)
        double alturaCm = altura * 100.0;
        
        // 3. Llamamos a la calculadora base con la letra correcta en inglés
        double pesoIdeal = calculator.ibw(alturaCm, generoCalculadora);
        
        return (int) pesoIdeal;
    }
}
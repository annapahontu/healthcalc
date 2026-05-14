package healthcalc;

//El adaptador implementa la interfaz del cliente
public class HealthHospitalAdapter implements HealthHospital {

    private HealthCalc calculator;

    public HealthHospitalAdapter() {
        this.calculator = HealthCalcImpl.getInstance();
    }

    @Override
    public Tuple<Float, String> indiceMasaCorporal(float altura, int peso) {
        double pesoKg = peso / 1000.0;
        double alturaCm = altura * 100.0;

        double bmiResult = calculator.bmi(pesoKg, alturaCm);
        String clasificacion = calculator.bmiClassification(bmiResult);

        return new Tuple<>((float) bmiResult, clasificacion);
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        double alturaCm = altura * 100.0;
        double pesoIdeal = calculator.ibw(alturaCm, genero);
        return (int) pesoIdeal;
    }
}

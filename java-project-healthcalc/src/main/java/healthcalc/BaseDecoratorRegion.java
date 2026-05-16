package healthcalc;

public class BaseDecoratorRegion implements HealthHospital {
    protected HealthHospital calc;

    public BaseDecoratorRegion(HealthHospital calc) {
        this.calc = calc;
    }

    @Override
    public Tuple<Float, String> indiceMasaCorporal(float height, int weight) {
        return calc.indiceMasaCorporal(height, weight);
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        return calc.pesoCorporalIdeal(genero, altura);
    }
}
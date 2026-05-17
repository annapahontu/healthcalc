package healthcalc;

public class English extends BaseDecoratorLanguage {
    public English(HealthHospital healthHospital) {
        super(healthHospital);
    }

    @Override
    public Tuple<Float, String> indiceMasaCorporal(float altura, int peso) {
        Tuple<Float, String> r = super.indiceMasaCorporal(altura, peso);
        float pesoKg = peso / 1000f;
        System.out.printf("The person with a height of %.2f m and a weight of %.0f kg has a BMI of %.2f.%n",
                          altura, pesoKg, r.getFirst());
        return r;
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        return healthHospital.pesoCorporalIdeal(genero, altura);
    }

}
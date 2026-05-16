package healthcalc;

public class Spanish extends BaseDecoratorLanguage {
    public Spanish(HealthHospital healthHospital) {
        super(healthHospital);
    }


    @Override
    public Tuple<Float, String> indiceMasaCorporal(float altura, int peso) {
        return healthHospital.indiceMasaCorporal(altura, peso);
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        return healthHospital.pesoCorporalIdeal(genero, altura);
    } 

}
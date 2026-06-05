package healthcalc;

public class EU extends BaseDecoratorRegion {
    public EU(HealthHospital calc) {
        super(calc);
    }

    @Override
    public Tuple<Float, String> indiceMasaCorporal(float heightMetros, int weightGramos) {
        return super.indiceMasaCorporal(heightMetros, weightGramos);
    }
    
    @Override
    public int pesoCorporalIdeal(char genero, float alturaMetros) {
        return super.pesoCorporalIdeal(genero, alturaMetros);
    }
}
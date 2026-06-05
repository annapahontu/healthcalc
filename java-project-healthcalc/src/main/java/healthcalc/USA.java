package healthcalc;

public class USA extends BaseDecoratorRegion {
    public USA(HealthHospital calc) {
        super(calc);
    }

    @Override
    public Tuple<Float, String> indiceMasaCorporal(float heightPulgadas, int weightLibras) {
        float alturaMetros = (float) (heightPulgadas * 0.0254);
        int pesoGramos = (int) (weightLibras * 453.592);

        return super.indiceMasaCorporal(alturaMetros, pesoGramos);
    }

    @Override
    public int pesoCorporalIdeal(char genero, float heightPulgadas) {
        float alturaMetros = (float) (heightPulgadas * 0.0254);
        int idealWeightKg = super.pesoCorporalIdeal(genero, alturaMetros);
        
        return (int) (idealWeightKg * 2.2046); 
    }
}
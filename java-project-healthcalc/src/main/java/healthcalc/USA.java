package healthcalc;

public class USA extends BaseDecoratorRegion {
    public USA(HealthHospital calc) {
        super(calc);
    }

    @Override
    public Tuple<Float, String> indiceMasaCorporal(float heightPulgadas, int weightLibras) {
        // Conversión según el enunciado
        float alturaMetros = (float) (heightPulgadas * 0.0254);// 1 libra = 0.453592 kg
        int pesoKg = (int) (weightLibras / 2.2046);  // 1 pulgada = 0.0254 metros

        Tuple<Float, String> result = super.indiceMasaCorporal(alturaMetros, pesoKg);
        float bmi = result.getFirst();
        String classification = result.getSecond();

        return new Tuple<>(bmi, classification);
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        float idealWeight = super.pesoCorporalIdeal(genero, altura);
        return (int) (idealWeight * 2.2046); // Convertir de kg a libras
    }
}

package healthcalc;

public class EU extends BaseDecoratorRegion {
    public EU(HealthHospital calc) {
        super(calc);
    }

    @Override
    public Tuple<Float, String> indiceMasaCorporal(float height, int weight) {
        // Conversión según el enunciado
        int pesoKg = weight / 1000; // Paso de gramos a kg
        float alturaMetros = height / 100; // Paso de centímetros a metros

        Tuple<Float, String> result = super.indiceMasaCorporal(alturaMetros, pesoKg);
        float bmi = result.getFirst();
        String classification = result.getSecond();

        return new Tuple<>(bmi, classification);
    }
    
    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        float alturaMetros = altura / 100; // Paso de centímetros a metros

        int idealWeight = super.pesoCorporalIdeal(genero, alturaMetros);
        return idealWeight;
    }
}

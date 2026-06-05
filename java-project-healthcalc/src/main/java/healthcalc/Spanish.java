package healthcalc;

public class Spanish extends BaseDecoratorLanguage {
    public Spanish(HealthHospital healthHospital) {
        super(healthHospital);
    }


    @Override
    public Tuple<Float, String> indiceMasaCorporal(float altura, int peso) {
        Tuple<Float, String> r = super.indiceMasaCorporal(altura, peso);
        float pesoKg = peso / 1000f;

        System.out.printf("La persona con altura %.2f metros y %.0f Kg tiene un IMC de %.2f.%n",
                          altura, pesoKg, r.getFirst());
        return r;
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        char gender;
        if (Character.toUpperCase(genero) == 'H') {
            gender = 'M';
        } else if (Character.toUpperCase(genero) == 'M') {
            gender = 'F';
        } else {
            throw new IllegalArgumentException("Género no válido. Use 'H' para hombre o 'M' para mujer.");
        }
        return healthHospital.pesoCorporalIdeal(gender, altura);
    } 

}
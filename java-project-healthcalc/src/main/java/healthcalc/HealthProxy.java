package healthcalc;

public class HealthProxy implements HealthHospital, HealthStats {
    
    private final HealthHospital realHospital;

    private float sumaAltura = 0;
    private int cuentaAltura = 0;

    private float sumaPeso = 0;
    private int cuentaPeso = 0;

    private float sumaImc = 0;
    private int cuentaImc = 0;

    private int hombres = 0;
    private int mujeres = 0;

    public HealthProxy() {
        this.realHospital = new HealthHospitalAdapter();
    }

    public HealthProxy(HealthHospital realHospital) {
        this.realHospital = realHospital;
    }

    @Override
    public Tuple<Float, String> indiceMasaCorporal(float altura, int peso) {
        Tuple<Float, String> resultado = realHospital.indiceMasaCorporal(altura, peso);

        this.sumaAltura += altura;
        this.cuentaAltura++;

        this.sumaPeso += peso;
        this.cuentaPeso++;

        if (resultado != null && resultado.getFirst() != null) {
            this.sumaImc += resultado.getFirst();
            this.cuentaImc++;
        }

        return resultado;
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        int resultado = realHospital.pesoCorporalIdeal(genero, altura);

        this.sumaAltura += altura;
        this.cuentaAltura++;

        char g = Character.toUpperCase(genero);
        if (g == 'M') {
            this.hombres++;
        } else if (g == 'F') {
            this.mujeres++;
        }

        return resultado;
    }

    @Override
    public float alturaMedia() {
        if (this.cuentaAltura == 0) {
            return 0;
        }
        return this.sumaAltura / this.cuentaAltura;
    }

    @Override
    public float pesoMedio() {
        if (this.cuentaPeso == 0) {
            return 0;
        }
        return this.sumaPeso / this.cuentaPeso;
    }

    @Override
    public float imcMedio() {
        if (this.cuentaImc == 0) {
            return 0;
        }
        return this.sumaImc / this.cuentaImc;
    }

    @Override
    public int numSexoH() {
        return this.hombres;
    }

    @Override
    public int numSexoM() {
        return this.mujeres;
    }

    @Override
    public int numTotalPacientes() {
        int totalPorGenero = this.hombres + this.mujeres;
        return Math.max(this.cuentaImc, totalPorGenero);
    }
}
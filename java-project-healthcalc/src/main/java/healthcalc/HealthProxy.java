package healthcalc;


public class HealthProxy implements HealthHospital, HealthStats {
    
    private final HealthHospital realHospital;

    // Atributos privados para almacenar los datos
    private float sumaAltura = 0;
    private int cuentaAltura = 0;

    private float sumaPeso = 0;
    private int cuentaPeso = 0;

    private float sumaImc = 0;
    private int cuentaImc = 0;

    private int hombres = 0;
    private int mujeres = 0;
    private int totalPacientes = 0;

    // Constructor
    public HealthProxy() {
        this.realHospital = new HealthHospitalAdapter();
    }

    // Constructor alternativo
    public HealthProxy(HealthHospital realHospital) {
        this.realHospital = realHospital;
    }

    @Override
    public Tuple<Float, String> indiceMasaCorporal(float altura, int peso) {
        // Cálculo hecho a través del adaptador
        Tuple<Float, String> resultado = realHospital.indiceMasaCorporal(altura, peso);

        // Registramos los datos
        this.sumaAltura += altura;
        this.cuentaAltura++;

        this.sumaPeso += peso; // El peso se acumula en gramos tal como lo envía el HealthHospital
        this.cuentaPeso++;

        if (resultado != null && resultado.getFirst() != null) {
            this.sumaImc += resultado.getFirst();
            this.cuentaImc++;
        }

        this.totalPacientes++;

        return resultado;
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        // Cálculo hecho a través del adaptador
        int resultado = realHospital.pesoCorporalIdeal(genero, altura);

        // Registrar los datos
        this.sumaAltura += altura;
        this.cuentaAltura++;

        // Control de género
        char g = Character.toUpperCase(genero);
        if (g == 'H') {
            this.hombres++;
        } else if (g == 'M') {
            this.mujeres++;
        }

        this.totalPacientes++;

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
        return this.totalPacientes;
    }
}
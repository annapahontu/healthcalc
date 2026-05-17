package healthcalc;

public class Main {
    public static void main(String[] args) {
        try {
            HealthProxy proxy = new HealthProxy();

            // USA: Espera pulgadas (72) y libras (171)
            HealthHospital calcUSA = new USA(new English(proxy));
            Tuple<Float, String> imcUSA = calcUSA.indiceMasaCorporal(72.0f, 171);
            int pciUSA = calcUSA.pesoCorporalIdeal('m', 72.0f);

            // EU: Espera metros (1.83) y gramos (78000)
            HealthHospital calcEU = new EU(new Spanish(proxy));
            Tuple<Float, String> imcEU = calcEU.indiceMasaCorporal(1.83f, 78000);
            int pciEU = calcEU.pesoCorporalIdeal('m', 1.83f);

            System.out.println("=== Resultados USA ===");
            System.out.println("IMC: " + imcUSA.getFirst() + " (" + imcUSA.getSecond() + ")");
            System.out.println("PCI: " + pciUSA + " lbs");

            System.out.println("\n=== Resultados EU ===");
            System.out.println("IMC: " + imcEU.getFirst() + " (" + imcEU.getSecond() + ")");
            System.out.println("PCI: " + pciEU + " kg");

            System.out.println("\n=== HealthStats (Proxy) ===");
            System.out.println("Total Pacientes: " + proxy.numTotalPacientes());
            System.out.println("Hombres: " + proxy.numSexoH());
            System.out.println("Mujeres: " + proxy.numSexoM());
            System.out.println("Altura Media: " + proxy.alturaMedia() + " metros");
            System.out.println("Peso Medio: " + proxy.pesoMedio() + " gramos");
            System.out.println("IMC Medio: " + proxy.imcMedio());

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
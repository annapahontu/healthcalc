package healthcalc.BDD;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BSASteps {

    private HealthCalc calculator;
    private double weight;
    private double height;
    private double result;
    private Exception exception;

    @Given("la calculadora de salud está iniciada")
    public void la_calculadora_de_salud_esta_iniciada() {
        calculator = new HealthCalcImpl();
    }

    @Given("el usuario ha seleccionado la métrica BSA para calcular")
    public void el_usuario_ha_seleccionado_la_metrica_bsa() {
    }

    @Given("el usuario ingresa un peso de {double} kg")
    public void el_usuario_ingresa_un_peso_de_kg(double weight) {
        this.weight = weight;
    }

    @Given("el usuario ingresa una altura de {double} cm")
    public void el_usuario_ingresa_una_altura_de_cm(double height) {
        this.height = height;
    }

    @When("el sistema intenta calcular el BSA")
    public void el_sistema_intenta_calcular_el_bsa() {
        try {
            this.result = calculator.bsa(this.weight, this.height);
            this.exception = null;
        } catch (Exception e) {
            this.exception = e; 
        }
    }

    @Then("el resultado debe ser {double}")
    public void el_resultado_debe_ser(double expected) {
        assertEquals(expected, this.result, 0.01);
    }

    @Then("el sistema debe lanzar una excepción de datos de salud inválidos")
    public void el_sistema_debe_lanzar_una_excepcion() {
        assertNotNull(exception, "Se esperaba un error pero el cálculo funcionó.");
    }
}
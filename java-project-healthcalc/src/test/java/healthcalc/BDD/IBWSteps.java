package healthcalc.BDD;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IBWSteps {

    private HealthCalc calculator = new HealthCalcImpl();
    private double height;
    private char gender;
    private double result;
    private Exception exception;

    /*@Given("la calculadora de salud está iniciada")
    public void la_calculadora_de_salud_iniciada_IBW() {
        calculator = new HealthCalcImpl();
    }*/
    
    @Given("el usuario debe haber seleccionado la métrica de cálculo de IBW")
    public void el_usuario_selecciona_metrica_IBW() {
    }
    
    @Given("el usuario ingresa para IBW una altura de {double} cm")
    public void el_usuario_ingresa_una_altura_IBW(double height) {
        this.height = height;
    }

    @Given("el genero de la persona es {word}")
    public void el_usuario_ingresa_un_genero(String genderStr) {
        this.gender = genderStr.toLowerCase().charAt(0);
    }

    @When("ejecuto la operación de cálculo de IBW")
    public void ejecuto_operacion_IBW() {
        try {
            this.result = calculator.ibw(this.height, this.gender);
            this.exception = null;
        } catch (Exception e) {
            this.exception = e;
        }
    }

    @Then("el resultado debe ser {double} kg")
    public void el_resultado_debe_ser_IBW(double expected) {
        assertEquals(expected, result, 0.01);
    }

    @Then("el sistema debe lanzar una excepción")
    public void el_sistema_debe_lanzar_una_excepcion_IBW() {
        assertNotNull(exception, "Se esperaba un error pero el cálculo funcionó.");
    }

}
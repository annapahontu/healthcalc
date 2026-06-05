Feature: Cálculo del PEso Ideal IBW
  Como usuario ede la aplicación HealthCalc
  Quiero calcular El Ideal Body Weight (IBW) de una persona basándome en su altura y genero
  Para obtener información de mi salud.

  Background:
    Given la calculadora de salud está iniciada
    And el usuario debe haber seleccionado la métrica de cálculo de IBW

  @HighPriority
  Scenario Outline: Verificar cálculos exitosos estándar
    Given el usuario ingresa para IBW una altura de <altura> cm
    And el genero de la persona es <genero>
    When ejecuto la operación de cálculo de IBW
    Then el resultado debe ser <resultado_esperado> kg

    Examples:
      | altura | genero | resultado_esperado |
      | 170    | m      | 65.0               |
      | 160    | f      | 55.0               |
      | 180    | m      | 72.5               |
      | 165    | f      | 57.5               |

  @EdgeCase
  Scenario Outline: Cálculo del IBW en los límites biológicos
    Given el usuario ingresa para IBW una altura de <altura> cm
    And el genero de la persona es <genero>
    When ejecuto la operación de cálculo de IBW
    Then el resultado debe ser <resultado_esperado> kg

    Examples:
      | altura | genero | resultado_esperado |
      | 300    | m      | 162.5              |
      | 300    | f      | 125.0              |

  @ErrorHandling @InvalidHeight 
  Scenario Outline: Intento de cálculo con altura inválida
    Given el usuario ingresa para IBW una altura de <altura> cm
    And el genero de la persona es <genero>
    When ejecuto la operación de cálculo de IBW
    Then el sistema debe lanzar una excepción

  Examples:
      | altura | genero |
      | -10    | m      |
      | 301    | f      |

    @ErrorHandling @InvalidGender
    Scenario Outline: Intento de cálculo con genero inválido
    Given el usuario ingresa para IBW una altura de <altura> cm
    And el genero de la persona es <genero>
    When ejecuto la operación de cálculo de IBW
    Then el sistema debe lanzar una excepción

    Examples:
        | altura | genero |
        | 170    | r      |
        | 160    | p      |
        | 180    | c      |
        | 165    | g      |
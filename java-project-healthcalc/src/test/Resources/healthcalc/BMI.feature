Feature: Cálculo del Índice de Masa Corporal (BMI)
  Como usuario de la aplicación HealthCalc
  Quiero calcular mi Índice de Masa Corporal (BMI) a partir de mi peso y altura
  Para obtener información clínica precisa sobre mi estado de salud

  Background:
    Given la calculadora de salud debe estar iniciada para BMI
    And el usuario ha seleccionado la métrica de BMI para calcular

  @HighPriority
  Scenario Outline: Verificación de cálculos exitosos estándar
    Given el usuario ingresa un peso para BMI de <peso> kg
    And el usuario ingresa una altura para BMI de <altura> cm
    When el sistema intenta calcular el BMI
    Then el resultado debe ser <resultado_esperado> para BMI

    Examples:
      | peso | altura | resultado_esperado |
      |70    | 175    | 22.86              |
      |85    | 180    | 26.23              |

  @EdgeCase
  Scenario Outline: Cálculo del BMI en los límites biológicos permitidos
    Given el usuario ingresa un peso para BMI de <peso> kg
    And el usuario ingresa una altura para BMI de <altura> cm
    When el sistema intenta calcular el BMI
    Then el resultado debe ser <resultado_esperado> para BMI

    Examples:
      | peso | altura | resultado_esperado |
      |1.0   | 30.0   | 11.11              |
      |700.0 | 300.0  | 77.78              |

  @ErrorHandling @InvalidWeight
  Scenario Outline: Intento de cálculo con un peso inválido o fuera de rango
    Given el usuario ingresa un peso para BMI de <peso_invalido> kg
    And el usuario ingresa una altura para BMI de 170.0 cm
    When el sistema intenta calcular el BMI
    Then el sistema debe lanzar una excepción de datos de salud inválido para BMI

    Examples:
      | peso_invalido|
      | -1.0         |
      | 0.0          |
      | 0.9          |
      | 10000.0      |
      | 700.5        |

  @ErrorHandling @InvalidHeight
  Scenario Outline: Intento de cálculo con una altura inválida o fuera de rango
    Given el usuario ingresa un peso para BMI de 70.0 kg
    And el usuario ingresa una altura para BMI de <altura_invalida> cm
    When el sistema intenta calcular el BMI
    Then el sistema debe lanzar una excepción de datos de salud inválido para BMI

    Examples:
      | altura_invalida |
      | -1.0            |
      | 0.0             |
      | 29.9            |
      | 10000.0         |
      | 300.5           |
Feature: Cálculo del Área de Superficie Corporal (BSA)
  Como usuario de la aplicación HealthCalc
  Quiero calcular mi Área de Superficie Corporal (BSA) a partir de mi peso y altura
  Para obtener información clínica precisa sobre mi estado de salud

  Background:
    Given la calculadora de salud está iniciada
    And el usuario ha seleccionado la métrica BSA para calcular

  @HighPriority
  Scenario Outline: Verificación de cálculos exitosos estándar
    Given el usuario ingresa un peso de <peso> kg
    And el usuario ingresa una altura de <altura> cm
    When el sistema intenta calcular el BSA
    Then el resultado debe ser <resultado_esperado>

    Examples:
      | peso | altura | resultado_esperado |
      | 70.0 | 175.0  | 1.84               |
      | 85.0 | 180.0  | 2.06               |

  @EdgeCase
  Scenario Outline: Cálculo del BSA en los límites biológicos permitidos
    Given el usuario ingresa un peso de <peso> kg
    And el usuario ingresa una altura de <altura> cm
    When el sistema intenta calcular el BSA
    Then el resultado debe ser <resultado_esperado>

    Examples:
      | peso  | altura | resultado_esperado |
      | 1.0   | 30.0   | 0.09               |
      | 700.0 | 300.0  | 7.64               |

  @ErrorHandling @InvalidWeight
  Scenario Outline: Intento de cálculo con peso inválido o fuera de rango
    Given el usuario ingresa un peso de <peso_invalido> kg
    And el usuario ingresa una altura de 170.0 cm
    When el sistema intenta calcular el BSA
    Then el sistema debe lanzar una excepción de datos de salud inválidos

    Examples:
      | peso_invalido |
      | 0.0           |
      | -70.0         |
      | -154.0        |
      | 0.99          |
      | 700.1         |
      | 1000.0        |

  @ErrorHandling @InvalidHeight
  Scenario Outline: Intento de cálculo con altura inválida o fuera de rango
    Given el usuario ingresa un peso de 70.0 kg
    And el usuario ingresa una altura de <altura_invalida> cm
    When el sistema intenta calcular el BSA
    Then el sistema debe lanzar una excepción de datos de salud inválidos

    Examples:
      | altura_invalida |
      | 0.0             |
      | -170.0          |
      | -3.0            |
      | 29.9            |
      | 300.1           |
      | 500.0           |
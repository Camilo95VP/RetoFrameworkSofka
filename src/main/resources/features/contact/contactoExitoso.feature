# language: es

@FeatureName:realizarContactoExitoso
Característica: Realizar contacto exitoso
  como cliente en linea
  necesito contactarme
  para realizar una solicitud

  @ScenarioName:contactoExitoso
  Escenario: Contacto Exitoso
    Dado que el cliente navegó hasta la sección principal
    Cuando el cliente se registre para realizar una solicitud de contacto
    Entonces el cliente podrá observar que se realizo la solicitud de contacto
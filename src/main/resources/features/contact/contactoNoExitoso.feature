# language: es

@FeatureName:realizarContactoNoExitoso
Característica: Realizar contacto no exitoso
  como cliente en linea
  necesito contactarme
  para realizar una solicitud

  @ScenarioName:contactoExitoso
  Escenario: Contacto No Exitoso
    Dado que el cliente navegó hasta al home
    Cuando el cliente se registre para realizar una solicitud de contacto sin llenar todos los campos
    Entonces el cliente podrá observar que no se realizo la solicitud de contacto
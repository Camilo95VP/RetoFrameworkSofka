# language: es

@FeatureName:realizarCompraUsuarioNoLogueado
Característica: Realizar compra con ususario no logueado
  como cliente en linea
  necesito agregar productos al carro
  para realizar una compra

  @ScenarioName:compraExitosaConUsuarioNoLogueado
  Escenario: Compra exitosa con usuario no logueado
    Dado que el cliente navegó hasta la sección principal
    Cuando el cliente agregue los productos al carro y realice la compra
    Entonces el cliente podrá observar que se realizo la compra correctamente
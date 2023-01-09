# language: es

  @FeatureName:realizarCompraUsuarioLogueado
  Característica: Realizar compra con ususario logueado
    como cliente registrado
    necesito agregar productos al carro
    para realizar una compra

  @ScenarioName:compraExitosaConUsuarioLogueado
  Escenario: Compra exitosa
    Dado que el cliente navegó hasta la página principal
    Cuando el cliente se registre y se loguee
    Y el cliente agregue los productos al carro y realice el procedimiento de compra
    Entonces el cliente podrá observar que se realizo correctamente la compra

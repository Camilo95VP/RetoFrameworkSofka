# language: es

@FeatureName:realizarCompraNoExitosa
Característica: Realizar compra sin aceptar terminos y condiciones
  como cliente en linea
  necesito agregar productos al carro
  para realizar una compra

  @ScenarioName:compraNoExitosa
  Escenario: Compra no exitosa por no aceptar terminos y condiciones
    Dado que el cliente navegó hasta la sección principal
    Cuando el cliente agregue los productos al carro sin aceptar terminos al terminar la compra
    Entonces el cliente podrá observar que no se realizo la compra correctamente
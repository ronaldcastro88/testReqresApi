# language: es
Característica: Creación exitosa de un usuario
  Yo como flujo de registro
  quiero validar que permita crear usuarios
  para retornar la data del usuario

  @CreacionExitosaUsuario
  Escenario: Creación exitosa
    Cuando el envia los datos de creacion
    Entonces debe ver el status 200
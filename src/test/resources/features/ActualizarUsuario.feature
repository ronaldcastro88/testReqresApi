# language: es
Característica: Creación exitosa de un usuario

  @ActualizacionExitosaUsuario
  Escenario: Actualización exitosa
    Cuando el envia los datos de actualizacion
    Entonces debe ver el status 200 con los datos nuevos del usuario
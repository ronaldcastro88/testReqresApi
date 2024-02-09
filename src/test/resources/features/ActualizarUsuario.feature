# language: es
Característica: Actualización exitosa de un usuario
  Yo como flujo de actualización
  quiero validar que permita reemplazar la información
  para retornar los nuevos datos básicos


  @ActualizacionExitosaUsuario
  Escenario: Actualización exitosa
    Cuando el envia los datos de actualizacion
    Entonces debe ver el status 200 con los datos nuevos del usuario
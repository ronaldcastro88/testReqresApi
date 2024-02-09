# language: es
Característica: Eliminación exitosa de un usuario
  Yo como flujo de eliminación
  quiero validar que permita suprimir la información del usuario
  para que no exista en el portal

  @EliminacionExitosaUsuario
  Escenario: Eliminación exitosa de un usuario
    Cuando elimina el usuario
    Entonces debe ver el status 204 confirmando que el usuario fue eliminado
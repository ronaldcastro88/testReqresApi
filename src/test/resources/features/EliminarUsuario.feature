# language: es
Característica: Eliminación exitosa de un usuario

  @EliminacionExitosaUsuario
  Escenario: Eliminación exitosa de un usuario
    Cuando elimina el usuario
    Entonces debe ver el status 204 confirmando que el usuario fue eliminado
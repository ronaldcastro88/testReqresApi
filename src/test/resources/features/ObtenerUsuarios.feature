# language: es
Característica: Consultar los usuarios creados en el sitio

  @ObtenerListadoUsuarios
  Escenario: Consulta el listado de usuario que están creados en el sitio
    Cuando consulta el listado de usuarios
    Entonces debe ver cada usuario con sus caracteristicas

  @ConsultarUsuario
  Escenario: Consultar usuario único
    Cuando consulta un usuario
    Entonces debe ver los datos del usuario consultado

  @ConsultarUsuarioInexistente
  Escenario: Consultar un usuario que no existe
    Cuando consulta un usuario que no existe en el portal
    Entonces el usuario no debe existir y no muestra datos del mismo
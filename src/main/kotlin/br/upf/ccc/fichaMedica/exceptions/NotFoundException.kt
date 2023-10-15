package br.upf.ccc.fichaMedica.exceptions

class NotFoundException(override val message: String)
    : RuntimeException()
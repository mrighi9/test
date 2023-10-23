package br.upf.sistemahotel.exceptions

import java.lang.RuntimeException

class NotFoundException(override val message: String)
    : RuntimeException()
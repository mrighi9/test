package br.upf.sistemaeventos.exceptions

import java.lang.RuntimeException

class NotFoundException(override val message: String)
    : RuntimeException()
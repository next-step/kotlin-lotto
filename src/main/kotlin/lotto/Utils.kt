package lotto

fun argumentError(message: String): Nothing = throw IllegalArgumentException(message)

fun unsupportedError(message: String): Nothing = throw UnsupportedOperationException(message)

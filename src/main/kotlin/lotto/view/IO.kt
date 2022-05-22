package lotto.view

fun interface Input {
    fun read(): String
}

fun interface Output {
    fun print(message: String)
}

interface IO : Input, Output

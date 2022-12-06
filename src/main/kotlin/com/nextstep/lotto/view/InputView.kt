package com.nextstep.lotto.view

object InputView {
    fun inputMessage(): String {
        return readln()
    }

    fun splitWith(input: String, delimiter: String): List<String> {
        return input.split(delimiter)
    }
}

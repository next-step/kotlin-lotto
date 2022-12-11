package com.nextstep.lotto.view

object InputView {
    fun inputMessage(): String {
        return readln()
    }

    fun inputMessageSplitWithComma(): List<String> {
        return readln().split(",")
    }
}

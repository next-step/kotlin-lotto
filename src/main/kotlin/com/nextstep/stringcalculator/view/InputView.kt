package com.nextstep.stringcalculator.view

object InputView {
    fun input(): String? {
        println("덧셈을 원하는 문자열을 입력해주세요.")
        return readLine() ?: throw IllegalArgumentException("")
    }
}

package com.nextstep.stringcalculator.view

object InputView {
    fun input(): String {
        println("덧셈을 원하는 문자열을 입력해주세요.")
        return readLine() ?: throw IllegalArgumentException("문자열에 null이 들어가서는 안됩니다.")
    }
}

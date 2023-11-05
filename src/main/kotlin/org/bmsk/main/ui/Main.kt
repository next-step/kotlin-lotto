package org.bmsk.main.ui

import org.bmsk.domain.model.StringAdditionCalculator

fun main() {
    println("계산하고 싶은 문자열을 입력해보세요.")
    val stringFormula = readln()
    val result = StringAdditionCalculator(stringFormula).calculate()
    println(result)
}

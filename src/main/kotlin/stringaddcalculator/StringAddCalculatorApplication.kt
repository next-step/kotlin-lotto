package stringaddcalculator

import stringaddcalculator.domain.StringAddCalculator
import stringaddcalculator.domain.StringSeparator

fun main() {
    println("문자열을 입력해주세요.")
    val inputString = readLine()!!.toString()
    val tokens = StringSeparator.separate(inputString)
    val result = StringAddCalculator.calculate(tokens)
    println("결과값 : $result")
}

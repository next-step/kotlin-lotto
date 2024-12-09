package calculator

import java.util.*

fun main() {
    println("계산식을 입력해주세요.")
    val sc = Scanner(System.`in`)
    val result = StringCalculator.calculate(sc.nextLine())
    println(result);
}

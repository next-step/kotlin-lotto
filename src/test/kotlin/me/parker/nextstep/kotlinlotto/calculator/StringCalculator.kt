package me.parker.nextstep.kotlinlotto.calculator

object StringCalculator {
    fun add(input: String): Int {
        return input.split(",", ":").sumOf { it.toInt() }
    }
}

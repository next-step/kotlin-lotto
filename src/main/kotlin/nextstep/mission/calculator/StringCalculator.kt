package nextstep.mission.calculator

object StringCalculator {

    fun calculate(acc: Int = 0, expression: MutableList<Int> = mutableListOf()): Int = when {
        expression.isEmpty() -> acc
        expression.first() < 0 -> throw RuntimeException()
        else -> -1
    }
}

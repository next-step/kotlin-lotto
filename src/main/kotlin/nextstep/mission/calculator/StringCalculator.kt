package nextstep.mission.calculator

object StringCalculator {

    fun calculate(acc: Int = 0, expression: MutableList<Int> = mutableListOf()): Int = when {
        expression.isEmpty() -> acc
        else -> -1
    }
}

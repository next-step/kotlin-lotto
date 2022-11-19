package nextstep.mission.calculator

object StringCalculator {

    tailrec fun calculate(acc: Int = 0, expression: MutableList<Int> = mutableListOf()): Int = when {
        expression.isEmpty() -> acc
        expression.first() < 0 -> throw RuntimeException()
        else -> calculate(acc + expression.removeFirst(), expression)
    }
}

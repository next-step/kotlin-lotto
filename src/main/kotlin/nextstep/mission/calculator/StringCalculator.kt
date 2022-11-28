package nextstep.mission.calculator

object StringCalculator {

    fun calculate(expression: List<Int>): Int {
        tailrec fun calculate(acc: Int, expression: MutableList<Int>): Int = when {
            expression.isEmpty() -> acc
            expression.first() < 0 -> throw RuntimeException()
            else -> calculate(acc + expression.removeFirst(), expression)
        }
        return calculate(0, expression.toMutableList())
    }
}

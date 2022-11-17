package nextstep.mission.calculator

class StringCalculator {

    fun calculate(expression: String): Int {
        if (expression.isEmpty()) {
            return 0
        }

        if (expression.toInt() < 0) {
            throw RuntimeException()
        }

        return -1
    }
}

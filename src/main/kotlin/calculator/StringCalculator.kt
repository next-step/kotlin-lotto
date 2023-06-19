package calculator

class StringCalculator {
    fun calculate(expression: String?): Long {
        if (expression.isNullOrEmpty()) {
            return 0
        }

        return expression.split("[,:]".toRegex())
            .map(this::toNumber)
            .sum()
    }

    private fun toNumber(s: String): Long {
        require(s.toLong() > -1) { "0 이상의 숫자여야 합니다." }
        return s.toLong()
    }
}

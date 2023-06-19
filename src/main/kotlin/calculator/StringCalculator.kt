package calculator

class StringCalculator {
    fun calculate(expression: String?): Long {
        if (expression.isNullOrEmpty()) {
            return 0
        }

        return execute(expression)
    }

    private fun execute(expression: String): Long {
        val result = Regex("//(.)\n(.*)").find(expression)
        result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
                .sumOf { v -> toNumber(v) }
        }

        return expression.split("[,:]".toRegex())
            .sumOf { v -> toNumber(v) }
    }

    private fun toNumber(s: String): Long {
        require(s.toLong() > -1) { "0 이상의 숫자여야 합니다." }
        return s.toLong()
    }
}

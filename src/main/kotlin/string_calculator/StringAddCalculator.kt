package string_calculator

class StringAddCalculator {
    fun calculate(input: String): Int {
        val (delimiters, expression) =
            if (input.startsWith("//")) {
                val matchResult = Regex("//(.)\n(.*)").find(input) ?: throw RuntimeException("커스텀 구분자 설정이 제대로 되지 않았습니다")
                val customDelimiter = matchResult.groupValues[1]
                val numbersPart = matchResult.groupValues[2]
                println("customDelimiter ${customDelimiter}\nnumbersPart ${numbersPart}")

                "$customDelimiter|,|:".toRegex() to numbersPart
            } else {
                ",|:".toRegex() to input
            }

        val expressionTokens = expression.split(delimiters)
        println("$expressionTokens")
        return expressionTokens.sumOf {

            val num = if (it.isBlank()) 0 else it.toIntOrNull() ?: throw RuntimeException("숫자로 변환할 수 없습니다")
            if (num < 0) throw RuntimeException("음수는 입력할 수 없습니다")
            num
        }
    }
}
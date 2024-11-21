package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        // 빈 문자열 또는 null 값을 입력할 경우 0을 반환
        if (text.isNullOrEmpty()) {
            return 0
        }

        return try {
            getResultBySingleNumber(text)
        } catch (_: NumberFormatException) {
            getResultByNumbers(text)
        }
    }

    // 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환
    private fun getResultBySingleNumber(text: String): Int =
        // 음수를 전달할 경우 RuntimeException 예외 발생
        text.toInt().takeIf { it > 0 }
            ?: throw RuntimeException(ERROR_MESSAGE)

    // 숫자 여러개를 입력한 경우 구분자로 분리하고, 숫자의 총 합을 반환한다.
    private fun getResultByNumbers(text: String): Int {
        //  "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다
        val result = Regex(REGEX_PATTERN).find(text)

        return result?.let {
            // 커스텀 구분자로 여러개의 문자를 보낸 경우
            sum(text = it.groupValues[2], delimiter = it.groupValues[1])
        } ?: sum(text = text, delimiter = DEFAULT_DELIMITER)
    }

    private fun sum(
        text: String,
        delimiter: String,
    ): Int {
        val numbers = getNumbers(text = text, regex = delimiter.toRegex())

        // 음수를 전달할 경우 RuntimeException 예외 발생
        if (numbers.stream().anyMatch { number -> number.toInt() < 0 }) {
            throw RuntimeException(ERROR_MESSAGE)
        }

        return numbers.sumOf { number -> number }
    }

    private fun getNumbers(
        text: String,
        regex: Regex,
    ): List<Int> = text.split(regex).map(String::toInt)

    companion object {
        const val ERROR_MESSAGE = "문자열 계산기는 음수를 처리할 수 없습니다."
        const val REGEX_PATTERN = "//(.)\n(.*)"
        const val DEFAULT_DELIMITER = "[,:]"
    }
}

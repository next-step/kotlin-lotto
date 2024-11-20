package calculator

class Calculator {
    fun execute(text: String?): Int {
        if (text.isNullOrBlank()) return 0
        val result = Regex(CUSTROM_DELIMITER).find(text)

        return if (result == null) {
            // 기본 구분자 처리
            this.sum(text.split(Regex(BASIC_DELIMITER)))
        } else {
            // 커스텀 구분자 처리
            // TODO: 아래 코드를 함수로 빼기
            val customDelimiter = result.groupValues[1]
            this.sum(result.groupValues[2].split(customDelimiter))
        }
    }

    fun sum(input: List<String>): Int {
        // TODO: 인덴트를 1로 줄이기 (함수로 빼기?)
        try {
            return input.sumOf {
                val number = it.toInt()
                if (number < 0) {
                    throw RuntimeException("음수 값은 더할 수 없습니다. [$number] in $this")
                }
                number
            }
        } catch (e: NumberFormatException) {
            throw RuntimeException("숫자 이외의 값은 더할 수 없습니다. [$this]")
        }
    }

    companion object {
        const val BASIC_DELIMITER = ",|:"
        const val CUSTROM_DELIMITER = "//(.)\n(.*)"
    }
}

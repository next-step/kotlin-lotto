package calculator

object StringAddCalculator {
    private const val DELIMITERS = "[,:]"

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val customResult = Regex("//(.)\n(.*)").find(text)

        customResult?.let { matchResult ->
            val customDelimiter = matchResult.groupValues[1]
            val numbers = matchResult.groupValues[2].split(customDelimiter)

            numbers.forEach {
                val number = it.toIntOrNull()
                if (number == null || number < 0) {
                    throw RuntimeException("숫자 이외의 값 또는 음수가 입력될 경우 계산할 수 없습니다.")
                }
            }
            return numbers.sumOf { it.toInt() }
        }

        val numbers = text.split(DELIMITERS.toRegex())

        numbers.forEach {
            val number = it.toIntOrNull()
            if (number == null || number < 0) {
                throw RuntimeException("숫자 이외의 값 또는 음수가 입력될 경우 계산할 수 없습니다.")
            }
        }
        return numbers.sumOf { it.toInt() }
    }
}

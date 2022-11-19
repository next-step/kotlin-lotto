package calculator

class Calculator {
    fun calculate(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val numbers = parse(text)

        if(hasNegativeNumber(numbers)){
            throw RuntimeException("계산기에 음수는 입력할 수 없습니다.")
        }

        return numbers.sum()
    }

    private fun parse(text: String): List<Int> {
        val result = Regex("//(.)\n(.*)").find(text)
        result?.let {
            val customDelimiter = it.groupValues[1]

            return it.groupValues[2]
                .split(customDelimiter)
                .map { number -> number.toInt() }
        }

        return text.split("[,:]".toRegex())
            .map { number -> number.toInt() }
    }

    private fun hasNegativeNumber(numbers: List<Int>): Boolean {
        return numbers.any { number -> number < 0 }
    }
}

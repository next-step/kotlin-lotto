package caculator.ui

class Input(inputString: String) {
    val numbers: List<Int>

    init {
        val result = Regex("//(.)\n(.*)").find(inputString)
        numbers = result?.let {
            splitInputString(it.groupValues[2], Regex(it.groupValues[1]))
        } ?: splitInputString(inputString, Regex(DEFAULT_DELIMITERS.joinToString(separator = "|")))
    }

    private fun splitInputString(inputString: String, regex: Regex): List<Int> {
        return inputString.split(regex)
            .map {
                parseInt(it)
            }
    }

    private fun parseInt(input: String): Int {
        if (input.isEmpty()) {
            return 0
        }
        val parsedInput = input.toIntOrNull() ?: throw NumberFormatException("입력값이 정수가 아닙니다")
        validate(parsedInput)
        return parsedInput
    }

    private fun validate(parsedInput: Int) {
        require(parsedInput >= 0) {
            "입력값은 음수가 올 수 없습니다"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Input

        if (numbers != other.numbers) return false

        return true
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }

    companion object {
        val DEFAULT_DELIMITERS = listOf(",", ":")
    }
}

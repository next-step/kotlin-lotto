package caculator.ui

class Input(inputString: String) {
    val numbers: List<Int>

    init {
        numbers = inputString.split(Regex(DEFAULT_TOKENS.joinToString(separator = "|")))
            .map {
                parseInt(it)
            }
    }

    private fun parseInt(input: String): Int {
        val parsedInput = input.toIntOrNull() ?: throw NumberFormatException("입력값이 정수가 아닙니다")
        validate(parsedInput)
        return parsedInput
    }

    private fun validate(parsedInput: Int) {
        require(parsedInput > 0) {
            "입력값은 음수가 올 수 없습니다"
        }
    }

    companion object {
        val DEFAULT_TOKENS = listOf(",", ":")
    }
}

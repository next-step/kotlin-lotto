package calculator

class StringAddCalculator {

    fun add(text: String?) : Int {
        if(text.isNullOrBlank()) {
            return ZERO
        }
        val numbers = getStringListWithDefinedRegx(text).map { string -> string.toInt() }
        validatedMinus(numbers)
        return numbers.sum()
    }

    private fun getStringListWithDefinedRegx(text: String) : List<String> {
        return text.split(",|:".toRegex())
    }

    private fun validatedMinus(numbers: List<Int>) {
        if(numbers.any{number -> number < 0}) {
            throw RuntimeException(TEXT_MINUS_MESSAGE)
        }
    }

    companion object {
        private const val ZERO = 0
        const val TEXT_MINUS_MESSAGE = "음수를 입력할 수 없습니다."
    }
}

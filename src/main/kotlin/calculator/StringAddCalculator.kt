package calculator

class StringAddCalculator {
    fun add(text: String?) : Int {
        if(text.isNullOrBlank()) {
            return ZERO
        }
        val numbers = (getStringListWithCustomRegx(text) ?: getStringListWithDefinedRegx(text))
            .map { string -> string.toInt() }
        validatedNumber(numbers)
        return numbers.sum()
    }

    private fun getStringListWithCustomRegx(text: String) : List<String>? {
        return Regex(CUSTOM_REGX).find(text)?.let {
            it.groupValues[2].split(it.groupValues[1])
        }
    }

    private fun getStringListWithDefinedRegx(text: String) : List<String> {
        return text.split(DEFINED_REGX.toRegex())
    }

    private fun validatedNumber(numbers: List<Int>) {
        if(numbers.any{number -> number < 0}) {
            throw RuntimeException(TEXT_MINUS_MESSAGE)
        }
    }

    companion object {
        private const val CUSTOM_REGX = "//(.)\n(.*)"
        private const val DEFINED_REGX = ",|:"
        private const val ZERO = 0
        private const val TEXT_MINUS_MESSAGE = "음수를 입력할 수 없습니다."
    }
}

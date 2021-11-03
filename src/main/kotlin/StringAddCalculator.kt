class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return RETURN_NULL_OR_EMPTY_STRING
        return StringAddSplit().split(text).sumOf { validationInt(it) }
    }

    private fun validationInt(text: String): Int {
        val number = text.toIntOrNull()
        if (number == null || number < 0) throw RuntimeException(EXCEPTION_NULL_OR_EMPTY)
        return number
    }

    companion object {
        const val RETURN_NULL_OR_EMPTY_STRING = 0
        const val EXCEPTION_NULL_OR_EMPTY = "숫자가 아니거나 음수 입니다."
    }
}

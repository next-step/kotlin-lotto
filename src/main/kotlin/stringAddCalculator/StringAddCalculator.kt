package stringAddCalculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return ANSWER_NULL_OR_BLANK
        if (text.length == CASE_INPUT_LENTGHT_IS_ONE) return text.toInt()
        return addNumbersInString(text)
    }

    private fun addNumbersInString(str: String): Int {
        val nums = str.split(",", ":")
            .map { it.toInt() }
        return nums.sum()
    }

    companion object {
        const val ANSWER_NULL_OR_BLANK = 0
        const val CASE_INPUT_LENTGHT_IS_ONE = 1
    }
}

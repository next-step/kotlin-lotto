package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (isBlank(text)) return 0

        checkNegative(text!!)

        return -1
    }

    private fun isBlank(text: String?): Boolean = text.isNullOrBlank()

    private fun checkNegative(text: String) {
        if (text.contains('-')) throw RuntimeException(NOT_ALLOW_NEGATIVE)
    }

    companion object {
        private const val NOT_ALLOW_NEGATIVE = "음수 입력 불가"
    }
}

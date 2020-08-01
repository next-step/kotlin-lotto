package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (isBlank(text)) return 0

        text?.let {
            checkNegative(it)
            if (justOneNumber(it)) return it.toInt()
        }

        return 0
    }

    private fun isBlank(text: String?): Boolean = text.isNullOrBlank()

    private fun checkNegative(text: String) {
        if (text.contains('-')) throw RuntimeException(NOT_ALLOW_NEGATIVE)
    }

    private fun justOneNumber(text: String): Boolean {
        text.forEach { if (!it.isDigit()) return false }
        return true
    }

    companion object {
        private const val NOT_ALLOW_NEGATIVE = "음수 입력 불가"
    }
}

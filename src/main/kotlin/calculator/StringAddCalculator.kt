package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (isBlank(text)) return 0

        val text = text!!
        if (justOneNumber(text)) return text.toInt()

        val numbers = Number(text).numbers

        return numbers.sum()
    }

    private fun isBlank(text: String?): Boolean = text.isNullOrBlank()

    private fun justOneNumber(text: String): Boolean {
        text.forEach { if (!it.isDigit()) return false }
        return true
    }
}

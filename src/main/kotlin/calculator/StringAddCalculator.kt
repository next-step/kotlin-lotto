package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0

        val text = text!!
        if (justOneNumber(text)) return text.toInt()

        val numbers = Number(text).numbers

        return numbers.sum()
    }

    private fun justOneNumber(text: String): Boolean {
        text.forEach { if (!it.isDigit()) return false }
        return true
    }
}

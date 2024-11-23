package calculator

class StringAddCalculator {
    fun add(text: String?): Long {
        if (text.isNullOrBlank()) return 0
        return text.toLong()
    }
}

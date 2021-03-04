package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        if (1 == text.length) {
            return text.toInt()
        }
        throw RuntimeException()
    }
}

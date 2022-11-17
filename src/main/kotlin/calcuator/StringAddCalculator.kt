package calcuator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0

        text.toIntOrNull()?.let { number ->
            if (number < 0) throw RuntimeException()
            return number
        }

        return 0
    }
}

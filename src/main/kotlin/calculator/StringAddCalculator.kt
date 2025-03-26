package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        return text.split("[,:]".toRegex())
            .filter { it.isNotBlank() }
            .sumOf { it.toInt() }
    }
}

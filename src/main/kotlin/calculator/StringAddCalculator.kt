package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val numbers = text.split("[/;\n,:]".toRegex())
            .filter { it.isNotBlank() }
            .map { it.toInt() }

        if (numbers.any { it < 0 }) {
            throw RuntimeException("Number must be positive or zero")
        }

        return numbers.sum()
    }
}

package _string_add_calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        if (text.toIntOrNull() != null) {
            return text.toInt()
        }
        val numbers = text.split(",").map { it.toInt() }
        return numbers.sum()
    }
}

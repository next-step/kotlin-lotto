package _string_add_calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        if (text.toIntOrNull() != null) {
            return text.toInt()
        }
        return 0
    }
}

package calculator

class StringCalculator {
    fun add(text: String): Int {
        if (text.isEmpty()) {
            return 0
        }

        if (text.toIntOrNull() != null) {
            return text.toInt()
        }

        return 0
    }
}

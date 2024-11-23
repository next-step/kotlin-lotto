package stringcalculator.domain

class StringCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        if (input.toIntOrNull() != null) {
            return input.toInt()
        }

        return -1
    }
}

package caculator

class StringCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        if (input.toIntOrNull() != null) {
            return input.toInt()
        }

        val numbers = input.split(",|:".toRegex())

        return numbers.sumOf { it.toInt() }
    }
}

package calculator

class StringCalculator {

    fun add(input: String?): Int {
        return if (input.isNullOrBlank()) {
            0
        } else {
            val customDelimiter = Regex("//(.)\n(.*)").find(input)
            val numbers = if (customDelimiter != null) {
                customDelimiter.groupValues[2].split(customDelimiter.groupValues[1])
            } else {
                input.split(',', ':')
            }.map { it.toInt() }

            if (numbers.any { it < 0 }) throw RuntimeException()
            else numbers.sum()
        }
    }
}

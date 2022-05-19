package calculator

class StringCalculator {

    fun add(input: String?): Int {
        return if (input.isNullOrBlank()) {
            0
        } else {
            val customDelimiter = Regex("//(.)\n(.*)").find(input)
            if (customDelimiter != null) {
                customDelimiter.groupValues[2].split(customDelimiter.groupValues[1])
            } else {
                input.split(',', ':')
            }.sumOf { it.toInt() }
        }
    }
}

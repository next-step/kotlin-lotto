package calculator

import java.util.regex.Pattern

class StringAddCalculator {
    fun calculate(input: String?): Int {
        if (input == null || input.isEmpty()) {
            return 0
        }

        val matcher = Pattern.compile("//(.)\\n(.*)").matcher(input)
        if (matcher.find()) {
            val delimiter = matcher.group(1)
            return matcher.group(2)
                .split(delimiter)
                .sumOf {
                    val number = it.toInt()
                    if (number < 0) {
                        throw IllegalArgumentException()
                    }
                    number
                }
        }

        val numbers = input.split(",", ":")
        return numbers.sumOf {
            val number = it.toInt()
            if (number < 0) {
                throw IllegalArgumentException()
            }
            number
        }
    }
}

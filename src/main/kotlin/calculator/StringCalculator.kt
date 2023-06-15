package calculator

class StringCalculator {

    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) return 0

        if (input.length == 1) {
            val parsedInput = input.toIntOrNull()
            if (parsedInput == null || parsedInput < 0) {
                throw RuntimeException()
            }

            return parsedInput
        }

        val customDelimiterRegex = Regex("//(.)\n(.*)")
        customDelimiterRegex.find(input)?.let { result ->
            val customDelimiter = result.groupValues[1]
            val tokens = result.groupValues[2].split(customDelimiter)

            return tokens.sumOf { token -> token.toInt() }
        }

        val defaultDelimiters = "[,:]".toRegex()
        return input.split(defaultDelimiters).sumOf { it.toInt() }
    }
}

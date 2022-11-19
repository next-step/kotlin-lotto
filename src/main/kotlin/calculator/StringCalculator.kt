package calculator

class StringCalculator {

    fun calculate(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        val result = Regex("//(.)\n(.*)").find(text)
        result?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)

            return tokens.map { token -> token.toPositiveNumber() }
                .reduce() { sum, number -> sum + number }
                .toInt()
        }


        val tokens = text.split(",|:".toRegex())

        if (tokens.size == 1) {
            return tokens[0].toPositiveNumber().toInt()
        }

        return tokens.map { token -> token.toPositiveNumber() }
            .reduce() { sum, number -> sum + number }
            .toInt()
    }


    private fun String.toPositiveNumber(): PositiveNumber {
        return PositiveNumber.of(this)
    }
}

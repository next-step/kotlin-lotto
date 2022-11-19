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
                .fold(0) { sum, number -> sum + number }
        }


        val tokens = text.split(",|:".toRegex())

        if (tokens.size == 1) {
            return tokens[0].toPositiveNumber()
        }

        return tokens.map { token -> token.toPositiveNumber() }
            .fold(0) { sum, number -> sum + number }
    }


    private fun String.toPositiveNumber(): Int {
        val value = this.toInt()
        if (value < 0) {
            throw RuntimeException("음수는 올 수 없어요")
        }

        return value
    }
}

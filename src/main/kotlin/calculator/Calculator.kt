package calculator

class Calculator {
    fun calculate(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val numbers = parse(text)

        return numbers.sumOf { number -> number.toInt() }
    }

    private fun parse(text: String): List<String> {
        val result = Regex("//(.)\n(.*)").find(text)
        result?.let {
            val customDelimiter = it.groupValues[1]

            return it.groupValues[2]
                .split(customDelimiter)
        }

        return text.split("[,:]".toRegex())
    }
}

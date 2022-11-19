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
        return text.split("[,:]".toRegex())
    }
}

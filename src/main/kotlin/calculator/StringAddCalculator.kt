package calculator

class StringAddCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrEmpty()) return 0
        val numbers = parseInput(input)
        return numbers.sum()
    }


    private fun parseInput(input: String): List<Int> {
        val result = Regex("//(.)\n(.*)").find(input)
        val tokens = if (result != null) {
            val customDelimiter = result.groupValues[1]
            result.groupValues[2].split(customDelimiter)
        } else {
            input.split("[,:]".toRegex())
        }
        return tokens.toInts()
    }

    private fun List<String>.toInts(): List<Int> {
        return this.map {
            val number = it.trim().toIntOrNull()
                ?: throw IllegalArgumentException("Non-numeric value entered")
            require(number > 0) { "Negative value entered" }
            number
        }


    }
}
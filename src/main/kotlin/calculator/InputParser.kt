package calculator

class InputParser {
    fun parseInput(input: String): List<Int> {
        if (input.isBlank()) {
            return emptyList()
        }

        val customDelimiterResult = Regex("//(.)\n(.*)").find(input)

        return customDelimiterResult?.let {
            val (customDelimiter: String, numbers: String) = it.destructured
            numbers.split(customDelimiter).map(String::toInt)
        } ?: input.split("[,:]".toRegex()).map {
            it.toIntOrNull() ?: throw RuntimeException("Invalid number format.")
        }
    }
}

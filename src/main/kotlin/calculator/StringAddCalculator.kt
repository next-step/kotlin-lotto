package calculator

class StringAddCalculator {

    fun add(text: String?): Int {

        if (text.isNullOrEmpty()) {
            return 0;
        }

        if (text.length == 1) {
            return text.toInt();
        }

        val numbers = parse(text)
        validateNumbers(numbers)
        return numbers.sum()
    }

    private fun validateNumbers(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw RuntimeException("음수는 허용되지 않습니다.")
        }
    }

    fun parse(text: String): List<Int> {
        return when {
            text.length == 1 -> listOf(text.toInt())
            text.length == 2 && text.startsWith("-") -> throw RuntimeException("음수는 허용되지 않습니다.")
            text.startsWith("//") && text.contains("\n") -> parseWithCustomDelimiter(text)
            text.contains(",") || text.contains(":") -> parseWithDefaultDelimiters(text)
            text.contains("[,:]".toRegex()) -> parseWithDefaultDelimiters(text)
            else -> emptyList()
        }
    }

    private fun parseWithDefaultDelimiters(text: String): List<Int> {
        return text.split("[,:]".toRegex())
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
    }

    private fun parseWithCustomDelimiter(text: String): List<Int> {
        val delimiter = text.substring(2, 3)
        return text.substring(4)
            .split(delimiter)
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
    }
}

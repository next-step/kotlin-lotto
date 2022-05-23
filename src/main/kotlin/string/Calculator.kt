package string

object Calculator {
    private const val DELIMITER_REGEX = ",|:"

    fun sum(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        return add(parse(input))
    }

    private fun add(inputs: List<String>): Int {
        return inputs.sumOf { it.toInt() }
    }

    private fun parse(input: String): List<String> {
        return validateEach(split(input))
    }

    private fun split(input: String): List<String> {
        return customDelimiterSplit(input) ?: input.split(DELIMITER_REGEX.toRegex())
    }

    private fun customDelimiterSplit(input: String): List<String>? {
        val result = Regex("//(.)\n(.*)").find(input)

        return result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split("$customDelimiter|${DELIMITER_REGEX}".toRegex())
        }
    }

    private fun validateEach(inputs: List<String>): List<String> {
        for (input in inputs) {
            validateEachInput(input)
        }

        return inputs
    }

    private fun validateEachInput(input: String) {
        val num = input.toIntOrNull()

        if (num == null || num < 0) {
            throw RuntimeException("음수 혹은 숫자가 아닌 값이 들어왔습니다")
        }
    }
}

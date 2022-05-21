package string

class Calculator() {
    fun sum(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        return add(parse(input))
    }

    private fun add(inputs: List<String>): Int {
        var result = 0

        for (input in inputs) {
            result += input.toInt()
        }

        return result
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
            return it.groupValues[2].split(customDelimiter)
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

    companion object {
        private const val DELIMITER_REGEX = ",|:"
    }
}

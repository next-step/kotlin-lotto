package calculator

object Calculator {
    private const val FIND_DELIMITER_AND_OPERAND_PATTERN = "//(.)\n(.*)"
    private val FIND_DELIMITER_AND_OPERAND_PATTERN_REGEX = Regex(FIND_DELIMITER_AND_OPERAND_PATTERN)

    private const val DELIMITER_INDEX = 1
    private const val OPERANDS_INDEX = 2
    private const val MINIMUM_OPERAND_VALUE = 0


    fun add(input: String): Int {
        if (input.isBlank()) {
            return MINIMUM_OPERAND_VALUE
        }

        val result = FIND_DELIMITER_AND_OPERAND_PATTERN_REGEX.find(input) ?: return addWhenNotExistCustomDelimiter(input)

        result.let {
            val delimiter = it.groupValues[DELIMITER_INDEX]
            val operands = it.groupValues[OPERANDS_INDEX]

            return operands.splitExceptBlank(delimiter).map { operand -> operand.toIntOnlyPositive() }.sum()
        }
    }

    private fun addWhenNotExistCustomDelimiter(input: String): Int {
        return input.split(Delimiters.COMMA.value, Delimiters.SEMICOLON.value)
            .filter { it.isNotBlank() }
            .map { it.toIntOnlyPositive() }
            .sum()
    }

    private fun String.splitExceptBlank(delimiter: String): List<String> {
        return this.split(delimiter).filter { it.isNotBlank() }
    }

    private fun String.toIntOnlyPositive(): Int {
        val toInt = this.toIntOrNull() ?: throw throw IllegalArgumentException("잘못된 값입니다.")

        require(toInt >= MINIMUM_OPERAND_VALUE) { "음수는 입력할 수 없습니다" }

        return toInt
    }
}

package add_calculator

private val DEFAULT_OPERANDS = listOf(Operand("0"))

class InputParser {

    fun parse(input: String?): List<Operand> {

        if (input.isNullOrBlank()) {
            return DEFAULT_OPERANDS
        }

        val result = Regex("//(.)\n(.*)").find(input)

        result?.let {
            val customDelimiter = it.groupValues[1]
            val texts = it.groupValues[2].split(customDelimiter)
            return toOperands(texts)
        }

        val texts = input.split(",|:".toRegex())
        return toOperands(texts)
    }

    private fun toOperands(texts: List<String>): List<Operand> {
        return texts.map { text ->
            Operand(text)
        }
    }
}

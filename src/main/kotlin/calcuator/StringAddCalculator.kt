package calcuator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return ZERO

        val textOperands: List<String> = TokenizeUtil.tokenizes(text)

        return textOperands
            .mapNotNull { textOperand -> textOperand.toIntOrNull() }
            .map { number -> Operand(number) }
            .sumOf { operand -> operand.number }
    }

    companion object {
        private const val ZERO = 0
    }
}

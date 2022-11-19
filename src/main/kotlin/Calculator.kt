class Calculator {
    fun execute(expression: String): Int {
        val delimiter = DelimiterExtractor.run(expression)
        val operands = OperandParser.run(expression, delimiter)
        validate(operands)

        return operands.sum()
    }

    private fun validate(operands: List<Int>) {
        operands.forEach {
            require(it >= 0) { "양수를 입력 해 주세요." }
        }
    }
}

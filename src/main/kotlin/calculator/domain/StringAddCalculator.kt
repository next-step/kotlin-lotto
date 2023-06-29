package calculator.domain

class StringAddCalculator {

    fun execute(operation: String?): Int {
        if (operation.isNullOrBlank()) return 0
        val operationTokens = getOperationTokens(operation)

        return operationTokens.sum()
    }

    private fun getOperationTokens(operation: String): OperationTokens {
        return OperationParser.parse(operation)
    }
}

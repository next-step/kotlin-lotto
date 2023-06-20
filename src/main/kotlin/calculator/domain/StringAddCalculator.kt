package calculator.domain

class StringAddCalculator {

    fun execute(operation: String?): Int {
        if (operation.isNullOrEmpty()) return 0
        if (operation.length == 1) operation.toInt()

        val operationTokens = OperationParser.parse(operation)
        return operationTokens.sum()
    }
}

package calculator.domain

object OperationParser {

    private const val DEFAULT_DELIMITER = "[,:]"

    fun parse(operation: String) = OperationTokens(operation.split(DEFAULT_DELIMITER.toRegex()))
}

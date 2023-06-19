package calculator.domain

class StringAddCalculator {

    fun execute(operation: String?): Int {
        if (operation.isNullOrEmpty()) return 0

        return operation.toInt()
    }
}

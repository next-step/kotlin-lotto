package calculator

data class StringAddCalculator(val accumulatedResult: Int = 0, val nextNumber: Int) {
    fun add() = accumulatedResult + nextNumber
}

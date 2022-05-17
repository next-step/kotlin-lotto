package calculator

object Calculator {
    fun calculate(input: String?): Int {
        return input?.toIntOrNull() ?: 0
    }
}
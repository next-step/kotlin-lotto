package calculator.domain

class StringAddCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }
        return -1
    }
}

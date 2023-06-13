package string.add.calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        if (text.isBlank()) {
            return 0
        }

        return calculate(text)
    }

    private fun calculate(text: String): Int {
        return 1
    }
}

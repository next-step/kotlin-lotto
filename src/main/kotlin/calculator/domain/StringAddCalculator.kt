package calculator.domain

class StringAddCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        if (isOneNumber(input)) {
            checkNegative(input.toInt())
            return input.toInt()
        }

        return -1
    }

    private fun isOneNumber(input: String): Boolean {
        return input.length == 1
    }

    private fun checkNegative(number: Int) {
        require(number >= 1) { "음수 입력 불가" }
    }
}

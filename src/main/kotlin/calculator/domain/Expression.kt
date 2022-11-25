package calculator.domain

class Expression(input: String) {
    val values = generateValues(input)

    private fun generateValues(input: String): List<String> {
        return if (hasCustomDelimiter(input)) {
            customDelimiter(input)
        } else {
            defaultDelimiter(input)
        }
    }

    fun checkNegative() {
        val isPositive = values.all {
            it.toInt() >= 0
        }
        require(isPositive) { "음수 입력 불가" }
    }

    fun isNullOrBlank(): Boolean {
        return values.isEmpty() || values.first() == ""
    }

    fun isOneNumber(): Boolean {
        return values.size == 1
    }

    fun getOneNumber(): Int {
        return values[0].toInt()
    }

    private fun defaultDelimiter(input: String): List<String> {
        return input.split(",|:".toRegex())
    }

    private fun customDelimiter(input: String): List<String> {
        val result = Regex("//(.)\n(.*)").find(input)
        val customDelimiter = result!!.groupValues[1]
        return result.groupValues[2].split(customDelimiter)
    }

    private fun hasCustomDelimiter(input: String): Boolean {
        return Regex("//(.)\n(.*)").find(input) != null
    }
}

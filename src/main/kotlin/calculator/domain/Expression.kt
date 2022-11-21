package calculator.domain

class Expression(input: String) {
    var values = listOf<String>()
        private set

    init {
        values = if (hasCustomDelimiter(input)) {
            customDelimiter(input)
        } else {
            defaultDelimiter(input)
        }

        if (!isNullOrBlank()) {
            checkNegative()
        }
    }

    private fun checkNegative() {
        for (value in values) {
            println("${value.toInt()}")
            require(value.toInt() >= 1) { "음수 입력 불가" }
        }
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

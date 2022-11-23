package calculator

class Calculator {

    fun add(expression: String?): Int {
        if (expression.isNullOrBlank()) return 0
        if (expression.length == 1) return transform(expression)

        val numbers: List<String> = Tokenizer.tokenize(expression)
        return addNumbers(numbers)
    }

    @Throws(RuntimeException::class)
    private fun addNumbers(numbers: List<String>): Int {
        var result = 0
        numbers.forEach { numberString ->
            val number: Int = transform(numberString)
            result += number
        }
        return result
    }

    @Throws(RuntimeException::class)
    private fun transform(numberString: String): Int {
        val number = numberString.toIntOrNull() ?: throw RuntimeException("not number type !!")
        if (number < 0) throw RuntimeException("negative number !!")
        return number
    }
}

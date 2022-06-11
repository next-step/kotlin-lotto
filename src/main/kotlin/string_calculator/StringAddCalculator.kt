package string_calculator

object StringAddCalculator {
    fun add(text: String?): StringNumber {
        if (text.isNullOrBlank()) {
            return StringNumber.ZERO
        }

        val stringNumbers = StringSeparator.splitToDelimitersAndNumbers(text)
            .let { (delimiters, expression) ->
                expression.splitBy(delimiters)
            }

        return stringNumbers.addAll()
    }
}

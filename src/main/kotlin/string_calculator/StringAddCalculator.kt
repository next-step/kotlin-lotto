package string_calculator

class StringAddCalculator {
    fun add(text: String?): StringNumber {
        if (text.isNullOrBlank()) {
            return StringNumber.ZERO
        }

        val stringNumbers = StringSeparator.splitToDelimitersAndNumbers(text)
            .let { (delimiters, expression) ->
                Delimiters(delimiters).split(expression)
            }

        return stringNumbers.addAll()
    }
}

package stringaddcalculator.domain

data class Number(val text: String) {
    val number: Int = convertInt()

    init {
        validateNegative()
    }

    private fun convertInt(): Int {
        try {
            return text.toInt()
        } catch (ex: NumberFormatException) {
            throw IllegalStateException("$text is Not Number")
        }
    }

    private fun validateNegative() {
        if (number < 0) throw RuntimeException("$number is Negative")
    }
}

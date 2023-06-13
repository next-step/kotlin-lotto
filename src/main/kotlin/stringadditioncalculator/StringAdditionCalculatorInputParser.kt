package stringadditioncalculator

class StringAdditionCalculatorInputParser {

    fun parse(input: String?): List<String> {
        if (input.isNullOrBlank()) {
            return emptyList()
        }

        return input.split(delimiters = DEFAULT_DELIMITERS)
    }

    companion object {
        val DEFAULT_DELIMITERS = arrayOf(";", ",")
    }
}

package calculate

class StringAddCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) return NULL_OR_BLANK_RETURN

        val delimiterSetter = DelimiterSetter(input)
        val numbers = Splitter(delimiterSetter).numbers

        return Adder(numbers).result
    }

    companion object {
        private const val NULL_OR_BLANK_RETURN = 0
    }
}

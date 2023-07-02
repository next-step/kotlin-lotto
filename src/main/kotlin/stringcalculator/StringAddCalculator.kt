package stringcalculator

class StringAddCalculator {
    private lateinit var delimiters: Delimiters

    fun calculate(text: String?): Int {
        if (text.isNullOrEmpty()) return 0
        delimiters = StringParser.getDelimitersFromString(text)
        val parseText = StringParser.deleteCustomDelimiters(text)

        return parseText.split(delimiters.getDelimitersRegex()).sumOf {
            if (it.toInt() < 0) throw RuntimeException()
            it.toInt()
        }
    }
}

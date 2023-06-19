package stringcalculator

class StringAddCalculator {
    private val delimiters = Delimiters()
    fun calculate(text: String?): Int {
        if (text.isNullOrEmpty()) return 0
        val parseText = StringParser.deleteCustomDelimiters(text, delimiters)
        return parseText.split(delimiters.getDelimitersRegex()).sumOf {
            if (it.toInt() < 0) throw RuntimeException()
            it.toInt()
        }
    }
}

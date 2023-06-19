package stringcalculator

class StringAddCalculator {
    private val delimiters = Delimiters()
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return 0
        return text.split(delimiters.getDelimitersRegex()).sumOf {
            if (it.toInt() < 0) throw RuntimeException()
            it.toInt()
        }
    }
}

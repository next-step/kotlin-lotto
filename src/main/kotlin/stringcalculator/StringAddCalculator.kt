package stringcalculator

class StringAddCalculator {

    fun add(text: String): Int {
        if (text.isBlank()) return 0
        if (text.isEmpty()) return 0
        if (text.length == 1) return text.toInt()
        val splittext = text.split(",", ":")
        val result = Regex("//(.)\n(.*)").find(text)
        result?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)
            tokens.forEach { if (it.toInt() < 0) throw RuntimeException("$it is negative") }
            return tokens.map { it.toInt() }.sum()
        }
        splittext.forEach { if (it.toInt() < 0) throw RuntimeException("$it is negative") }
        return splittext.map { it.toInt() }.sum()
    }

    fun negativecheck(number: Int) {
        if (number < 0) throw RuntimeException("$number is negative")
    }
}

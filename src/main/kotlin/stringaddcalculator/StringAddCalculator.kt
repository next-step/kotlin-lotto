package stringaddcalculator

class StringAddCalculator {

    fun add(text: String?): Int? {
        if (text.isNullOrBlank()) return 0
        if (text.length == 1) return text.toIntOrNull()

        val result: MatchResult? = Regex("//(.)\n(.*)").find(text)
        result?.let {
            val customDelimiter: String = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)
            return addNumbers(tokens)
        }

        val numbers: List<String> = text.split("[,:]".toRegex())
        return addNumbers(numbers)
    }

    private fun addNumbers(text: List<String>): Int {
        var result = 0
        text.forEach { char -> result += char.toInt() }
        return result
    }
}

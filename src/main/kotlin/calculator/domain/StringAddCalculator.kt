package calculator.domain

class StringAddCalculator {

    private val customRegex = Regex("//(.)\n(.*)")

    fun add(text: String?): Int {
        if (text.isNullOrEmpty() || text.isNullOrBlank()) return 0

        val result = customRegex.find(text)

        result?. let {
            val customDelimiter = it.groupValues[1]
            val numberList = it.groupValues[2].split(customDelimiter)
            return numberList.sumOf { value -> value.toInt() }
        }

        val numberList = text.split(",", ":")

        return numberList.sumOf { it.toInt() }
    }
}

package stringaddcalculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        return parseAdd(text)
    }

    private fun parseAdd(text: String): Int {
        val customDelimiterGroup = Regex("//(.)\n(.*)").find(text)
        val basicPattern = "[,:]"

        customDelimiterGroup?.let {
            val customDelimiter = it.groupValues[1]
            val customRegex = "[$basicPattern$customDelimiter]".toRegex()
            val tokens = it.groupValues[2].split(customRegex)
            return addListElements(tokens)
        }

        val basicRegex = basicPattern.toRegex()
        val tokens = text.split(basicRegex)
        return addListElements(tokens)
    }

    private fun addListElements(list: List<String>): Int {
        return list.map { it -> it.toInt() }
            .sum()
    }
}

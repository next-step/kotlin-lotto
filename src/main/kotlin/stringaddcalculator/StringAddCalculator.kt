package stringaddcalculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }
        val stringTokens = parse(text)
        val intTokens = toIntTokens(stringTokens)
        return intTokens.sum()
    }

    private fun parse(text: String): List<String> {
        val basicPattern = "[,:]"

        val customDelimiterGroup = Regex("//(.)\n(.*)").find(text)
        customDelimiterGroup?.let {
            val customDelimiter = it.groupValues[1]
            val customRegex = "[$basicPattern$customDelimiter]".toRegex()
            return it.groupValues[2].split(customRegex)
        }

        val basicRegex = basicPattern.toRegex()
        return text.split(basicRegex)
    }

    private fun toIntTokens(list: List<String>): List<Int> {
        val intTokens = list.map { it.toIntOrNull() ?: throw RuntimeException("수식을 확인해주세요") }
        if (intTokens.any { it < 0 }) {
            throw RuntimeException("수식을 확인해주세요")
        }
        return intTokens
    }
}

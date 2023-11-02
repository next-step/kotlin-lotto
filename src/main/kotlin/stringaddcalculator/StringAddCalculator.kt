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
        val intTokens = list.map { it.toIntOrNull() ?: throw NumberFormatException("'$it'는 정수로 변환될 수 없습니다.") }
        if (intTokens.any { it < 0 }){
            throw RuntimeException("음수는 불가능합니다.")
        }
        return list.sumOf { it -> it.toInt() }
    }
}

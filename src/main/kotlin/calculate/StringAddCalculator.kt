package calculate

class StringAddCalculator {
    fun add(text: String?): Any {
        if (text.isNullOrEmpty()) {
            return 0
        }
        val startIndex = text.indexOf("//") + 2
        val endIndex = text.indexOf("\n")

        val result = if (startIndex >= 2 && endIndex >= 0 && startIndex < endIndex) {
            val customDelimiter = text.substring(startIndex, endIndex)
            text.substring(endIndex + 1).split(customDelimiter)
        } else {
            text.split(",", ":")
        }.sumOf { it.toInt() }

        require(result >= 0) {
            "결과는 0 이상이어야 합니다."
        }

        return result
    }
}

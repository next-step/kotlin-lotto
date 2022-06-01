package calculator

class StringCalculator {
    fun add(text: String): Int? {
        if (text.isEmpty()) {
            return 0
        }

        if (text.toIntOrNull() != null) {
            return text.toInt()
        }

        if (text.startsWith("//")) {
            val result = Regex("//(.)\n(.*)").find(text)
            return result?.let { it ->
                val customDelimiter = it.groupValues[1]
                val tokens = it.groupValues[2].split(customDelimiter)
                tokens.sumOf {
                    it.toIntOrNull() ?: throw IllegalArgumentException("계산할 값은 정수로 입력해야합니다. text: $text")
                }
            }
        }

        return text
            .split("[,:]".toRegex())
            .sumOf {
                it.toIntOrNull() ?: throw IllegalArgumentException("계산할 값은 정수로 입력해야합니다. text: $text")
            }
    }
}

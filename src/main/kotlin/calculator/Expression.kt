package calculator

@JvmInline
value class Expression private constructor(val value: List<String>) {
    companion object {
        private const val ZERO = "0"
        private const val COMMA = ","
        private const val COLON = ":"
        private val regex = Regex("//(.)\n(.*)")

        fun make(text: String?): Expression {
            if (text.isNullOrBlank()) {
                return Expression(listOf(ZERO))
            }
            return Expression(convertToStringNumber(text))
        }

        private fun convertToStringNumber(text: String): List<String> {
            val result = regex.find(text)
            result?.let {
                val customDelimiter = it.groupValues[1]
                return it.groupValues[2].split(customDelimiter)
            }
            return text.split(COLON, COMMA)
        }
    }
}

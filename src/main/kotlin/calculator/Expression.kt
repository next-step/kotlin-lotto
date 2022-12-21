package calculator

class Expression(private val list: List<String>) {

    fun compute(): Long {
        if (list.isEmpty()) return 0
        return list.sumOf { s -> verifyStringToLong(s) }
    }

    private fun verifyStringToLong(input: String): Long {
        val toLong = input.toLongOrNull() ?: throw IllegalArgumentException("수식에 문자($input)가 들어올 수 없습니다.")
        require(toLong >= NEGATIVE_STANDARD) { "수식에 음수($toLong)가 들어올 수 없습니다." }
        return toLong
    }

    companion object {
        private const val PRIMARY_DELIMITER = ",|:"
        private val CUSTOM_REGEX = "//(.)\\n(.*)".toRegex()
        const val NEGATIVE_STANDARD = 0

        fun of(mathematical: String): Expression {
            if (mathematical.isNullOrBlank()) return Expression(listOf())
            val separator = findSeparator(mathematical)
            val text = findMathematical(mathematical)
            return Expression(text.split(separator.toRegex()))
        }

        private fun findSeparator(mathematical: String): String {
            val pattern = CUSTOM_REGEX.find(mathematical)
            return pattern?.let {
                it.groupValues[1]
            } ?: PRIMARY_DELIMITER
        }

        private fun findMathematical(mathematical: String): String {
            if (!mathematical.contains(PRIMARY_DELIMITER.toRegex())) {
                val pattern = CUSTOM_REGEX.find(mathematical)
                val text = pattern?.let {
                    it.groupValues[2]
                }
                requireNotNull(text)
                return text
            }
            return mathematical
        }
    }

}
package calculator

class Expression(list: List<String>) {

    var list = list
        private set

    fun compute(): Long {
        return list.stream().mapToLong{ s -> verifyStringToLong(s) }.sum()
    }

    private fun verifyStringToLong(input: String): Long {
        var toLong: Long

        try {
            toLong = input.toLong()
        } catch (e : NumberFormatException) {
            throw IllegalArgumentException("수식에 문자(${input})가 들어올 수 없습니다.")
        }

        if(toLong < NEGATIVE_STANDARD) throw IllegalArgumentException("수식에 음수(${toLong})가 들어올 수 없습니다.")
        return toLong
    }

    companion object {
        private const val PRIMARY_REGEX = ",|:"
        private const val CUSTOM_REGEX = "//(.)\\n(.*)"
        const val NEGATIVE_STANDARD = 0

        fun of(mathematical: String): Expression {
            val separator = findSeparator(mathematical)
            var text = findMathematical(mathematical)
            return Expression(text.split(separator.toRegex()))
        }

        private fun findSeparator(mathematical: String): String {
            var pattern = Regex(CUSTOM_REGEX).find(mathematical)
            return pattern?.let{
                it.groupValues[1]
            } ?: PRIMARY_REGEX
        }

        private fun findMathematical(mathematical: String): String {
            if(!mathematical.contains(PRIMARY_REGEX.toRegex())) {
                var pattern = Regex(CUSTOM_REGEX).find(mathematical)
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
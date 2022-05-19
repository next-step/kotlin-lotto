class StringAddition(private val exp: String) {
    fun execute(): Int =
        matchCustomSplit(exp)
            ?.let { customSplitAndFold(it) }
            ?: splitAndFold(exp)

    private fun customSplitAndFold(includeCustomSplit: MatchResult): Int {
        val (split, exp) = includeCustomSplit.let {
            Pair(it.groupValues[1], it.groupValues[2])
        }
        return splitAndFold(exp, split)
    }

    private fun splitAndFold(exp: String, split: String = DEFAULT_SPLIT) =
        exp
            .takeIfNotEmpty()
            ?.split(replaceAndRegex(split))
            ?.toMapAndFold()
            ?: 0

    private fun matchCustomSplit(exp: String) = Regex(CUSTOM_PATTERN).find(exp)

    private fun replaceAndRegex(split: String): Regex =
        if (isDefaultSplit(split)) Regex(split)
        else Regex(REGEX_PREFIX + split)

    private fun isDefaultSplit(split: String) = split == DEFAULT_SPLIT

    private fun String.takeIfNotEmpty(): String? = takeIf { it.isNotEmpty() }

    private fun List<String>.toMapAndFold(initial: Int = 0): Int =
        map { it.toIntThrow() }
            .fold(initial) { total: Int, num: Int ->
                require(num >= 0)
                total + num
            }

    private fun require(condition: Boolean) {
        if (!condition) throw RuntimeException("음수는 입력할 수 없습니다.")
    }

    private fun String.toIntThrow() =
        try {
            this.toInt()
        } catch (e: Exception) {
            throw RuntimeException("구분자외에는 숫자만 입력해야합니다.")
        }

    companion object {
        private const val DEFAULT_SPLIT = "(,|:)"
        private const val CUSTOM_PATTERN = "//(.)\\n(.*)"
        private const val REGEX_PREFIX = "\\"
    }
}

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
        map { it.toInt() }
            .fold(initial) { total: Int, num: Int -> total + num }

    companion object {
        private const val DEFAULT_SPLIT = "(,|:)"
        private const val CUSTOM_PATTERN = "//(.)\\n(.*)"
        private const val REGEX_PREFIX = "\\"
    }
}

import util.findPattern
import util.takeIfNotEmpty
import util.toIntThrow

class StringAddition(private val exp: String) {
    fun execute(): Int {
        val (split, target) = exp.findPattern(CUSTOM_PATTERN).extract(default = exp)
        return add(target, split)
    }

    private fun MatchResult?.extract(default: String): Pair<String, String> {
        val split: String = this?.groupValues?.get(1) ?: DEFAULT_SPLIT
        val target: String = this?.groupValues?.get(2) ?: default
        return Pair(split, target)
    }

    private fun add(exp: String, split: String = DEFAULT_SPLIT) =
        exp
            .takeIfNotEmpty()
            ?.split(replaceAndRegex(split))
            ?.toMapAndReduce()
            ?: 0

    private fun replaceAndRegex(split: String): Regex =
        if (isDefaultSplit(split)) Regex(split)
        else Regex(REGEX_PREFIX + split)

    private fun isDefaultSplit(split: String) = split == DEFAULT_SPLIT

    private fun List<String>.toMapAndReduce(): Int =
        map { it.toIntThrow() }
            .reduce { total: Int, num: Int ->
                require(num >= 0)
                total + num
            }

    private fun require(condition: Boolean) {
        if (!condition) throw RuntimeException("음수는 입력할 수 없습니다.")
    }

    companion object {
        private const val DEFAULT_SPLIT = "(,|:)"
        private const val CUSTOM_PATTERN = "//(.)\\n(.*)"
        private const val REGEX_PREFIX = "\\"
    }
}

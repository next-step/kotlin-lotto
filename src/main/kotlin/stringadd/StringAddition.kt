package stringadd

import stringadd.util.findPattern
import stringadd.util.takeIfNotEmpty
import stringadd.util.toIntThrow

class StringAddition(private val text: String) {
    fun execute(): Int {
        val (regexText, target) = text.findPattern(CUSTOM_REGEX).extract(default = text)
        return target.takeIfNotEmpty()
            ?.split(addPrefix(regexText).toRegex())
            ?.map { it.toIntThrow() }
            ?.reduce { total: Int, num: Int ->
                require(num >= 0) { "음수는 입력할 수 없습니다." }
                total + num
            }
            ?: 0
    }

    private fun MatchResult?.extract(default: String): Pair<String, String> {
        return this?.destructured?.let { (regexText, target) ->
            regexText to target
        } ?: (DEFAULT_REGEX_TEXT to default)
    }

    private fun addPrefix(regex: String): String {
        return if (regex == DEFAULT_REGEX_TEXT) regex
        else REGEX_PREFIX + regex
    }

    companion object {
        private const val DEFAULT_REGEX_TEXT = "(,|:)"
        private val CUSTOM_REGEX = "//(.)\\n(.*)".toRegex()
        private const val REGEX_PREFIX = "\\"
    }
}

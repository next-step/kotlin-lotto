package lotto.utils

object StringUtil {
    private val BASIC_PATTERN = Regex(",")

    fun toInts(text: String): List<Int> = text.split(BASIC_PATTERN).map { it.toInt() }
}

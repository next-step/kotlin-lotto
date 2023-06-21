package lotto.utils

object StringUtils {

    fun replaceWhiteSpaceAndSplitByComma(target: String): List<String> {
        return target.trim().replace("\\s".toRegex(), "").split(",")
    }

    fun convertStringToInt(target: List<String>): List<Int> {
        return target.map { it.toInt() }
    }
}
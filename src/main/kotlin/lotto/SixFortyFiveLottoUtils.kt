package lotto

object SixFortyFiveLottoUtils {
    fun parseNumbersFromStr(str: String, delimiter: Char): List<Int> {
        return str.split(delimiter).map { it.toInt() }
    }
}

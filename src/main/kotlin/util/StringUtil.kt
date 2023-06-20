package util

import lotto.COMMA_SEPARATOR

object StringUtil {
    fun toIntList(inputString: String): List<Int> =
        inputString.split(COMMA_SEPARATOR).map { it.trim().toInt() }
}
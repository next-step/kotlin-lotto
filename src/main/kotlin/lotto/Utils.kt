package lotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber

object Utils {
    fun parseNumbersFromStr(str: String, delimiter: Char): List<SixFortyFiveNumber> {
        return str.split(delimiter).map { SixFortyFiveNumber(it.toInt()) }
    }
}

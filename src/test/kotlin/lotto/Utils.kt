package lotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber

object Utils {
    fun parseNumbersFromStr(str: String, delimiter: Char): SixFortyFiveLotto {
        return SixFortyFiveLotto(str.split(delimiter).map { SixFortyFiveNumber(it.toInt()) })
    }
}

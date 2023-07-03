package lotto.sixFortyFiveNumberLotto.purchase

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoType
import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber

sealed interface SixFortyFiveLottoPurchase {
    val type: SixFortyFiveLottoType
    fun getNumbers(): List<SixFortyFiveNumber>
}

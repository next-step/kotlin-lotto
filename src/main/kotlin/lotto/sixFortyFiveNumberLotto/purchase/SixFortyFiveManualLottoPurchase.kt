package lotto.sixFortyFiveNumberLotto.purchase

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoType
import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber

class SixFortyFiveManualLottoPurchase private constructor(
    override val type: SixFortyFiveLottoType,
    val numbers: List<SixFortyFiveNumber>,
) : SixFortyFiveLottoPurchase {
    companion object {
        fun of(numbers: List<SixFortyFiveNumber>): SixFortyFiveManualLottoPurchase {
            return SixFortyFiveManualLottoPurchase(SixFortyFiveLottoType.MANUAL, numbers)
        }
    }
}

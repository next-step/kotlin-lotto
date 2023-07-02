package lotto.sixFortyFiveNumberLotto.purchase

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoType
import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber

class SixFortyFiveManualLottoPurchase private constructor(
    override val type: SixFortyFiveLottoType,
    private val numbers: List<SixFortyFiveNumber>,
) : SixFortyFiveLottoPurchase {
    override fun getNumbers(): List<SixFortyFiveNumber> {
        return numbers
    }

    companion object {
        fun of(numbers: List<SixFortyFiveNumber>): SixFortyFiveManualLottoPurchase {
            return SixFortyFiveManualLottoPurchase(SixFortyFiveLottoType.MANUAL, numbers)
        }
    }
}

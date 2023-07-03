package lotto.sixFortyFiveNumberLotto.purchase

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoType
import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber

class SixFortyFiveAutoLottoPurchase private constructor(override val type: SixFortyFiveLottoType) :
    SixFortyFiveLottoPurchase {
    override fun getNumbers(): List<SixFortyFiveNumber> {
        return SixFortyFiveLotto.getNumbers()
    }

    companion object {
        fun of(): SixFortyFiveAutoLottoPurchase {
            return SixFortyFiveAutoLottoPurchase(SixFortyFiveLottoType.AUTO)
        }
    }
}

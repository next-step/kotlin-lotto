package lotto.sixFortyFiveNumberLotto.purchase

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoType

class SixFortyFiveAutoLottoPurchase private constructor(override val type: SixFortyFiveLottoType) :
    SixFortyFiveLottoPurchase {
    companion object {
        fun of(): SixFortyFiveAutoLottoPurchase {
            return SixFortyFiveAutoLottoPurchase(SixFortyFiveLottoType.AUTO)
        }
    }
}

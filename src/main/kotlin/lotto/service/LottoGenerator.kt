package lotto.service

import lotto.domain.BuyAmount
import lotto.domain.Lotto
import lotto.domain.Lottos

interface LottoGenerator {
    fun generateSingleLotto(): Lotto
    fun generate(buyAmount: BuyAmount): Lottos

    companion object {
        const val LOTTO_SIZE = 6
        const val RANGE_START = 1
        const val RANGE_END = 45
    }
}

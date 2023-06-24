package lotto.domain

import lotto.domain.lottoStrategy.LottoStrategy
import lotto.domain.lottoStrategy.NormalLottoStrategy

class LottoGame(
    lottoStrategy: LottoStrategy = NormalLottoStrategy,
    val lottoPrice: Long
) {
    init {
        require(lottoPrice % LOTTO_PRICE == 0L) { LOTTO_PRICE_NOT_FALL_APART_EXCEPTION }
    }

    companion object {
        const val LOTTO_PRICE = 1000L
        private const val LOTTO_PRICE_NOT_FALL_APART_EXCEPTION = "로또 개당 가격과 맞지 않는 금액입니다."
    }
}

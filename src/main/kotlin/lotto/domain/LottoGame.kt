package lotto.domain

import lotto.domain.lottoStrategy.LottoStrategy
import lotto.domain.lottoStrategy.NormalLottoStrategy

class LottoGame(
    private val lottoStrategy: LottoStrategy = NormalLottoStrategy,
    val lottoPrice: Long
) {
    lateinit var lottoList: LottoList
        private set

    init {
        require(lottoPrice % LOTTO_PRICE == 0L) { LOTTO_PRICE_NOT_FALL_APART_EXCEPTION }
        initLottoList()
    }

    private fun initLottoList() {
        val lottoCount = this.lottoPrice / LOTTO_PRICE
        lottoList = LottoList.of(lottoStrategy, lottoCount)
    }

    companion object {
        const val LOTTO_PRICE = 1000L
        private const val LOTTO_PRICE_NOT_FALL_APART_EXCEPTION = "로또 개당 가격과 맞지 않는 금액입니다."
    }
}

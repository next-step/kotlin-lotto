package lotto.domain

import lotto.domain.lottoStrategy.LottoStrategy
import lotto.domain.lottoStrategy.NormalLottoStrategy

class LottoGame(
    private val lottoStrategy: LottoStrategy = NormalLottoStrategy,
    val purchasePrice: Int
) {
    lateinit var lottoList: LottoList
        private set

    init {
        require(purchasePrice % LOTTO_PRICE == 0) { LOTTO_PRICE_NOT_FALL_APART_EXCEPTION }
        initLottoList()
    }

    private fun initLottoList() {
        val lottoCount = this.purchasePrice / LOTTO_PRICE
        lottoList = LottoList.of(lottoStrategy, lottoCount)
    }

    fun getResult(winningLotto: WinningLotto): LottoResult =
        lottoList.getResult(winningLotto)

    companion object {
        const val LOTTO_PRICE = 1000
        private const val LOTTO_PRICE_NOT_FALL_APART_EXCEPTION = "로또 개당 가격과 맞지 않는 금액입니다."
    }
}

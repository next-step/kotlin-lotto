package lotto.domain

import lotto.domain.lottoStrategy.LottoStrategy
import lotto.domain.lottoStrategy.NormalLottoStrategy

class LottoGame(
    private val lottoStrategy: LottoStrategy = NormalLottoStrategy,
    val purchasePrice: Int,
    lottoList: LottoList = LottoList(emptyList())
) {
    var lottoList: LottoList = lottoList
        private set

    init {
        require(purchasePrice % LOTTO_PRICE == 0) { LOTTO_PRICE_NOT_FALL_APART_EXCEPTION }
        require(lottoList.size() <= purchasePrice / LOTTO_PRICE)
        initAutoLottoList()
    }

    private fun initAutoLottoList() {
        val lottoCount = this.purchasePrice / LOTTO_PRICE - lottoList.size()
        val autoLottos = getAutoLottoList(lottoCount)

        this.lottoList + autoLottos
    }

    private fun getAutoLottoList(lottoCount: Int): LottoList = LottoList.of(lottoStrategy, lottoCount)

    fun getResult(winningLotto: WinningLotto): LottoResult {
        return lottoList.getResult(winningLotto)
    }

    companion object {
        const val LOTTO_PRICE = 1000
        private const val LOTTO_PRICE_NOT_FALL_APART_EXCEPTION = "로또 개당 가격과 맞지 않는 금액입니다."
    }
}

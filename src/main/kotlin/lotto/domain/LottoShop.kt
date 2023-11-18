package lotto.domain

import lotto.domain.strategy.DrawStrategy

class LottoShop(private val drawStrategy: DrawStrategy) {

    fun countBuyLotto(money: Int, manualLottoCount: Int): LottoPurchaseInfo {
        val lottoBuyTotalCount = money.div(LOTTO_PRICE)
        val autoLottoCount = lottoBuyTotalCount - manualLottoCount
        return LottoPurchaseInfo(autoLottoCount, manualLottoCount)
    }

    fun buyAutoLotto(autoLottoBuyCount: Int): Lottos = Lottos(List(autoLottoBuyCount) { drawStrategy.draw() })

    fun generateLottoNumbers(inputNumber: String, delimiters: String = ", "): Lotto {
        return Lotto(inputNumber.split(delimiters).map { LottoNumber(it.toInt()) })
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}

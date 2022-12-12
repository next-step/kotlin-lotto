package lotto.ui

import lotto.domain.*

object LottoController {
    fun applyLotto(purchasePrice: Int): Lottos {
        val purchaseCount = purchaseLotto(purchasePrice)
        val purchaseLottoList = MutableList(purchaseCount) { LottoGenerator.generate() }

        return Lottos(purchaseLottoList)
    }

    fun drawLotto(winningLottoNumbers: Set<LottoNumber>): Lotto {
        return Lotto(winningLottoNumbers)
    }

    fun announceLottoResult(purchaseLottos: Lottos, winningLotto: Lotto): LottoResult {
        val winningAmountStatistics = purchaseLottos.calculateWinningAmountStatistics(winningLotto)

        val lottoPurchaseAmount = purchaseLottos.calculatePurchaseAmount()
        val lottoWinningAmount = LottoWinningAmount(winningAmountStatistics)

        return LottoResult(lottoPurchaseAmount, lottoWinningAmount)
    }

    private fun purchaseLotto(purchasePrice: Int): Int {
        return LottoSaleMachine.purchase(purchasePrice)
    }
}

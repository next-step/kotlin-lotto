package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbersMatcher
import lotto.domain.LottoResult
import lotto.domain.LottoReward
import lotto.domain.LottoSaleMachine
import lotto.domain.LottoWinningAmount
import lotto.domain.Money

object LottoController {
    fun apply(purchasePrice: Int): List<Lotto> {
        val purchaseCount = purchaseLotto(purchasePrice)

        return MutableList(purchaseCount) {
            LottoGenerator.generate()
        }
    }

    fun draw(purchaseLottoList: List<Lotto>, winningLottoNumbers: Set<LottoNumber>): LottoResult {
        val winningLotto = Lotto(winningLottoNumbers)
        val lottoWinningAmount = getLottoWinningAmount(purchaseLottoList, winningLotto)

        return LottoResult(Money(purchaseLottoList.size * 1000), lottoWinningAmount)
    }

    private fun purchaseLotto(purchasePrice: Int): Int {
        return LottoSaleMachine.purchase(purchasePrice)
    }

    private fun getLottoWinningAmount(purchaseLottoList: List<Lotto>, winningLotto: Lotto): LottoWinningAmount {
        val winningAmountList = calculateWinningAmount(purchaseLottoList, winningLotto)

        return LottoWinningAmount(winningAmountList)
    }

    private fun calculateWinningAmount(ticketingLottoList: List<Lotto>, winningLotto: Lotto): Map<Money, Int> {
        var winningAmountList = mutableMapOf(
            LottoReward.MATCH_THREE.rewardPrice to 0,
            LottoReward.MATCH_FOUR.rewardPrice to 0,
            LottoReward.MATCH_FIVE.rewardPrice to 0,
            LottoReward.MATCH_SIX.rewardPrice to 0,
        )

        ticketingLottoList.forEach { ticketingLotto ->
            val matchCount = LottoNumbersMatcher.calculateMatchCount(ticketingLotto, winningLotto)
            var rewardPrice = LottoReward.of(matchCount).rewardPrice

            winningAmountList[rewardPrice] = (winningAmountList[rewardPrice] ?: 0) + 1
        }

        return winningAmountList
    }
}

package lotto.service

import lotto.domain.Lottos
import lotto.domain.WinningLotto
import lotto.vo.WinningLottoPrizeVO
import java.math.BigDecimal
import java.math.RoundingMode

class LottoMachine(
    val lottos: Lottos,
) {
    fun matchWinningLottoPrize(winningLotto: WinningLotto): List<WinningLottoPrizeVO> {
        val prizes = lottos.getWinningCountsByPrize(winningLotto)
        return prizes.map { (prize, winningLottoCount) ->
            WinningLottoPrizeVO(
                matchedCount = prize.matchedCount,
                prizeAmount = prize.prizeAmount,
                winningLottoCount = winningLottoCount,
                bonusMatched = prize.isBonusMatched(),
            )
        }
    }

    fun getTotalProfitRate(winningLotto: WinningLotto): BigDecimal {
        val totalPrizeAmount = lottos.getWinningPrizes(winningLotto).sumOf { it.prizeAmount }
        val purchaseAmount = LOTTO_PRICE * lottos.size
        return totalPrizeAmount.divide(purchaseAmount.toBigDecimal(), ROUND_SCALE, RoundingMode.HALF_UP)
    }

    companion object {
        private const val LOTTO_PRICE: Int = 1000
        private const val ROUND_SCALE = 2

        fun buy(purchaseAmount: Int, manualLottoNumbers: List<List<Int>>): LottoMachine {
            val autoLottoCount = (purchaseAmount / LOTTO_PRICE) - manualLottoNumbers.size
            require(autoLottoCount >= 0) { "구매금액($purchaseAmount)이 부족합니다. 수동 로또수: ${manualLottoNumbers.size}" }

            val autoLottos = Lottos.auto(autoLottoCount)
            val manualLottos = Lottos.manual(manualLottoNumbers)
            return LottoMachine(manualLottos + autoLottos)
        }
    }
}

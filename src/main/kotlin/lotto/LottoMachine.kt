package lotto

import java.math.BigDecimal

class LottoMachine(
    private val lottos: Lottos,
    private val winningLotto: WinningLotto,
) {
    fun matchWinningLottoPrize(): List<WinningLottoPrizeVO> {
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

    fun getTotalProfitRate(): BigDecimal {
        return lottos.getTotalProfitRate(winningLotto)
    }
}

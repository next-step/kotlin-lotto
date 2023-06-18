package lotto

import java.math.BigDecimal

class LottoMachine(
    private val lottos: Lottos,
    private val winningLotto: Lotto,
    private val bonusLottoNumber: LottoNumber,
) {
    fun matchWinningLottoPrize(): List<WinningLottoPrizeVO> {
        val prizes = lottos.getWinningCountsByPrize(winningLotto, bonusLottoNumber)
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
        return lottos.getTotalProfitRate(winningLotto, bonusLottoNumber)
    }
}

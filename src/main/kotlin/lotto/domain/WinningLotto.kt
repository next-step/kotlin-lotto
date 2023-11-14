package lotto.domain

import lotto.domain.dto.WinningResult
import lotto.domain.dto.WinningResults

class WinningLotto(private val winningNumbers: List<Int>, private val bonusBall: Int = NO_BONUS_BALL) {
    private val winLotto: Lotto = Lotto(winningNumbers.toSet())

    fun match(lotto: Lotto): LotteryPrizeAmount {
        val userNumbers = lotto.numbers
        val winningLottoNumbers = winLotto.numbers
        val count = userNumbers.count {
            winningLottoNumbers.contains(it)
        }

        var bonusMatch = false
        if (bonusBall != NO_BONUS_BALL) {
            val bonusNumber = LottoNumber.from(bonusBall)
            bonusMatch = userNumbers.contains(bonusNumber)
        }

        return LotteryPrizeAmount.getWinningPrize(count, bonusMatch)
    }

    fun matchLottosResult(lottos: Lottos): WinningResults {
        val lottoList = lottos.lottoList
        val statistics = mutableMapOf<LotteryPrizeAmount, Int>()
        val resultList = mutableListOf<WinningResult>()
        lottoList.forEach { lotto: Lotto ->
            val lotteryPrize = match(lotto)
            statistics[lotteryPrize] = statistics.getOrDefault(lotteryPrize, 0) + 1
        }

        LotteryPrizeAmount.values()
            .forEach {
                val count = statistics.getOrDefault(it, 0)
                val result = WinningResult(it.winNum, it.prize, count)
                resultList.add(result)
            }
        return WinningResults(resultList)
    }

    companion object {
        private const val NO_BONUS_BALL = 0
    }
}

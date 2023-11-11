package lotto.domain

import lotto.domain.dto.WinningResult

class WinningLotto(val winningNumbers: List<Int>) {
    fun match(lotto: Lotto): LotteryPrizeAmount {
        val userNumbers = lotto.numbers
        val count = userNumbers.count { lottoNumber ->
            winningNumbers.contains(lottoNumber.value)
        }

        return LotteryPrizeAmount.getWinningPrize(count)
    }

    fun matchLottosResult(lottos: Lottos): List<WinningResult> {
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
        return resultList
    }
}

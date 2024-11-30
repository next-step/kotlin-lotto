package lotto.model

import lotto.util.MathCalculator

class LottoSystem {
    fun calculateLottoCount(purchaseAmount: Int): Int = purchaseAmount / LOTTO_PRICE

    fun countLottosByMatchingNumbers(
        winningNumbers: List<Int>,
        lottos: List<Lotto>,
    ): Map<Int, Int> {
        require(winningNumbers.size == LOTTO_NUMBER_COUNT) { "당첨 번호는 ${LOTTO_NUMBER_COUNT}개의 숫자로 이루어져야 합니다." }
        val matchedLottoNumberCounts = mutableMapOf<Int, Int>()
        for (lotto in lottos) {
            val result = lotto.countMatchingNumbers(winningNumbers)
            if (result >= PRIZE_COUNT) {
                matchedLottoNumberCounts[result] = matchedLottoNumberCounts.getOrDefault(result, 0) + 1
            }
        }
        return matchedLottoNumberCounts
    }

    fun calculateReturnRate(
        matchedLottoNumberCounts: Map<Int, Int>,
        purchaseAmount: Int,
    ): Double {
        val prizeAmount = calculatePrizeAmount(matchedLottoNumberCounts)
        return MathCalculator.calculateRatio(
            numerator = prizeAmount.toDouble(),
            denominator = purchaseAmount.toDouble(),
            decimalPlaces = 2,
        )
    }

    private fun calculatePrizeAmount(matchedLottoNumberCounts: Map<Int, Int>): Int {
        var totalPrizeAmount = 0
        for ((matchCount, count) in matchedLottoNumberCounts) {
            val lottoMatch = LottoMatch.fromMatchCount(matchCount)
            if (lottoMatch != null) {
                totalPrizeAmount += lottoMatch.prizeAmount * count
            }
        }
        return totalPrizeAmount
    }

    private companion object {
        const val LOTTO_PRICE = 1000
        const val PRIZE_COUNT = 3
        const val LOTTO_NUMBER_COUNT = 6
    }
}

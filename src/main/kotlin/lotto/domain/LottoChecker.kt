package lotto.domain

object LottoChecker {
    fun checkResult(lottos: Lottos, winNumbers: WinNumbers): LottoResults {
        val resultMap = mutableMapOf<WinningPrize, Int>()
        lottos.forEach { lotto ->
            resultMap.addResult(lotto, winNumbers)
        }
        return LottoResults.of(resultMap, lottos.size * Lotto.LOTTO_PRICE)
    }

    private fun MutableMap<WinningPrize, Int>.addResult(lotto: Lotto, winNumber: WinNumbers) {
        val count = winNumber.getMatchCount(lotto)
        if (count >= Lotto.LOTTO_WINNING_MIN_COUNT) {
            val winningAmount = WinningPrize.of(count)
            this[winningAmount] = this.getOrDefault(winningAmount, 0) + 1
        }
    }
}

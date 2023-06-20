package lotto.domain

object LottoChecker {
    fun checkResult(lottos: Lottos, winNumbers: WinNumbers): WinLottoResults {
        val resultMap = lottos.groupBy { lotto ->
            val count = winNumbers.getMatchCount(lotto)
            val isBonusMatch = winNumbers.isBonusMatch(lotto)
            WinningPrize.of(count, isBonusMatch)
        }.mapValues { it.value.count() }
        return WinLottoResults.of(resultMap, lottos.size * Lotto.LOTTO_PRICE)
    }
}

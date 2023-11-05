package lotto.domain

object LottoAccountant {
    fun getTotalPrizeAmount(
        results: List<LottoResult>,
        prizeInfo: List<WinningPrize>
    ): Amount = results.fold(Amount(0)) { total, result ->
        total + result.getPrizeAmount(prizeInfo)
    }
}


package lotto.domain

object LottoStore {
    private const val LOTTO_PRICE = 1000

    fun generateLottosByAuto(cash: LottoCash): List<Lotto> {
        val count = cash.value / LOTTO_PRICE
        return (1..count).map {
            Lotto.auto()
        }
    }

    fun checkMatchResult(lottos: List<Lotto>, lastWeekMatchLotto: Lotto): List<LottoMatchCount> {
        return lottos.mapNotNull { lotto ->
            when (lotto.count { lastWeekMatchLotto.contains(it) }) {
                3 -> LottoMatchCount.THREE
                4 -> LottoMatchCount.FOUR
                5 -> LottoMatchCount.FIVE
                6 -> LottoMatchCount.SIX
                else -> null
            }
        }
    }
}

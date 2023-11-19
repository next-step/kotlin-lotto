package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.LottoCash
import lotto.domain.model.LottoMatchCount

object LottoStore {
    private const val LOTTO_PRICE = 1000

    fun isPurchasable(cash: LottoCash): Boolean {
        return cash.value >= LOTTO_PRICE
    }

    fun purchaseLottosByAuto(cash: LottoCash): List<Lotto> {
        val count = cash.value / LOTTO_PRICE
        return List(count) { Lotto.auto() }
    }

    fun checkMatchResult(lottos: List<Lotto>, lastWeekMatchLotto: Lotto): List<LottoMatchCount> {
        return lottos.map { lotto ->
            val matchCount = lotto.count { lastWeekMatchLotto.contains(it) }
            LottoMatchCount.from(matchCount)
        }
    }
}

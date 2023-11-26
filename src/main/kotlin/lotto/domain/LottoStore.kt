package lotto.domain

import lotto.domain.model.LastWeekMatchLotto
import lotto.domain.model.Lotto
import lotto.domain.model.LottoCash
import lotto.domain.model.Rank

object LottoStore {
    private const val LOTTO_PRICE = 1000

    fun isPurchasable(cash: LottoCash): Boolean {
        return cash.value >= LOTTO_PRICE
    }

    fun isNotPurchasable(cash: LottoCash): Boolean = !isPurchasable(cash)

    fun purchaseLottosByManual(cash: LottoCash, lottoNumbersByManual: List<List<Int>>): Pair<List<Lotto>, LottoCash> {
        val lottosByManual = lottoNumbersByManual.map {
            Lotto.valueOf(it)
        }
        val lottoPrice = lottosByManual.size * LOTTO_PRICE
        return lottosByManual to cash.purchase(lottoPrice)
    }

    fun purchaseLottosByAuto(cash: LottoCash): List<Lotto> {
        val count = cash.value / LOTTO_PRICE
        return List(count) { Lotto.auto() }
    }

    fun checkMatchResult(lottos: List<Lotto>, lastWeekMatchLotto: LastWeekMatchLotto): List<Rank> {
        return lottos.map { lotto ->
            lastWeekMatchLotto.match(lotto)
        }
    }
}

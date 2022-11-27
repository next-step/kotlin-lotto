package lotto.domain

import lotto.domain.LottoConstants.LOTTE_PRICE

object LottoFactory {
    fun purchaseLotto(amount: Int): List<Lotto> {
        val lottoCount: Int = amount / LOTTE_PRICE
        return List(lottoCount) { Lotto() }
    }
}

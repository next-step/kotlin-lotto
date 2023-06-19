package lotto.domain

import lotto.domain.model.Lotto

object LottoStore {
    fun buy(money: Int): List<Lotto> = List(money / Lotto.PRICE) { Lotto() }
}

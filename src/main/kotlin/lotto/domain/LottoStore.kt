package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.Money

object LottoStore {
    fun buy(money: Money): List<Lotto> = List(money.value / Lotto.PRICE) { Lotto(generateAuto()) }

    private fun generateAuto(): List<LottoNumber> {
        return (LottoNumber.FIRST_NUMBER..LottoNumber.LAST_NUMBER)
            .shuffled()
            .subList(0, Lotto.NUMBER_COUNT)
            .map { LottoNumber.from(it) }
    }
}

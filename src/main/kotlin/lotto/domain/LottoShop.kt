package lotto.domain

import lotto.LOTTO_PRICE
import lotto.LottoUtils.provideNumbers

object LottoShop {
    fun sellLottos(payment: Payment): List<Lotto> {
        val amount = quantitySold(payment)
        return (1..amount).map { Lotto(provideNumbers()) }
    }

    fun quantitySold(payment: Payment): Int = payment.money / LOTTO_PRICE
}

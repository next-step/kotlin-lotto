package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_NUMBERS_SIZE
import lotto.domain.LottoNumber.Companion.DEFAULT_RANGE

const val LOTTO_PRICE = 1_000

object LottoShop {

    fun sellTickets(payment: Payment, manualLottos: List<Lotto> = emptyList()): Lottos {
        val totalQuantity = payment.availableQuantity()
        val countOfAutoOrder = totalQuantity - manualLottos.size

        val autoLottos = makeAutoLottos(countOfAutoOrder)
        return Lottos(manualLottos + autoLottos)
    }

    private fun makeAutoLottos(autoOrder: Int): List<Lotto> {
        return (1..autoOrder).map { Lotto(makeAutoNumbers()) }
    }

    private fun makeAutoNumbers(): List<LottoNumber> {
        val numbers = DEFAULT_RANGE.shuffled().take(LOTTO_NUMBERS_SIZE).sorted()
        return numbers.map { LottoNumber.of(it) }
    }
}

package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_NUMBERS_SIZE
import lotto.domain.LottoNumber.Companion.DEFAULT_RANGE

class LottoShop(payment: Payment, private val manualLottos: List<Lotto>) {
    private val totalQuantity = payment.availableQuantity()
    private val lottos = mutableListOf<Lotto>()

    fun sellTickets(): List<Lotto> {
        addManualTickets()
        addAutoTickets()
        return lottos.toList()
    }

    private fun addManualTickets() {
        lottos.addAll(manualLottos)
    }

    private fun addAutoTickets() {
        val autoLottos = makeAutoTickets()
        lottos.addAll(autoLottos)
    }

    private fun makeAutoTickets(): List<Lotto> {
        val autoOrder = totalQuantity - manualLottos.size
        return (1..autoOrder).map { Lotto(makeAutoNumbers()) }
    }

    companion object LottoMachine {
        const val LOTTO_PRICE = 1_000

        private fun makeAutoNumbers(): List<LottoNumber> {
            val numbers = DEFAULT_RANGE.shuffled().take(LOTTO_NUMBERS_SIZE).sorted()
            return numbers.map { LottoNumber.of(it) }
        }
    }
}

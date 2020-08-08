package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_NUMBERS_SIZE
import lotto.domain.LottoNumber.Companion.DEFAULT_RANGE

class LottoShop(private val payment: Payment) {
    private val quantity = payment.affordableQuantity()

    fun sellTickets(): List<Lotto> {
        return (1..quantity).map { provideTicket() }
    }

    companion object LottoMachine {
        const val LOTTO_PRICE = 1_000

        private fun provideTicket(): Lotto {
            return Lotto(makeAutoNumbers())
        }

        private fun makeAutoNumbers(): List<LottoNumber> {
            val numbers = DEFAULT_RANGE.shuffled().take(LOTTO_NUMBERS_SIZE).sorted()
            return numbers.map { LottoNumber.of(it) }
        }
    }
}

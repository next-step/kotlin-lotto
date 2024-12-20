package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_RANGE
import lotto.domain.LottoTicket.Companion.COUNT_OF_NUMBERS_IN_LOTTO_TICKET

object GeneratorLottoNumbers {
    private val LOTTO_NUMBERS = LOTTO_NUMBER_RANGE.map { LottoNumber(it) }

    private fun getLottoNumbers(): List<LottoNumber> {
        return LOTTO_NUMBERS.shuffled().take(COUNT_OF_NUMBERS_IN_LOTTO_TICKET).toList()
    }

    fun generateRandomLottoTickets(count: Int): List<LottoTicket> {
        return List(count) {
            LottoTicket(getLottoNumbers())
        }
    }
}

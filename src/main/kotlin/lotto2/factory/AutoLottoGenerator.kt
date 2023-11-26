package lotto2.factory

import lotto2.domain.LottoNumbers
import lotto2.domain.LottoTicket

class AutoLottoGenerator(private val ticketQuantity: Int) : LottoFactory {

    override fun generate(): List<LottoTicket> {
        val randomNumbers = LottoNumbers.FULL_NUMBER_RANGE
            .shuffled()
            .take(LottoNumbers.MAIN_LOTTO_NUMBERS_COUNT)
            .sortedBy { it.number }

        return List(ticketQuantity) { LottoTicket(LottoNumbers(randomNumbers)) }
    }
}

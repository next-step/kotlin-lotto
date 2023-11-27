package lotto2.factory

import lotto2.domain.LottoNumber
import lotto2.domain.LottoNumbers
import lotto2.domain.LottoTicket

class AutoLottoGenerator(private val ticketQuantity: Int) : LottoFactory {

    override fun generate(): List<LottoTicket> {
        val randomNumbers = LottoNumber.ALL_NUMBERS
            .shuffled()
            .take(LottoNumbers.MAIN_LOTTO_NUMBERS_COUNT)
            .sortedBy { it.number }

        return List(ticketQuantity) { LottoTicket(LottoNumbers(randomNumbers)) }
    }
}

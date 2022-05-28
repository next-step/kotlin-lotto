package lotto.domain

import lotto.domain.collection.LottoTickets

object LottoTicketMachine {

    private val RANGE_OF_NUMBER = 1..45
    private const val SIZE_OF_LOTTO_NUMBER = 6

    fun generate(number: Int): LottoTickets {
        require(number > 0) {
            "1개 이상 구매해야 합니다."
        }

        return LottoTickets(
            List(number) {
                generateTicket()
            }
        )
    }

    private fun generateTicket(): LottoTicket {
        return LottoTicket(
            RANGE_OF_NUMBER.shuffled()
                .take(SIZE_OF_LOTTO_NUMBER)
                .sorted()
                .toSet()
        )
    }
}
